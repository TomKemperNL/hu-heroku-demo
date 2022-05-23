import { KoffieService } from './koffieservice.js'

let koffieService = new KoffieService()


let ulletje = document.querySelector('#koffielijst');
koffieService.getKoffieSoorten().then(koffiesoorten => {
    ulletje.innerHTML = '';
    for(let kf of koffiesoorten){
        ulletje.innerHTML += `<li>${kf.naam}</li>`
    }
})
console.log('doe tie het ?')
console.log(koffieService.MAX_KOFFIE_STERKTE)
