// https://localhost:8080/livres/all
// (1)the way of fetch() (2)the way of asyn fetch()
// (1)to show the info for the membre (2)to show the info for emprunt (3)to put all the info for the three parts within a button which will trigger the event to show the info

/* 1.DOM for Livre:  this part is the fetch() for livre: can be GET and POST(not required right now)*/

// console.log("loaded")
// to show the json in DOM by the function json
const divContenu = document.getElementById("divContenu")
let mesLivres;

 function afficherLivres(){
    console.log("afficher liver")
    clearDivContenuChildren(divContenu);
    // if(divContenu.textContent === ""){
    //      console.log("afficher liver null")
    //     divContenu.style.display = "block";

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
        // console.log(json)
        // use for to get every object in the tableu so that they can be shown one after another
        for(let livre of json){
            // console.log(livre)
            let livreElement = document.createElement("div");
        livreElement.textContent =livre.titre +"ISBN:"+ livre.isbn;

        let isbnP = document.createElement("P");// create an object to use its method and attributes, but the way is differente from java, here in js, the attributes won't be proposed automatiquely, should go to inspect-console to check which are the attributes belongs to the object, but the syntax is the same.
        isbnP.textContent = livre.isbn;

        let titreP = document.createElement("P");
        titreP.textContent =document.createElement("p");
       
        divContenu.appendChild(livreElement);// inject the child element for the parent element so that it can be shown clearly
        divContenu.appendChild(titreP);
        divContenu.appendChild(isbnP);

        // isbnP.classList.add("titre") // to create a style for the elements we would like to show 

            // afficherLivers(livre);
        }
    })
    

    .catch(error =>{
        console.error(error);}
    )

    // the method to be called in fetch() API by showing the DOM with content in html and styles in css
   
    // }else{
    //      console.log("afficher liver non null")
    //         divContenu.style.display ="none";
             
    // }
}

    // function afficherLivres(listLivre){
    //     let tableu = document.createElement("table");
    // }

    /* 2.DOM for Membre: this part is the fetch()API for Membre: can be GET and PSOT(not required in project) */ 

    // for the effect to show the content in every button one after another onclick,there are two way to do:
    // (1) with classList, we need to verify if the container is null or not before show the content, it is better to create everyenvent one its own container;then remove the classList(hidden):
    // if(divLiverContenu != ""){
            // divMembreContenu.classList.add("hidden");
            // divMembreContenu.classList.remove("hidden");
    // (2) if we use the same container, the virification will be easier and everytime, and need to verify wheather it is null or not, before show another content , then remove it.
    
    // if(divLiverContenu != ""){
    // divMembreContenu.classList.add("hidden");
    // divMembreContenu.classList.remove("hidden");
//    const divContenu = document.getElementById("divContenu");
//     // divContenu.setAttribute="class";
//     let mesMembre;

    //here should write the verification for the addEventListener("onclick",) for the button, to check if there is already the content, if so to remove it, then to show : they can be done in two ways, (1)first is to remove the container before showing, (2)second way is to use use classList.add() to call the style of "hidden" class written in the container 
   
    function afficherMembres(){
        clearDivContenuChildren(divContenu);
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
            // here can realise all the manipulation for DOM , for get the data , even the process of CRUD 
            for(let membre of json){
                let membreElement = document.createElement("div");
                membreElement.textContent ="Name:"+ membre.nom +"Prenom:" +membre.prenom;
                let nomP = document.createElement("p")
                nomP.textContent = membre.nom;
                let prenomP = document.createElement("p");
                prenomP.textContent = membre.prenom;

            divContenu.appendChild(membreElement);
            divContenu.appendChild(nomP);
            divContenu.appendChild(prenomP);
            }

        })
        .catch(error =>{
            console.error(error);}
        )
        }

    function clearDivContenuChildren(mydiv){
           if(mydiv.childElementCount > 0){
            let children = mydiv.childNodes;
            children.forEach(child => {
                mydiv.removeChild(child);
            });
           }
        }

    /* 3.DOM for Emprunt: this part is the fetch()API for Emprunt: can be GET and PSOT(not required in project) */ 

    