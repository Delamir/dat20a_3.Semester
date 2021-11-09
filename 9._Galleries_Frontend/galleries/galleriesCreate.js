const galleryFormParentDiv = document.getElementById("create-gallery-form");
const galleryFormExpandButton = document.getElementById("expand-gallery-form")
const createGalleryForm = `<form>
<h1>Create Gallery</h1>
<label>Name</label>
<input id="gallery-name" placeholder="Name">
<label>Owner</label>
<input id="gallery-owner" placeholder="Owner">
<label>Location</label>
<input id="gallery-location" placeholder="Location">
<label>Square Feet</label>
<input id="gallery-squareFeet" placeholder="Square Feet">
<button id="create-new-gallery" onclick="console.log('about to create a new gallery')">Create</button>
<button id="cancel-create" onclick="removeGalleryForm()">Cancel</button>
</form>
`;

function showGalleryForm() {
    galleryFormParentDiv.innerHTML = createGalleryForm;
    galleryFormExpandButton.style.display = "none";
}

function removeGalleryForm() {
    galleryFormExpandButton.style.display = "block";
    galleryFormParentDiv.innerHTML = "";
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
        }).then(response => response.json()).then(gallery => {
            addGalleryRow(gallery);
        }).catch(error => console.log("Network error", error));
    }

document.getElementById("expand-gallery-form")
    .addEventListener("click", showGalleryForm);