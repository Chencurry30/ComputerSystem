//将权限树中勾选的相关数据处理
export const getCheckTreeList = (TreeList,Result) =>{
    let list = []    //接收变量的数组
    let item = {}    //中间变量的对象
    let result = Result  //最终返回数据的数组
    list = TreeList
    list.forEach(element => {
        item.menuId = element.menuId
        result.push(item);
        item={}
    });
    return result;
} 