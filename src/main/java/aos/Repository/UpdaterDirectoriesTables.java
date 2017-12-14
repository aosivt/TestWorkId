package aos.Repository;


import aos.Entity.DateUpDownLink;
import aos.Util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;


import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

public class UpdaterDirectoriesTables {

    public static Collection<Directories> select(String nameEntity){

        Session session = HibernateUtil.getSessionFactory().withOptions()
                .jdbcTimeZone(TimeZone.getTimeZone("UTC")).openSession();
        List<Directories> serializables;
        String stringSelectEntities = "From " +
                nameEntity +
                " setEntity order by setEntity desc";
        Query query = session.createQuery(stringSelectEntities);
        serializables = (List<Directories>) query.list();
        session.clear();
        session.close();

        return serializables;
    }

    public static Serializable update(Serializable serializable) {
        Session session = HibernateUtil.getSessionFactory()
                .withOptions().jdbcTimeZone(TimeZone.getTimeZone("UTC"))
                .openSession();

        session.beginTransaction();
        session.saveOrUpdate(serializable);
        session.getTransaction().commit();
        session.clear();
        session.close();
        return serializable;
    }

    public static Serializable delete(Serializable serializable){

        try{
            Session session = HibernateUtil.getSessionFactory().withOptions()
                    .jdbcTimeZone(TimeZone.getTimeZone("UTC")).openSession();
            session.beginTransaction();
            session.remove(serializable);
            session.getTransaction().commit();
            session.clear();
            session.close();
        }catch (HibernateException he){
            System.err.println(he.getMessage());
        }

        return serializable;
    }
    public static Long getVolumeTraffic(
            String nameAbonent,
            String typeLink,
            LocalDateTime startPeriod,
            LocalDateTime endPeriod){

            Long returnResult;
            Session session = HibernateUtil.getSessionFactory().withOptions()
                    .jdbcTimeZone(TimeZone.getTimeZone("UTC")).openSession();


            StringBuilder sb = new StringBuilder();
            sb
                    .append("select sum(dudl.").append(typeLink).append(")")
                    .append(" From DateUpDownLink dudl")
                    .append(" where dudl.abonent.numTel= :nameAbonent")
                    .append(" and ")
                    .append(" dudl.infoDate between :startPeriod and :endPeriod");

            String stringSelectVolumeTraffic = sb.toString();

            Query query = session.createQuery(stringSelectVolumeTraffic)

                            .setParameter("nameAbonent", nameAbonent)
                            .setParameter("startPeriod",
                                    Date.from(startPeriod.atZone(ZoneId.systemDefault()).toInstant()))
                            .setParameter("endPeriod",
                                    Date.from(endPeriod.atZone(ZoneId.systemDefault()).toInstant()));

            returnResult = (Long)query.getSingleResult();
            session.clear();
            session.close();

        return returnResult;
    }

}

