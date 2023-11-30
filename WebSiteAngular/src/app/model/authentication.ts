export class Authentication {
    constructor(
        public id:number,
        public username:string,
        public roles:string[],
        public accessToken:string,
        public refreshToken:string,
        public tokenType:string
    ){}
}
