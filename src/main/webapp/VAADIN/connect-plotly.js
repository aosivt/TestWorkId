function test_con(data)
{

//console.log(data);
data = JSON.parse(data);
//alert(data[0]);
 var trace1 = {
//   x: data,
   y: data,
//   y: [10, 15, 13, 17],
   mode: 'lines+markers',
   name: 'Scatter + Lines'
 };

// var trace2 = {
//   x: '[2, 3, 4, 5]',
//   y: '[16, 5, 11, 9]',
//   mode: 'lines',
//   name: 'Lines'
// };

// var trace3 = {
//   x: [1, 2, 3, 4],
//   y: [12, 9, 15, 12],
//   mode: 'lines+markers',
//   name: 'Scatter + Lines'
// };

// var data = [ trace1, trace2, trace3 ];
 var data = [ trace1 ];

 var layout = {
   title:'Расчетное значение',
   height: 1400,
   width: 1480
 };
 $("#chart").data;
 Plotly.newPlot('chart', data, layout, 
   {
    transition: {
      duration: 500,
      easing: 'cubic-in-out',
    
    }
  });


//jQuery.ajax({
//    url: 'http://localhost:8080/greeting', //This URL is for Json file
//    type:"GET",
//    dataType: "json",
//    success: function(data) {
//        iterateJson(data);
//    },
//    error: function() {
//        alert("123")
//    }
//});

//Plotly.d3.json('http://localhost:8080/greeting',
//.header("type", "POST").header('Access-Control-Allow-Origin', "*")
//.get(
//function(figure){
//var trace1 = {
//  x: figure.e,
//  y: [10, 15, 13, 17],
//  mode: 'markers',
//  name: 'Scatter'
//};
//});
}

function iterateJson(data)
{
alert(data);
//    $.each(data, function() {
//            $.each(this, function(k, v) {
//                var capacity=v["_capacity"];
//
//
//          });
//     });

}