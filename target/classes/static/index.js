const form = document.getElementById("checkoutbooks");
const coDisplay = document.getElementById("checkoutdisplay");

async function booksDisplay(){
    coDisplay.innerHTML = "";
    const dataDisplay = await fetch("http://localhost:8080/books");
    const displayJson = await dataDisplay.json();
    console.log(displayJson);

    for(const key in displayJson) {
        if(displayJson.hasOwnProperty(key)){
            const value = displayJson[key];

            const para = document.createElement("p");
            para.textContent = `${key}: ${JSON.stringify(value)}`;

            coDisplay.appendChild(para);
        }
    }
}

booksDisplay();


async function postData(e) {
    e.preventDefault();
    const title = document.getElementById("bookTitle").value;
    const coDate = document.getElementById("checkoutDate").value;
    const coBy = document.getElementById("checkoutBy").value;
    const dueDate = document.getElementById("dueDate").value;
    console.log(title, coDate, coBy, dueDate);

    const url = "http://localhost:8080/books";

    try{
        const response = await fetch(url, {
            method: "POST",
            headers: {
                "Content-Type" : "application/json"
            },
            body: JSON.stringify({
                bookTitle: title,
                checkoutDate: coDate,
                checkoutBy: coBy,
                dueDate: dueDate
            })
        });

        if (response.ok) {

            document.getElementById("bookTitle").value="";
            document.getElementById("checkoutDate").value="";
            document.getElementById("checkoutBy").value="";
            document.getElementById("dueDate").value="";

            console.log("Data posted successfully");
        }else {
            console.log("Error occured while posting data");
        }
    }catch(error){
        console.log("Error occurred:", error);
    }
    await booksDisplay();
}
form.addEventListener("submit",postData);