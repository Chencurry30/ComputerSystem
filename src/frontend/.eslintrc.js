module.exports= {
    "env": {
        "browser": true,
        "es2021": true
    },
    "extends": [
        "eslint:recommended",
        "plugin:vue/vue3-essential"
    ],
    "overrides": [
    ],
    "parserOptions": {
        "ecmaVersion": "latest",
        "sourceType": "module"
    },
    "plugins": [
        "vue"
    ],
    "rules": {
      "eqeqeq": 2,//必须使用全等来判断 ===
      "no-var": 2,//禁用var，用let和const代替 var a = 1
      "no-console": 0,//可以使用console调试结果
      "no-dupe-keys": 2,//在创建对象字面量时不允许键重复{a:1,a:1}
      "no-dupe-args": 2,//函数参数不能重复 add(a,a)
      "no-func-assign": 2,//禁止重复的函数声明
      "no-redeclare": 2,//禁止重复声明变量
      "no-spaced-func": 2,//函数调用时 函数名与()之间不能有空格  如add()
      "no-undef": 1,//不能使用未定义的变量
      "no-use-before-define": 2,//变量未定义前不能使用
      "camelcase": 2,//强制驼峰法命名
      "consistent-this": [2, "that"],//禁止适用that为this的别名
      "id-match": 0,//命名检测
      "vue/multi-word-component-names":0, //关闭组件的命名检查规则
      "no-mutating-props":0,  //关闭对父组件传入子组件的参数在子组件中被修改
      "no-unde":0
    }
}
