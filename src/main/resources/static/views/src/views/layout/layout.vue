<template>
    <div>
        <header-layout></header-layout>
        <router-view :key="key"></router-view>
        <footer-layout></footer-layout>
    </div>
</template>

<script>
import header from './header'
import footer from './footer';
export default {
    name:'layout',
    components: { 'header-layout':header, 'footer-layout':footer },
    computed: {
    key() {
      return this.$route.fullPath
    }
  }
}
</script>

