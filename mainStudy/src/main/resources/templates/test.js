var client_id = 'studyapp';
var client_seceret = 'study1234'
var auth_header = 'Basic' + base64(urlEncode(client_id + ":" + client_secret))



var details = {
    'userName': 'studyjang@gmail.com', // 이 부분 유저주입으로 변경
    'password': 'test1234', // 이부분 유저주입으로 변경
    'grant_type': 'password', //고정
    'scope' : 'webclient' // 고정
};

var formBody = [];
for (var property in details) {
    var encodedKey = encodeURIComponent(property);
    var encodedValue = encodeURIComponent(details[property]);
    formBody.push(encodedKey + "=" + encodedValue);
}
formBody = formBody.join("&");

fetch('https://localhost:8090/user/oauth/token', {
    method: 'POST',
    headers: {
        'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8',
        'Authorization' : auth_header
    },
    body: formBody
})