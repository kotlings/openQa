const getters = {
  user: state => state.user  //这里面会映射到整个user模块的state，因为模块的写法会加上命名空间，即要映射token,则需要state =>state.user.token
}
export default getters
