<template>
  <a-config-provider :locale="zh_CN">
    <div id="app">
      <Header v-if="$route.meta.isAuth"/>
      <router-view/>
    </div>
  </a-config-provider>
</template>

<script>
  import Header from "./components/Header";
  import zh_CN from 'ant-design-vue/lib/locale-provider/zh_CN';
  import moment from 'moment';
  import 'moment/locale/zh-cn';

  moment.locale('zh-cn');
  export default {
    data(){
      return{
        zh_CN,
      }
    },
    components:{
      Header
    }
  }
</script>

<style>
  #app {
    overflow: auto;
    background-color: #F1F3F6;
    width: 100%;
    height: 100%;
  }
</style>
