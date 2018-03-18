document.getElementById("getPersonById").onclick = getAllPersons;
//document.getElementById("hobbyButton").onclick = ....
//document.getElementById("cityButton").onclick = ....
//document.getElementById("hobbyCountButton").onclick = ....
//document.getElementById("AllZipsButton").onclick = ....
//document.getElementById("hobbyButton").onclick = ....

function getAllPersons()
{
    var number = document.getElementById("personID").value;
    var url = "https://localhost:8084/CA2/api/person/complete/" + number;
    fetch(url)
    .then(result => result.json())
    .then(function(data)
    {
        var table = "<table>";
        table += "<tr><th>Id</th><th>FirstName</th><th>LastName</th><th>Email</th><th>Address</th><th>Phone</th><th>Hobby</th></tr>";
        table += "<tr>";
        table += `<td>${data.Fname}</td>`;
        table += `<td>${data.Lname}</td>`;
        table += `<td>${data.email}</td>`;
        table += "<td>";
        table += data.address.street + " ";
        table += data.address.additionalInfo + " ";
        table += data.address.cityInfoMessage.zip + " ";
        table += data.address.cityInfoMessage.city;
        table += "</td>";
        table += "<td>";
        for(var i = 0; i < data.PhoneNumbers.length; i++)
        {
            table += data.PhoneNumbers[i].number + " - " + data.PhoneNumbers[i].description;
            if(i != data.PhoneNumbers.length)
                table += "/";
        }
        table += "</td>";
        table += "<td>";
        for(var i = 0; i < data.hobbys.length; i++)
        {
            table += data.hobbys[i].name + " ";
            table += data.hobbys[i].description + " ";
        }
        table += "</td>";
        table += "</tr>";
        table += "</table>";
        document.getElementById("content").innerHTML = table;
    });
}
