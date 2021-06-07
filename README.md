# PermissionFlow

A convenient request permission library

下载源码后，添加以下配置，引入项目：
```groovy
dependencies {
    ...
    implementation project(':mylibrary')
}
```

在Activity或者Fragment中，使用如下：

```kotlin
            PermissionHelper.request(
                this,
                Manifest.permission.CALL_PHONE,
                Manifest.permission.READ_CONTACTS,
            ) { allPassed, deniedList ->
                if (allPassed) {
                    val callIntent = Intent(Intent.ACTION_CALL)
                    callIntent.data = Uri.parse("tel:10086")
                    startActivity(callIntent)
                } else {
                    Toast.makeText(this, "你拒绝了权限：$deniedList", Toast.LENGTH_SHORT).show()
                }
            }
```