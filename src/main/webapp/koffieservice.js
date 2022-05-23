export class KoffieService {
    MAX_KOFFIE_STERKTE = 10;

    getKoffieSoorten() {
        return fetch('http://localhost:8083/restservices/koffie')
            .then(r => {
                if(r.status === 200){
                    return r.json();
                }else{
                    return Promise.resolve([]);
                }
            }).catch(()=>{
                return Promise.resolve([])
            })
    }
}