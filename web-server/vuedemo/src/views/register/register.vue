<template>
  <div class="div-style">
    <form class = "form-signin">
        <img class="mb-4" src alt width="72" height="72">
        <h1 class="h3 mb-3 font-weight-normal">注册</h1>
        <div class="form-group">
        <label for="name">昵称</label>
        <input
          type="email"
          id="inputEmail"
          class="form-control"
          placeholder="昵称"
          required
          autofocus
          v-model="formDate.username"
        >
        </div>
        <div class="form-group">
        <label for="inputEmail" class="sr-only">用户名</label>
        <input
          type="email"
          id="inputEmail"
          class="form-control"
          placeholder="用户名"
          required
          autofocus
          v-model="formDate.username"
        >
        <p>*</p>
        </div>
        <div class="form-group">
        <label for="inputPassword" class="sr-only">密码</label>
        <input
          type="password"
          id="inputPassword"
          class="form-control"
          placeholder="密码"
          required
          v-model="formDate.password"
        >
        <p>*</p>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit" @click.prevent="register">注册</button>
        <span class="warning">{{warningText}}</span>
        <p class="mt-5 mb-3 text-muted">&copy; 2017-2019</p>
      
    </form>
  </div>
</template>
<script>
export default {
  data () {
    return {
      warningText: '',
      formDate: {
        username: '',
        password: ''
      },
      isRemember: false
    }
  },
  methods: {
    loginIn () {
      const self = this
      self.warningText = ''
      if (!self.formDate.username) {
        self.warningText = '请先输入用户名'
        return
      }
      if (!self.formDate.password) {
        self.warningText = '请先输入密码'
        return
      }
      // 调整username
      self.formDate.username = self.formDate.username.replace(/\s/g, '')
      // 调整password
      let params = {
        userName: self.formDate.username,
        password: self.formDate.password
      }
      this.$axios({
        url: '/lanyu/login/login.do',
        method: 'GET',
        params: params
      })
        .then(function (response) {
          let data = response.data
          if (data.success == true) {
            self.$router.push({ path: '/index' })
          } else {
            self.warningText = data.message
          }
        })
        .catch(function (error) {
          console.log(error)
        })
    }
  }
}
</script>
<style scoped>
@import "signin.css";
</style>
