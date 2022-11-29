import { v4 as uuidv4 } from 'uuid';
import Cryptopt from 'jsencrypt';

//其中的info为公钥 
export const CryAlgorithm = (info,data) =>{
  let publicKey =info;
  const encrypt = new Cryptopt();
  encrypt.setPublicKey(publicKey);
  return encrypt.encrypt(data);
}

//产生一个UUID 
export const createUUID = () =>{
  return uuidv4();
}

//提供公共的存储路径 
export const createPublicUrl = () =>{
  return 'https://system-1234.oss-cn-chengdu.aliyuncs.com/'
}