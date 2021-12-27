window.onload = function () {
    console.log(document.getElementById("role").innerText)
    if(document.getElementById("role").innerText === "ADMIN") {
        console.log(document.getElementById("adminFunctions").getAttribute("visibility"));
        document.getElementById("adminFunctions").setAttribute("visibility", "visible");
        console.log(document.getElementById("adminFunctions").getAttribute("visibility"));
    }
}