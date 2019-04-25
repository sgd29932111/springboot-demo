<template>
    <div class="div-style">
        <form class="form-signin">
  <img class="mb-4" src="./bootstrap-solid.svg" alt="" width="72" height="72">
  <h1 class="h3 mb-3 font-weight-normal">请登录</h1>
  <label for="inputEmail" class="sr-only">用户名</label>
  <input type="email" id="inputEmail" class="form-control" placeholder="username" required autofocus v-model="formDate.username">
  <label for="inputPassword" class="sr-only">密码</label>
  <input type="password" id="inputPassword" class="form-control" placeholder="Password" required v-model="formDate.password">
  <div>
    <label class="remember-me">
      <input type="checkbox" value="remember-me" v-model="isRemember"> 记住我
    </label>
    <label  class="register">
        <a>没有账号？立即注册</a>
    </label>
    <span class="warning">{{warningText}}</span>
  </div>
  <button class="btn btn-lg btn-primary btn-block" type="submit" @click.prevent="loginIn">登录</button>
  <p class="mt-5 mb-3 text-muted">&copy; 2017-2019</p>
</form>
</div>
</template>
<script>
export default {
    data() {
        return {
            warningText: "",
            formDate: {
                username: "",
                password: "",
                verifyCode: ""
            },
            isRemember: false
        };
    },
    methods: {
        loginIn() {
            const self = this;
            self.warningText = "";
            if (!self.formDate.username) {
                self.warningText = "请先输入用户名";
                return;
            }
            if (!self.formDate.password) {
                self.warningText = "请先输入密码";
                return;
            }
            //调整username
            self.formDate.username = self.formDate.username.replace(/\s/g, "");
            //调整password
            let params = {
                userName: self.formDate.username,
                password: self.formDate.password
            };
            this.$axios({
                    url: "/lanyu/login/login.do",
                    method: "GET",
                    params: params
                })
                .then(function(response) {
                    let data = response.data;
                    if (data.success == true) {
                        self.$router.push({ path: "/index" });
                    } else {
                        self.warningText = data.message;
                    }
                })
                .catch(function(error) {
                    console.log(error);
                });
        }
    }
}
</script>
<style scoped>
@import "signin.css"
</style>
