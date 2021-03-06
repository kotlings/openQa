Vue.component('editorImage', {
    props: {
        color: {
            type: String,
            default: '#1890ff'
        }
    },
    data() {
        return {
            dialogVisible: false,
            listObj: {},
            fileList: [],
        }
    },
    computed: {
        headers() {
            return {'X-Token': sessionStorage.token}
        }
    },
    methods: {
        checkAllSuccess() {
            return Object.keys(this.listObj).every(item => this.listObj[item].hasSuccess)
        },
        handleSubmit() {
            const arr = Object.keys(this.listObj).map(v => this.listObj[v])
            if (!this.checkAllSuccess()) {
                this.$message('请等待所有图片上传成功 或 出现了网络问题，请刷新页面重新上传！')
                return
            }
            this.$emit('successCBK', arr)
            this.listObj = {}
            this.fileList = []
            this.dialogVisible = false
        },
        handleSuccess(response, file) {
            const uid = file.uid
            const objKeyArr = Object.keys(this.listObj)
            for (let i = 0, len = objKeyArr.length; i < len; i++) {
                if (this.listObj[objKeyArr[i]].uid === uid) {
                    this.listObj[objKeyArr[i]].url = response.data
                    this.listObj[objKeyArr[i]].hasSuccess = true
                    return
                }
            }
        },
        handleRemove(file) {
            const uid = file.uid
            const objKeyArr = Object.keys(this.listObj)
            for (let i = 0, len = objKeyArr.length; i < len; i++) {
                if (this.listObj[objKeyArr[i]].uid === uid) {
                    delete this.listObj[objKeyArr[i]]
                    return
                }
            }
        },
        beforeUpload(file) {
            const _self = this
            const _URL = window.URL || window.webkitURL
            const fileName = file.uid
            this.listObj[fileName] = {}
            return new Promise((resolve, reject) => {
                const img = new Image()
                img.src = _URL.createObjectURL(file)
                img.onload = function () {
                    _self.listObj[fileName] = {
                        hasSuccess: false,
                        uid: file.uid,
                        width: this.width,
                        height: this.height
                    }
                }
                resolve(true)
            })
        }
    },

    /* 服务器配置等考虑暂时不提供图片上传服务,如果需要开启 请将 display: none 去除*/
    template: `
       <div class="upload-container"  style="display: none">
           
		   <el-button :style="{background:color,borderColor:color}"   
		    icon="el-icon-upload" size="mini" type="primary" @click=" dialogVisible=true">上传图片
		  </el-button>
		   <el-dialog :visible.sync="dialogVisible">
			<el-upload
			:multiple="true"
			:file-list="fileList"
			:show-file-list="true"
			:on-remove="handleRemove"
			:on-success="handleSuccess"
			:before-upload="beforeUpload"
			:headers="headers"
			class="editor-slide-upload"
			action="http://localhost:8889/api/upload/"
			list-type="picture-card">
			<el-button size="small" type="primary">点击上传</el-button>
			</el-upload>
			<el-button @click="dialogVisible = false">取 消</el-button>
			<el-button type="primary" @click="handleSubmit">确 定</el-button>
		   </el-dialog>
      </div>
    `
})
