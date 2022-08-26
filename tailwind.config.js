module.exports = {
  purge: [],
  darkMode: false, // or 'media' or 'class'
  theme: {
    extend: {
      colors:{
      },
      height:{          //自定义配置宽度
        '80':'30rem',
        '70':'26rem',       
      },
      backgroundSize: {
        'cover':'cover',
        '90': '100%',
      },
      screens: {
        'sm': '640px',
        'md': '768px',
        'lg': '1024px',
        'xl': '1280px',
        '2xl': '1536px',
        // 下面为自定义断点
        'sxm': '400px',
      },
      left:{
        '1/10':'10%'
      }
    },
  },
  variants: {
    extend: {},
  },
  plugins: [],
}
