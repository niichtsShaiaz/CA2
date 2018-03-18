document.getElementById("getPersonById").onclick = getPersonById;
document.getElementById("getAllPersons").onclick = getAllPersons;
document.getElementById("getContactById").onclick = getContactInfoById

function getPersonById()
{
    var number = document.getElementById("personID").value;
    var url = "http://localhost:8084/CA2/api/person/complete/" + number;
    fetch(url)
    .then(result => result.json())
    .then(function(data)
    {
        var table = "<table>";
        table += "<tr><th>Id</th><th>FirstName</th><th>LastName</th><th>Email</th><th>Address</th><th>Phone</th><th>Hobby</th></tr>";
        table += "<tr>";
        table += `<td>${data.id}</td>`;
        table += `<td>${data.fName}</td>`;
        table += `<td>${data.lName}</td>`;
        table += `<td>${data.email}</td>`;
        table += "<td>";
        table += data.address.street + " ";
        table += data.address.additionalInfo + " ";
        table += data.address.cityInfoMessage.zip + " ";
        table += data.address.cityInfoMessage.city;
        table += "</td>";
        table += "<td>";
        for(var i = 0; i < data.phoneNumbers.length; i++)
        {
            table += data.phoneNumbers[i].number + " - " + data.phoneNumbers[i].description;
            if(i != data.phoneNumbers.length)
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
        console.log(data);
    });
}

function getAllPersons()
{
    var url = "http://localhost:8084/CA2/api/person/complete";
    fetch(url)
    .then(result => result.json())
    .then(function(data)
    {
        console.log("2");
        console.log(data);
        var table = "<table>";
        table += "<tr><th>Id</th><th>FirstName</th><th>LastName</th><th>Email</th><th>Address</th><th>Phone</th><th>Hobby</th></tr>";
        for(var i = 0; i < data.length; i++) {
            table += "<tr>";
            table += `<td>${data[i].id}</td>`;
            table += `<td>${data[i].fName}</td>`;
            table += `<td>${data[i].lName}</td>`;
            table += `<td>${data[i].email}</td>`;
            table += "<td>";
            table += data[i].address.street + " ";
            table += data[i].address.additionalInfo + " ";
            table += data[i].address.cityInfoMessage.zip + " ";
            table += data[i].address.cityInfoMessage.city;
            table += "</td>";
            table += "<td>";
            for (var i = 0; i < data[i].phoneNumbers.length; i++) {
                table += data[i].phoneNumbers[i].number + " - " + data[i].phoneNumbers[i].description;
                if (i != data[i].phoneNumbers.length)
                    table += "/";
            }
            table += "</td>";
            table += "<td>";
            for (var i = 0; i < data[i].hobbys.length; i++) {
                table += data[i].hobbys[i].name + " ";
                table += data[i].hobbys[i].description + " ";
            }
            table += "</td>";
            table += "</tr>";
        }
        table += "</table>";
        document.getElementById("content").innerHTML = table;
        console.log(data);
    });
}

function getContactInfoById()
{
    var number = document.getElementById("personIDContact").value;
    var url = "http://localhost:8084/CA2/api/person/contactinfo/"+number; 
    fetch(url)
    .then(result => result.json())
    .then(function(data)
    {
        var table = "<table>";
        table += "<tr>";
        table += "<th>Firstname</th>";
        table += "<th>Lastname</th>";
        table += "<th>Email</th>";
        table += "<th>Phone</th>";
        table += "<th>Street</th>";
        table += "<th>AdditionalInfo</th>";
        table += "<th>Zip</th>";
        table += "<th>City</th>";
        table += "</tr>";

        table += "<tr>";
        table += `<td>${data.fName}</td>`;
        table += `<td>${data.lName}</td>`;
        table += `<td>${data.email}</td>`;
        table += "<td>";
        for(var i = 0; i < data.phoneList.length; i++)
        {
            table += data.phoneList[i].number + " - " + data.phoneList[i].description;
            if(i != data.phoneList.length)
                table += "/";
        }
        table += "</td>";
        table += `<td>${data.street}</td>`;
        table += `<td>${data.additionalInfo}</td>`;
        table += `<td>${data.zip}</td>`;
        table += `<td>${data.city}</td>`;
        table += "</tr>";
        table += "</table>";
        document.getElementById("content").innerHTML = table;
    });
}