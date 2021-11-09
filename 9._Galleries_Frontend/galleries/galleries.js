/*
const galleryWrapper = document.getElementById("gallery-wrapper");

fetch("http://localhost:8080/galleries")
    .then(response => response.json())
    .then(result => {
        console.log(result)
        result.map(gallery => {
            const galleryElement = document.createElement("div");
            galleryElement.innterHTML = `
            <p>${escapeHTML(gallery.name)}</p>
            <p>${escapeHTML(gallery.location)}</p>
            `;

            galleryWrapper.appendChild(galleryElement);
        })
    });

 */

const galleryBody = document.getElementById("gallery-body");
const galleryCreate = document.getElementById("create-gallery-button");

fetch( baseURL + "/galleries")
    .then(response => response.json())
    .then(galleries => {
        console.log(galleries);
        galleries.map(gallery => {
            const galleryT = document.createElement("tr");

            galleryT.innerHTML = `
               <td> <a href="./gallery.html?id=${gallery.id}">${escapeHTML(gallery.name)}</a></td>
               
                    <td>${escapeHTML(gallery.owner)}</td>
                    <td>${escapeHTML(gallery.location)}</td>
                    <td>${escapeHTML(gallery.squareFeet.toString())}</td>
                    <td>
                        <button onclick="deleteGallery(${gallery.id})">DELETE</button>
                    </td>
            `;

            galleryBody.appendChild(galleryT);

        });

    });

function deleteGallery(galleryId) {
    console.log(galleryId)
}

function createGallery() {
   fetch(baseURL + "/galleries", {
       method: "POST",
       headers: {
           "Content-type": "application/json; charset=UTF-8"
       },
       body: JSON.stringify({
           name: "Gallery",
           owner: "Christian",
           location: "Copenhagen",
           squareFeet: 50
       })
   }).then(response => response.json()).then(result => {

   });
}

document.getElementById("create-gallery-button")
.addEventListener("click", createGallery);