
import servers from './Servers'


//获取院校信息
export const getSchoolList = (page) =>{
  const url = `/colleges/pages/${page}`
  return servers.get(url)  
}

// {
//  data:[
//   {分类:[
//       {数学}
//       {政治}
//     ]
//   }




// ] 
// }