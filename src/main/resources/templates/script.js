// https://localhost:8080/livres/all
// TODO: (1)to show the info for the membre (2)to show the info for emprunt

/* 1.DOM for Livre:  this part is the fetch() for livre: can be GET and POST(not required right now)*/

console.log("loaded")
// to show the json in DOM by the function json
const divLivreContenu = document.getElementById("livreContenu")
let mesLivres;

fetch("http://localhost:8080/api/livres/all")

    .then(response => {
        if(!response.ok){
            throw new Error("Error Server");
        }
        return response.json();
    })

    .then(json =>{
        // here to show how to show the book
        mesLivres = json;
        console.log(json)
        // use for to get every object in the tableu so that they can be shown one after another
        for(let livre of json){
            // console.log(livre)
            afficherLivers(livre);
        }
    })

    .catch(error =>{
        console.error(error);}
    )

    // the method to be called in fetch() API by showing the DOM with content in html and styles in css
    function afficherLivers(livre){
        let livreElement = document.createElement("div");
        livreElement.textContent =livre.titre +"ISBN:"+ livre.isbn;

        let isbnP = document.createElement("P");// create an object to use its method and attributes, but the way is differente from java, here in js, the attributes won't be proposed automatiquely, should go to inspect-console to check which are the attributes belongs to the object, but the syntax is the same.
        isbnP.textContent = livre.isbn;

        let titreP = document.createElement("P");
        titreP.textContent =document.createElement("p");
       
        divLivreContenu.appendChild(livreElement);// inject the child element for the parent element so that it can be shown clearly
        divLivreContenu.appendChild(titreP);
        divLivreContenu.appendChild(isbnP);

        isbnP.classList.add("titre") // to create a style for the elements we would like to show 

    }

    // function afficherLivres(listLivre){
    //     let tableu = document.createElement("table");
    // }

    /* 2.DOM for Membre: this part is the fetch()API for Membre: can be GET and PSOT(not required in project) */ 

    // const divMembreContenu = document.getElementById("membreContenu");
    // let mesMembre;

    fetch("http://localhost:8080/api/membres/all")
        .then(response =>{
            if(!response.ok){
                throw new Error("Error Server")
            }
            return response.json();
        })

        .then(json =>{
            mesMembre = json;
            console.log(mesMembre);

        })
        .catch(error =>{
            console.error(error);}
        )



    /* 3.DOM for Emprunt: this part is the fetch()API for Emprunt: can be GET and PSOT(not required in project) */ 

    