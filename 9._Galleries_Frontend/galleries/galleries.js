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


fetch( baseURL + "/galleries")
    .then(response => response.json())
    .then(galleries => {
        console.log(galleries);
        galleries.map(addGalleryRow);

    });

function addGalleryRow(gallery) {

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
        galleryT.id = gallery.id;
        galleryBody.appendChild(galleryT);
}

function deleteGallery(galleryId) {
    fetch(baseURL + "/galleries/" + galleryId, {
        method: "DELETE"
    }).then(response => {
        if (response.status === 200) {
            document.getElementById(galleryId).remove();
        } else {
            console.log(response.status);
        }
    })

}