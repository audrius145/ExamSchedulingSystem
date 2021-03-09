var zero = 0;
$(document).ready(function () {
    $(window).on('scroll', function () {
        $('.navbar').toggleClass('hide', $(window).scrollTop() > zero);
        zero = $(window).scrollTop();
    })
});
readXML();

function readXML() {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            showData(this);
        }
    };
    xhttp.open("GET", "exams.xml", true);
    xhttp.send();
}

function showData(xml) {
    var xmlDoc = xml.responseXML;
    var a = xmlDoc.getElementsByTagName("Examiner");
    var b = xmlDoc.getElementsByTagName("Class");
    var c = xmlDoc.getElementsByTagName("Course");
    var d = xmlDoc.getElementsByTagName("Room");
    var e = xmlDoc.getElementsByTagName("Date");
    txt = "<tr><th>Class</th><th>Course</th><th>Date</th><th>Examiner</th><th>Room</th>";
    for (var i = 0; i < a.length; i++) {
        txt += "<tr><td>" + b[i].childNodes[0].nodeValue + "</td><td>" + c[i].childNodes[0].nodeValue + "</td><td>" + e[i].childNodes[0].nodeValue + "</td><td>" + a[i].childNodes[0].nodeValue + "</td><td>" + d[i].childNodes[0].nodeValue + "</td></tr>";
    }
    document.getElementById("schd").innerHTML += txt;
}

function filter(){
    var input, filter, table, tr, td, i, txtValue;
  input = document.getElementById("input");
  filter = input.value.toUpperCase();
  table = document.getElementById("schd");
  tr = table.getElementsByTagName("tr");

  // Loop through all table rows, and hide those who don't match the search query
  for (i = 1; i < tr.length; i++) {
    // Hide the row initially.
    tr[i].style.display = "none";

    td = tr[i].getElementsByTagName("td");
    for (var j = 0; j < td.length; j++) {
      cell = tr[i].getElementsByTagName("td")[j];
      if (cell) {
        if (cell.innerHTML.toUpperCase().indexOf(filter) > -1) {
          tr[i].style.display = "";
          break;
        } 
      }
    }
}
}