import * as crypto from 'crypto';
const aes_algorithm = "aes-128-ecb";
const aes_secrect = "abcdefghijklmnopqrstuvwxyz123456";
 
export  function  encrypt(text) {
 var cipher = crypto.createCipher(aes_algorithm, aes_secrect)
 var crypted = cipher.update(text, 'utf8', 'hex')
 crypted += cipher.final('hex');
 return crypted;
};
 
export   function decrypt(text) {
 var decipher = crypto.createDecipher(aes_algorithm, aes_secrect)
 var dec = decipher.update(text, 'hex', 'utf8')
 dec += decipher.final('utf8');
 return dec;
};