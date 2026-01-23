// console.log("loaded")

const divContenu = document.getElementById("divContenu")
let mesLivres;

/*************************for livreBtn*************************************************/

/* 1.DOM for Livre:  */

function afficherLivres() {
    clearDivContenuChildren(divContenu);

    fetch("http://localhost:8080/api/livres/all")
        .then(response => {
            if (!response.ok) {
                throw new Error("Error Server");
            }
            return response.json();
        })
        .then(json => {
            mesLivres = json;

            const table = document.createElement("table");
            table.className = "table table-striped table-hover table-bordered";

            const thead = document.createElement("thead");
            thead.className = "thead-dark";

            thead.innerHTML = `
        <tr>
           <th>ID</th>
           <th>TITRE</th>
           <th>AUTEUR</th>
           <th>ISBN</th>
           <th>ANNEE PUBLICATION</th>
           <th>CATEGORIE</th>
           <th>EXEMPLAIRES TOTAL</th>
           <th>EXEMPLAIRE DISPONIBLE</th>
        </tr>   
        `;

            const tbody = document.createElement("tbody");

            for (let livre of json) {
                const tr = document.createElement("tr");
                tr.className = "table-primary";

                tr.innerHTML = `
            <tr>
            <td>${livre.id}</td>
            <td>${livre.titre}</td>
            <td>${livre.auteur}</td>
            <td>${livre.isbn}</td>
            <td>${livre.anneePublication}</td>
            <td>${livre.categorie}</td>
            <td>${livre.exemplairesTotal}</td>
            <td>${livre.exemplairesDisponibles}</td>
            </tr>
            `;

                tbody.appendChild(tr);
            }

            table.appendChild(thead);
            table.appendChild(tbody);
            divContenu.appendChild(table);
        })
        .catch(error => {
            console.log(error);
        })
}

/***************************for membreBtn*********************************************/
//2.DOM for Membre:  */

function afficherMembres() {
    clearDivContenuChildren(divContenu);
    fetch("http://localhost:8080/api/membres/all")
        .then(response => {
            if (!response.ok) {
                throw new Error("Error Server")
            }
            return response.json();
        })

        .then(json => {
            mesMembre = json;
            console.log(mesMembre);
            // here can realise all the manipulation for DOM , for get the data , even the process of CRUD 
            for (let membre of json) {
                let membreElement = document.createElement("div");
                membreElement.textContent = "Name:" + membre.nom + "Prenom:" + membre.prenom;
                let nomP = document.createElement("p")
                nomP.textContent = membre.nom;
                let prenomP = document.createElement("p");
                prenomP.textContent = membre.prenom;

                divContenu.appendChild(membreElement);
                divContenu.appendChild(nomP);
                divContenu.appendChild(prenomP);
            }

        })
        .catch(error => {
            console.error(error);
        }
        )
}


/*******************************for empruntBtn******************************************************/
/* 3.DOM for Emprunt: show only the emprunt en cours.this part is the fetch()API for Emprunt: can be GET and PSOT(not required in project) */

function afficherEmpruntEnCours() {
    clearDivContenuChildren(divContenu);
    fetch("http://localhost:8080/api/emprunts/encours")
        .then(response => {
            if (!response.ok) {
                throw new Error("Error Server")
            }
            return response.json();
        })

        .then(json => {
            mesEmpruntEnCours = json;

            for (let empruntEnCours of json) {
                console.log(empruntEnCours)

                let empruntElementEnCours = document.createElement("div");
                empruntElementEnCours.textContent = "Date of return required:" + empruntEnCours.dateRetourPrevue + "Date of Borrow: " + empruntEnCours.dateEmprunt;

                let dateEmpruntP = document.createElement("p");
                dateEmpruntP.textContent = empruntEnCours.dateEmprunt;
                let dateRetourPrevueP = document.createElement("p");
                dateRetourPrevueP.textContent = empruntEnCours.dateRetourPrevue;

                divContenu.appendChild(empruntElementEnCours);
                divContenu.appendChild(dateEmpruntP);
                divContenu.appendChild(dateRetourPrevueP);
            }
        })

        .catch(error => {
            console.error(error);
        })
}

/************************empruntEnRetardDayBtn********************************/
// /* 4.DOM for Emprunt: show only the emprunt en cours.*/

function affercherEmpruntEnRetardDays() {
    //to vide the div
    clearDivContenuChildren(divContenu);
    //to get the method of emprunt en retard by fetch() API
    fetch("http://localhost:8080/api/emprunts/enRetard")
        .then(response => {
            if (!response.ok) {
                throw new Error("Error Server");
            }
            return response.json();
        })

        .then(json => {
            mesEmpruntEnRetard = json;

            for (let empruntEnRetard of json) {
                console.log(empruntEnRetard);

                let empruntElementEnretard = document.createElement("div");

                let retard = joursRetard(empruntEnRetard.dateRetourPrevue)

                let empruntElementEnretardIdP = document.createElement("p");
                empruntElementEnretardIdP.textContent = "Id of borrow:" + empruntEnRetard.id;

                let empruntElementEnretardDateEmpruntp = document.createElement("p");
                empruntElementEnretardDateEmpruntp.textContent = "with borrow date :" + empruntEnRetard.dateEmprunt;

                let empruntElementEnretardDateRetourPrevuep = document.createElement("p");
                empruntElementEnretardDateRetourPrevuep.textContent = "should be return as required in: " + empruntEnRetard.dateRetourPrevue;

                let empruntElementEnretardJoursRetardp = document.createElement("p")
                empruntElementEnretardJoursRetardp.textContent = "Days of been late is :" + retard;

                empruntElementEnretard.appendChild(empruntElementEnretardIdP);
                empruntElementEnretard.appendChild(empruntElementEnretardDateEmpruntp);
                empruntElementEnretard.appendChild(empruntElementEnretardDateRetourPrevuep);
                empruntElementEnretard.appendChild(empruntElementEnretardJoursRetardp);

                divContenu.appendChild(empruntElementEnretard);

            }
        })
        .catch(error => {
            console.error(error);
        });
}
//to show how many days has been lated
function joursRetard(dateRetourPrevue) {
    let datePrevue = new Date(dateRetourPrevue);
    let currentDate = new Date();

    let milleSecondsDif = currentDate - datePrevue;
    let jours = Math.floor(milleSecondsDif / (1000 * 60 * 60 * 24));
    return jours > 0 ? jours : 0;
}


/************************the fifth button to show all searching area**********************************************************************/

/*****searching liver by titre****************************/
/*****filter by categorie*********************************/
/*****afficher les emprunts d'un membre spécifique********/

/******avancé*********************************************/
/*****formulaire pour ajouter nouveau livre***************/
/*****formulaire pour ajouter nouveau membre**************/
/*****enregistrer un nouvel emprunt***********************/
/*****update un emprunt for dateRetourEffective***********/
/*****afficher le statistiques(all livre, membre actif, taux d'emprunt)********/

/**********************function for remove the div*********************************************************************************/
function clearDivContenuChildren(mydiv) {
    mydiv.innerHTML = "";

}