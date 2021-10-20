function getKanyeQuote() {
    fetch("https://api.kanye.rest/")
        .then(response => response.json())
        .then(result => result.quote)
        .then(quote => {
            const kanyeQuotes = document.getElementById("kanye-quote");
            kanyeQuotes.innerText = quote;
        });
}

getKanyeQuote();

setInterval(getKanyeQuote, 5000)
//const clickButton = document.getElementById("butan");
//clickButton.addEventListener("click", getKanyeQuote)

function addQuoteToList(listName) {
    const quote = document.getElementById("kanye-quote").innerText;
    const paragraph = document.createElement("p");
    paragraph.innerText = quote;

    const listWrapper = document.getElementById(listName);

    listWrapper.prepend(paragraph);
}

document.getElementById("btn-laugh").addEventListener("click", () => addQuoteToList("list-laugh"));
document.getElementById("btn-wtf").addEventListener("click", () => addQuoteToList("list-wtf"));
document.getElementById("btn-horny").addEventListener("click", () => addQuoteToList("list-horny"));



