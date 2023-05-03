
export class Fetch {

    baseURL = 'https://api.hktreewatch.org/'
    constructor(endpoint,method,body) {
    this.endpoint = endpoint
    this.method = method
    this.body = body
    this.url = this.baseURL + this.endpoint
}

async getMasterTreeList() {
    console.log('Getting master tree list')
    const resp = await fetch(this.url,{method:this.method}) 
    const {data} = await resp.json()
    console.log(data)
}


}
