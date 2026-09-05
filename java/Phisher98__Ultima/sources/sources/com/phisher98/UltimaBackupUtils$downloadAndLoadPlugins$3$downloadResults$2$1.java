package com.phisher98;

import android.content.Context;
import com.lagradost.api.Log;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.plugins.PluginData;
import com.lagradost.cloudstream3.plugins.PluginManager;
import com.lagradost.cloudstream3.plugins.PluginWrapper;
import com.lagradost.cloudstream3.plugins.SitePlugin;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.sync.Semaphore;
import okhttp3.Interceptor;
import okhttp3.ResponseBody;

/* JADX INFO: compiled from: UltimaBackupUtils.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/Ultima/classes.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lkotlin/Triple;", "Lcom/lagradost/cloudstream3/plugins/PluginData;", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.phisher98.UltimaBackupUtils$downloadAndLoadPlugins$3$downloadResults$2$1", f = "UltimaBackupUtils.kt", i = {0, 1, 1, 1, 1, 1, 1}, l = {950, 566}, m = "invokeSuspend", n = {"$this$withPermit$iv", "$this$withPermit$iv", "localFile", "targetUrl", "downloadUrl", "tempFile", "match"}, nl = {951, 567}, s = {"L$0", "L$0", "L$2", "L$3", "L$4", "L$5", "L$6"}, v = 2)
@SourceDebugExtension({"SMAP\nUltimaBackupUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UltimaBackupUtils.kt\ncom/phisher98/UltimaBackupUtils$downloadAndLoadPlugins$3$downloadResults$2$1\n+ 2 Semaphore.kt\nkotlinx/coroutines/sync/SemaphoreKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,949:1\n81#2,3:950\n85#2,2:954\n1#3:953\n*S KotlinDebug\n*F\n+ 1 UltimaBackupUtils.kt\ncom/phisher98/UltimaBackupUtils$downloadAndLoadPlugins$3$downloadResults$2$1\n*L\n539#1:950,3\n539#1:954,2\n*E\n"})
final class UltimaBackupUtils$downloadAndLoadPlugins$3$downloadResults$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Triple<? extends PluginData, ? extends Boolean, ? extends Boolean>>, Object> {
    final /* synthetic */ List<PluginWrapper> $allOnlinePlugins;
    final /* synthetic */ Context $context;
    final /* synthetic */ Semaphore $downloadSemaphore;
    final /* synthetic */ PluginData $plugin;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    UltimaBackupUtils$downloadAndLoadPlugins$3$downloadResults$2$1(Semaphore semaphore, List<PluginWrapper> list, Context context, PluginData pluginData, Continuation<? super UltimaBackupUtils$downloadAndLoadPlugins$3$downloadResults$2$1> continuation) {
        super(2, continuation);
        this.$downloadSemaphore = semaphore;
        this.$allOnlinePlugins = list;
        this.$context = context;
        this.$plugin = pluginData;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UltimaBackupUtils$downloadAndLoadPlugins$3$downloadResults$2$1(this.$downloadSemaphore, this.$allOnlinePlugins, this.$context, this.$plugin, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Triple<PluginData, Boolean, Boolean>> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:115:0x0311  */
    /* JADX WARN: Code duplicated, block: B:118:0x031f A[Catch: all -> 0x032e, Exception -> 0x0333, TRY_LEAVE, TryCatch #22 {Exception -> 0x0333, all -> 0x032e, blocks: (B:116:0x0319, B:118:0x031f), top: B:195:0x0319 }] */
    /* JADX WARN: Code duplicated, block: B:132:0x038f A[Catch: all -> 0x0393, Exception -> 0x039a, TryCatch #21 {Exception -> 0x039a, all -> 0x0393, blocks: (B:130:0x0389, B:132:0x038f, B:133:0x0392), top: B:197:0x0389 }] */
    /* JADX WARN: Code duplicated, block: B:143:0x03ed  */
    /* JADX WARN: Code duplicated, block: B:146:0x0400 A[Catch: all -> 0x03eb, TRY_LEAVE, TryCatch #8 {all -> 0x03eb, blocks: (B:144:0x03fa, B:146:0x0400, B:149:0x0408, B:153:0x040f, B:140:0x03bc, B:20:0x00ac, B:27:0x00ce, B:38:0x013f, B:40:0x0145, B:45:0x0156, B:47:0x015e, B:52:0x0187, B:31:0x0100), top: B:176:0x00ac }] */
    /* JADX WARN: Code duplicated, block: B:153:0x040f A[Catch: all -> 0x03eb, TRY_ENTER, TRY_LEAVE, TryCatch #8 {all -> 0x03eb, blocks: (B:144:0x03fa, B:146:0x0400, B:149:0x0408, B:153:0x040f, B:140:0x03bc, B:20:0x00ac, B:27:0x00ce, B:38:0x013f, B:40:0x0145, B:45:0x0156, B:47:0x015e, B:52:0x0187, B:31:0x0100), top: B:176:0x00ac }] */
    /* JADX WARN: Code duplicated, block: B:155:0x041d  */
    /* JADX WARN: Code duplicated, block: B:168:0x023a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:176:0x00ac A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:199:0x00c7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:27:0x00ce A[Catch: all -> 0x03eb, TRY_ENTER, TRY_LEAVE, TryCatch #8 {all -> 0x03eb, blocks: (B:144:0x03fa, B:146:0x0400, B:149:0x0408, B:153:0x040f, B:140:0x03bc, B:20:0x00ac, B:27:0x00ce, B:38:0x013f, B:40:0x0145, B:45:0x0156, B:47:0x015e, B:52:0x0187, B:31:0x0100), top: B:176:0x00ac }] */
    /* JADX WARN: Code duplicated, block: B:29:0x00e1 A[Catch: all -> 0x0426, TRY_ENTER, TRY_LEAVE, TryCatch #4 {all -> 0x0426, blocks: (B:17:0x00a0, B:18:0x00a6, B:24:0x00c8, B:43:0x014f, B:50:0x0182, B:58:0x0193, B:59:0x01c1, B:42:0x014b, B:29:0x00e1, B:34:0x0131, B:33:0x0117), top: B:169:0x00a0 }] */
    /* JADX WARN: Code duplicated, block: B:31:0x0100 A[Catch: all -> 0x03eb, TRY_ENTER, TRY_LEAVE, TryCatch #8 {all -> 0x03eb, blocks: (B:144:0x03fa, B:146:0x0400, B:149:0x0408, B:153:0x040f, B:140:0x03bc, B:20:0x00ac, B:27:0x00ce, B:38:0x013f, B:40:0x0145, B:45:0x0156, B:47:0x015e, B:52:0x0187, B:31:0x0100), top: B:176:0x00ac }] */
    /* JADX WARN: Code duplicated, block: B:33:0x0117 A[Catch: all -> 0x0426, TRY_ENTER, TryCatch #4 {all -> 0x0426, blocks: (B:17:0x00a0, B:18:0x00a6, B:24:0x00c8, B:43:0x014f, B:50:0x0182, B:58:0x0193, B:59:0x01c1, B:42:0x014b, B:29:0x00e1, B:34:0x0131, B:33:0x0117), top: B:169:0x00a0 }] */
    /* JADX WARN: Code duplicated, block: B:38:0x013f A[Catch: all -> 0x03eb, TRY_ENTER, TryCatch #8 {all -> 0x03eb, blocks: (B:144:0x03fa, B:146:0x0400, B:149:0x0408, B:153:0x040f, B:140:0x03bc, B:20:0x00ac, B:27:0x00ce, B:38:0x013f, B:40:0x0145, B:45:0x0156, B:47:0x015e, B:52:0x0187, B:31:0x0100), top: B:176:0x00ac }] */
    /* JADX WARN: Code duplicated, block: B:42:0x014b A[Catch: all -> 0x0426, TRY_ENTER, TryCatch #4 {all -> 0x0426, blocks: (B:17:0x00a0, B:18:0x00a6, B:24:0x00c8, B:43:0x014f, B:50:0x0182, B:58:0x0193, B:59:0x01c1, B:42:0x014b, B:29:0x00e1, B:34:0x0131, B:33:0x0117), top: B:169:0x00a0 }] */
    /* JADX WARN: Code duplicated, block: B:45:0x0156 A[Catch: all -> 0x03eb, TRY_ENTER, TryCatch #8 {all -> 0x03eb, blocks: (B:144:0x03fa, B:146:0x0400, B:149:0x0408, B:153:0x040f, B:140:0x03bc, B:20:0x00ac, B:27:0x00ce, B:38:0x013f, B:40:0x0145, B:45:0x0156, B:47:0x015e, B:52:0x0187, B:31:0x0100), top: B:176:0x00ac }] */
    /* JADX WARN: Code duplicated, block: B:52:0x0187 A[Catch: all -> 0x03eb, TRY_ENTER, TRY_LEAVE, TryCatch #8 {all -> 0x03eb, blocks: (B:144:0x03fa, B:146:0x0400, B:149:0x0408, B:153:0x040f, B:140:0x03bc, B:20:0x00ac, B:27:0x00ce, B:38:0x013f, B:40:0x0145, B:45:0x0156, B:47:0x015e, B:52:0x0187, B:31:0x0100), top: B:176:0x00ac }] */
    /* JADX WARN: Code duplicated, block: B:56:0x0190  */
    /* JADX WARN: Code duplicated, block: B:58:0x0193 A[Catch: all -> 0x0426, TRY_ENTER, TRY_LEAVE, TryCatch #4 {all -> 0x0426, blocks: (B:17:0x00a0, B:18:0x00a6, B:24:0x00c8, B:43:0x014f, B:50:0x0182, B:58:0x0193, B:59:0x01c1, B:42:0x014b, B:29:0x00e1, B:34:0x0131, B:33:0x0117), top: B:169:0x00a0 }] */
    /* JADX WARN: Code duplicated, block: B:65:0x0226 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:66:0x0227  */
    /* JADX WARN: Code duplicated, block: B:77:0x0271 A[Catch: all -> 0x0340, TryCatch #0 {all -> 0x0340, blocks: (B:67:0x0230, B:69:0x023a, B:75:0x0268, B:77:0x0271, B:79:0x0279, B:86:0x029a), top: B:162:0x0230 }] */
    /* JADX WARN: Code duplicated, block: B:94:0x02c8  */
    public final Object invokeSuspend(Object $result) throws Exception {
        Semaphore $this$withPermit$iv;
        List<PluginWrapper> list;
        Context context;
        File file;
        int $i$f$withPermit;
        Iterator<T> it;
        Object next;
        PluginWrapper match;
        String cleanPath;
        String relativePath;
        File file2;
        File localFile;
        String url;
        String targetUrl;
        PluginData resultPlugin;
        String str;
        boolean z;
        Throwable th;
        boolean z2;
        PluginData resultPlugin2;
        String downloadUrl;
        String str2;
        File tempFile;
        String downloadUrl2;
        int $i$f$withPermit2;
        Semaphore $this$withPermit$iv2;
        PluginWrapper match2;
        PluginData resultPlugin3;
        File file3;
        Semaphore $this$withPermit$iv3;
        File localFile2;
        File localFile3;
        Semaphore $this$withPermit$iv4;
        String targetUrl2;
        Object obj;
        String downloadUrl3;
        Throwable triple;
        SitePlugin plugin;
        PluginWrapper it2;
        NiceResponse response;
        FileOutputStream fileOutputStream;
        Throwable th2;
        InputStream inputStreamByteStream;
        Throwable th3;
        File localFile4;
        File localFile5;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                $this$withPermit$iv = this.$downloadSemaphore;
                list = this.$allOnlinePlugins;
                context = this.$context;
                file = this.$plugin;
                this.L$0 = $this$withPermit$iv;
                this.L$1 = list;
                this.L$2 = context;
                this.L$3 = file;
                this.label = 1;
                if ($this$withPermit$iv.acquire((Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                $i$f$withPermit = 0;
                try {
                    it = list.iterator();
                    do {
                        if (it.hasNext()) {
                            try {
                                next = it.next();
                                it2 = (PluginWrapper) next;
                            } catch (Throwable th4) {
                                e = th4;
                                $this$withPermit$iv.release();
                                throw e;
                            }
                        } else {
                            next = null;
                        }
                        match = (PluginWrapper) next;
                        if (match != null) {
                            file2 = PluginManager.INSTANCE.getPluginPath(context, file.getInternalName(), match.getRepositoryData().getUrl());
                        } else {
                            cleanPath = StringsKt.replace$default(file.getFilePath(), '\\', '/', false, 4, (Object) null);
                            if (StringsKt.contains$default(cleanPath, "Extensions/", false, 2, (Object) null)) {
                                relativePath = "Extensions/" + StringsKt.substringAfter$default(cleanPath, "Extensions/", (String) null, 2, (Object) null);
                            } else {
                                relativePath = "Extensions/DefaultRepo/" + StringsKt.substringAfterLast$default(cleanPath, '/', (String) null, 2, (Object) null);
                            }
                            file2 = new File(context.getFilesDir(), relativePath);
                        }
                        localFile = file2;
                        if (match != null || (plugin = match.getPlugin()) == null || (url = plugin.getUrl()) == null) {
                            url = file.getUrl();
                        }
                        targetUrl = url;
                        if (localFile.exists() || localFile.length() <= 0) {
                            resultPlugin = null;
                            str = targetUrl;
                            if (str != null || StringsKt.isBlank(str)) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (z) {
                                th = null;
                                z2 = true;
                                resultPlugin2 = null;
                            } else {
                                downloadUrl = UltimaBackupUtils.INSTANCE.forceConvertRawGitUrl(targetUrl);
                                Log.INSTANCE.d("UltimaSync", "Downloading plugin: " + file.getInternalName() + " from " + downloadUrl);
                                try {
                                    tempFile = File.createTempFile(file.getInternalName(), ".tmp", context.getCacheDir());
                                    try {
                                        Requests app = MainActivityKt.getApp();
                                        this.L$0 = $this$withPermit$iv;
                                        this.L$1 = file;
                                        this.L$2 = localFile;
                                        this.L$3 = targetUrl;
                                        this.L$4 = SpillingKt.nullOutSpilledVariable(downloadUrl);
                                        this.L$5 = tempFile;
                                        this.L$6 = SpillingKt.nullOutSpilledVariable(match);
                                        this.label = 2;
                                        localFile3 = file;
                                        $this$withPermit$iv4 = $this$withPermit$iv;
                                        targetUrl2 = targetUrl;
                                        localFile3 = localFile;
                                        z2 = true;
                                        str2 = "UltimaSync";
                                        th = null;
                                        try {
                                            obj = Requests.get$default(app, downloadUrl, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, this, 4094, (Object) null);
                                            if (obj == coroutine_suspended) {
                                                return coroutine_suspended;
                                            }
                                            downloadUrl3 = downloadUrl;
                                            $this$withPermit$iv2 = null;
                                            match2 = match;
                                            tempFile = tempFile;
                                            localFile3 = localFile3;
                                            try {
                                                response = (NiceResponse) obj;
                                                if (response.getCode() == 200) {
                                                    try {
                                                        ResponseBody body = response.getOkhttpResponse().body();
                                                        fileOutputStream = new FileOutputStream(tempFile);
                                                        try {
                                                            FileOutputStream fos = fileOutputStream;
                                                            inputStreamByteStream = body.byteStream();
                                                            try {
                                                                InputStream bis = inputStreamByteStream;
                                                                try {
                                                                    ByteStreamsKt.copyTo$default(bis, fos, 0, 2, th);
                                                                    try {
                                                                        CloseableKt.closeFinally(inputStreamByteStream, th);
                                                                        CloseableKt.closeFinally(fileOutputStream, th);
                                                                        if (tempFile.exists() || tempFile.length() <= 0) {
                                                                            localFile4 = localFile3;
                                                                            localFile5 = localFile3;
                                                                        } else {
                                                                            File parentFile = localFile3.getParentFile();
                                                                            if (parentFile != null) {
                                                                                try {
                                                                                    Boxing.boxBoolean(parentFile.mkdirs());
                                                                                    break;
                                                                                } catch (Throwable th5) {
                                                                                    th = th5;
                                                                                    localFile2 = localFile3;
                                                                                    $i$f$withPermit2 = $i$f$withPermit;
                                                                                    resultPlugin3 = resultPlugin;
                                                                                    file3 = localFile3;
                                                                                    $this$withPermit$iv3 = $this$withPermit$iv4;
                                                                                    downloadUrl2 = downloadUrl3;
                                                                                    try {
                                                                                        if (tempFile.exists()) {
                                                                                            tempFile.delete();
                                                                                        }
                                                                                        throw th;
                                                                                    } catch (Exception e) {
                                                                                        e = e;
                                                                                        resultPlugin = resultPlugin3;
                                                                                        localFile = localFile2;
                                                                                        file = file3;
                                                                                        $this$withPermit$iv = $this$withPermit$iv3;
                                                                                        Log.INSTANCE.e(str2, "Download error for " + file.getInternalName() + ": " + e.getMessage());
                                                                                        resultPlugin2 = resultPlugin;
                                                                                        if (localFile.exists()) {
                                                                                            try {
                                                                                                localFile.delete();
                                                                                                break;
                                                                                            } catch (Exception e2) {
                                                                                            }
                                                                                        }
                                                                                        if (resultPlugin2 != null) {
                                                                                            triple = new Triple(resultPlugin2, Boxing.boxBoolean(z2), Boxing.boxBoolean(z2));
                                                                                        } else {
                                                                                            triple = th;
                                                                                        }
                                                                                        $this$withPermit$iv.release();
                                                                                        return triple;
                                                                                    } catch (Throwable th6) {
                                                                                        e = th6;
                                                                                        $this$withPermit$iv = $this$withPermit$iv3;
                                                                                        $this$withPermit$iv.release();
                                                                                        throw e;
                                                                                    }
                                                                                }
                                                                            }
                                                                            FilesKt.copyTo$default(tempFile, localFile3, true, 0, 4, (Object) null);
                                                                            localFile4 = localFile3;
                                                                            try {
                                                                                localFile5 = localFile3;
                                                                                resultPlugin = PluginData.copy$default(localFile5, (String) null, targetUrl2, false, localFile4.getAbsolutePath(), 0, 21, (Object) null);
                                                                            } catch (Throwable th7) {
                                                                                th = th7;
                                                                                file3 = localFile3;
                                                                                $i$f$withPermit2 = $i$f$withPermit;
                                                                                resultPlugin3 = resultPlugin;
                                                                                $this$withPermit$iv3 = $this$withPermit$iv4;
                                                                                localFile2 = localFile4;
                                                                                downloadUrl2 = downloadUrl3;
                                                                                if (tempFile.exists()) {
                                                                                    tempFile.delete();
                                                                                }
                                                                                throw th;
                                                                            }
                                                                        }
                                                                    } catch (Throwable th8) {
                                                                        localFile3 = localFile3;
                                                                        localFile3 = localFile3;
                                                                        th2 = th8;
                                                                        try {
                                                                            throw th2;
                                                                        } catch (Throwable th9) {
                                                                            CloseableKt.closeFinally(fileOutputStream, th2);
                                                                            throw th9;
                                                                        }
                                                                    }
                                                                } catch (Throwable th10) {
                                                                    th3 = th10;
                                                                    try {
                                                                        throw th3;
                                                                    } catch (Throwable th11) {
                                                                        try {
                                                                            CloseableKt.closeFinally(inputStreamByteStream, th3);
                                                                            throw th11;
                                                                        } catch (Throwable th12) {
                                                                            th2 = th12;
                                                                            throw th2;
                                                                        }
                                                                    }
                                                                }
                                                            } catch (Throwable th13) {
                                                                th3 = th13;
                                                            }
                                                        } catch (Throwable th14) {
                                                            localFile3 = localFile3;
                                                            localFile3 = localFile3;
                                                            th2 = th14;
                                                        }
                                                    } catch (Throwable th15) {
                                                        th = th15;
                                                        file3 = localFile3;
                                                        $i$f$withPermit2 = $i$f$withPermit;
                                                        resultPlugin3 = resultPlugin;
                                                        $this$withPermit$iv3 = $this$withPermit$iv4;
                                                        localFile2 = localFile3;
                                                        downloadUrl2 = downloadUrl3;
                                                    }
                                                } else {
                                                    localFile4 = localFile3;
                                                    localFile5 = localFile3;
                                                }
                                                try {
                                                    if (tempFile.exists()) {
                                                        tempFile.delete();
                                                    }
                                                    resultPlugin2 = resultPlugin;
                                                    $this$withPermit$iv = $this$withPermit$iv4;
                                                    localFile = localFile4;
                                                } catch (Exception e3) {
                                                    e = e3;
                                                    file = localFile5;
                                                    $this$withPermit$iv = $this$withPermit$iv4;
                                                    localFile = localFile4;
                                                    Log.INSTANCE.e(str2, "Download error for " + file.getInternalName() + ": " + e.getMessage());
                                                    resultPlugin2 = resultPlugin;
                                                } catch (Throwable th16) {
                                                    e = th16;
                                                    $this$withPermit$iv = $this$withPermit$iv4;
                                                    $this$withPermit$iv.release();
                                                    throw e;
                                                }
                                            } catch (Throwable th17) {
                                                th = th17;
                                                file3 = localFile3;
                                                $i$f$withPermit2 = $i$f$withPermit;
                                                resultPlugin3 = resultPlugin;
                                                $this$withPermit$iv3 = $this$withPermit$iv4;
                                                localFile2 = localFile3;
                                                downloadUrl2 = downloadUrl3;
                                            }
                                        } catch (Throwable th18) {
                                            th = th18;
                                            downloadUrl2 = downloadUrl;
                                            $i$f$withPermit2 = $i$f$withPermit;
                                            $this$withPermit$iv2 = null;
                                            match2 = match;
                                            resultPlugin3 = null;
                                            file3 = localFile3;
                                            tempFile = tempFile;
                                            $this$withPermit$iv3 = $this$withPermit$iv4;
                                            localFile2 = localFile3;
                                            if (tempFile.exists()) {
                                                tempFile.delete();
                                            }
                                            throw th;
                                        }
                                    } catch (Throwable th19) {
                                        th = th19;
                                        Semaphore semaphore = $this$withPermit$iv;
                                        str2 = "UltimaSync";
                                        th = null;
                                        File file4 = file;
                                        z2 = true;
                                        downloadUrl2 = downloadUrl;
                                        $i$f$withPermit2 = $i$f$withPermit;
                                        $this$withPermit$iv2 = null;
                                        match2 = match;
                                        resultPlugin3 = null;
                                        file3 = file4;
                                        $this$withPermit$iv3 = semaphore;
                                        localFile2 = localFile;
                                    }
                                } catch (Exception e4) {
                                    e = e4;
                                    str2 = "UltimaSync";
                                    th = null;
                                    z2 = true;
                                    $this$withPermit$iv = $this$withPermit$iv;
                                    Log.INSTANCE.e(str2, "Download error for " + file.getInternalName() + ": " + e.getMessage());
                                    resultPlugin2 = resultPlugin;
                                    if (localFile.exists()) {
                                        localFile.delete();
                                        break;
                                    }
                                    if (resultPlugin2 != null) {
                                        triple = new Triple(resultPlugin2, Boxing.boxBoolean(z2), Boxing.boxBoolean(z2));
                                    } else {
                                        triple = th;
                                    }
                                    $this$withPermit$iv.release();
                                    return triple;
                                }
                            }
                            if (localFile.exists() && localFile.length() == 0) {
                                localFile.delete();
                            }
                            if (resultPlugin2 != null) {
                                triple = new Triple(resultPlugin2, Boxing.boxBoolean(z2), Boxing.boxBoolean(z2));
                            } else {
                                triple = th;
                            }
                            break;
                        } else {
                            triple = new Triple(PluginData.copy$default(file, (String) null, (String) null, false, localFile.getAbsolutePath(), 0, 23, (Object) null), Boxing.boxBoolean(false), Boxing.boxBoolean(false));
                        }
                        $this$withPermit$iv.release();
                        return triple;
                    } while (!StringsKt.equals(it2.getPlugin().getInternalName(), file.getInternalName(), true));
                    match = (PluginWrapper) next;
                    if (match != null) {
                        file2 = PluginManager.INSTANCE.getPluginPath(context, file.getInternalName(), match.getRepositoryData().getUrl());
                    } else {
                        cleanPath = StringsKt.replace$default(file.getFilePath(), '\\', '/', false, 4, (Object) null);
                        if (StringsKt.contains$default(cleanPath, "Extensions/", false, 2, (Object) null)) {
                            relativePath = "Extensions/" + StringsKt.substringAfter$default(cleanPath, "Extensions/", (String) null, 2, (Object) null);
                        } else {
                            relativePath = "Extensions/DefaultRepo/" + StringsKt.substringAfterLast$default(cleanPath, '/', (String) null, 2, (Object) null);
                        }
                        file2 = new File(context.getFilesDir(), relativePath);
                    }
                    localFile = file2;
                    if (match != null) {
                        url = file.getUrl();
                    } else {
                        url = file.getUrl();
                    }
                    targetUrl = url;
                    if (localFile.exists()) {
                    }
                    resultPlugin = null;
                    str = targetUrl;
                    if (str != null) {
                        z = true;
                    } else {
                        z = true;
                    }
                    if (z) {
                        downloadUrl = UltimaBackupUtils.INSTANCE.forceConvertRawGitUrl(targetUrl);
                        Log.INSTANCE.d("UltimaSync", "Downloading plugin: " + file.getInternalName() + " from " + downloadUrl);
                        tempFile = File.createTempFile(file.getInternalName(), ".tmp", context.getCacheDir());
                        Requests app2 = MainActivityKt.getApp();
                        this.L$0 = $this$withPermit$iv;
                        this.L$1 = file;
                        this.L$2 = localFile;
                        this.L$3 = targetUrl;
                        this.L$4 = SpillingKt.nullOutSpilledVariable(downloadUrl);
                        this.L$5 = tempFile;
                        this.L$6 = SpillingKt.nullOutSpilledVariable(match);
                        this.label = 2;
                        localFile3 = file;
                        $this$withPermit$iv4 = $this$withPermit$iv;
                        targetUrl2 = targetUrl;
                        localFile3 = localFile;
                        z2 = true;
                        str2 = "UltimaSync";
                        th = null;
                        obj = Requests.get$default(app2, downloadUrl, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, this, 4094, (Object) null);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        downloadUrl3 = downloadUrl;
                        $this$withPermit$iv2 = null;
                        match2 = match;
                        tempFile = tempFile;
                        localFile3 = localFile3;
                        response = (NiceResponse) obj;
                        if (response.getCode() == 200) {
                            ResponseBody body2 = response.getOkhttpResponse().body();
                            fileOutputStream = new FileOutputStream(tempFile);
                            FileOutputStream fos2 = fileOutputStream;
                            inputStreamByteStream = body2.byteStream();
                            InputStream bis2 = inputStreamByteStream;
                            ByteStreamsKt.copyTo$default(bis2, fos2, 0, 2, th);
                            CloseableKt.closeFinally(inputStreamByteStream, th);
                            CloseableKt.closeFinally(fileOutputStream, th);
                            if (tempFile.exists()) {
                                localFile4 = localFile3;
                                localFile5 = localFile3;
                            } else {
                                localFile4 = localFile3;
                                localFile5 = localFile3;
                            }
                        } else {
                            localFile4 = localFile3;
                            localFile5 = localFile3;
                        }
                        if (tempFile.exists()) {
                            tempFile.delete();
                        }
                        resultPlugin2 = resultPlugin;
                        $this$withPermit$iv = $this$withPermit$iv4;
                        localFile = localFile4;
                        break;
                    } else {
                        th = null;
                        z2 = true;
                        resultPlugin2 = null;
                    }
                    if (localFile.exists()) {
                        localFile.delete();
                        break;
                    }
                    if (resultPlugin2 != null) {
                        triple = new Triple(resultPlugin2, Boxing.boxBoolean(z2), Boxing.boxBoolean(z2));
                    } else {
                        triple = th;
                    }
                    $this$withPermit$iv.release();
                    return triple;
                } catch (Throwable th20) {
                    e = th20;
                }
                break;
            case 1:
                file = (PluginData) this.L$3;
                context = (Context) this.L$2;
                list = (List) this.L$1;
                Semaphore $this$withPermit$iv5 = (Semaphore) this.L$0;
                ResultKt.throwOnFailure($result);
                $i$f$withPermit = 0;
                $this$withPermit$iv = $this$withPermit$iv5;
                it = list.iterator();
                do {
                    if (it.hasNext()) {
                        next = it.next();
                        it2 = (PluginWrapper) next;
                    } else {
                        next = null;
                    }
                    match = (PluginWrapper) next;
                    if (match != null) {
                        file2 = PluginManager.INSTANCE.getPluginPath(context, file.getInternalName(), match.getRepositoryData().getUrl());
                    } else {
                        cleanPath = StringsKt.replace$default(file.getFilePath(), '\\', '/', false, 4, (Object) null);
                        if (StringsKt.contains$default(cleanPath, "Extensions/", false, 2, (Object) null)) {
                            relativePath = "Extensions/" + StringsKt.substringAfter$default(cleanPath, "Extensions/", (String) null, 2, (Object) null);
                        } else {
                            relativePath = "Extensions/DefaultRepo/" + StringsKt.substringAfterLast$default(cleanPath, '/', (String) null, 2, (Object) null);
                        }
                        file2 = new File(context.getFilesDir(), relativePath);
                    }
                    localFile = file2;
                    if (match != null) {
                        url = file.getUrl();
                    } else {
                        url = file.getUrl();
                    }
                    targetUrl = url;
                    if (localFile.exists()) {
                        break;
                    }
                    resultPlugin = null;
                    str = targetUrl;
                    if (str != null) {
                        z = true;
                    } else {
                        z = true;
                    }
                    if (z) {
                        downloadUrl = UltimaBackupUtils.INSTANCE.forceConvertRawGitUrl(targetUrl);
                        Log.INSTANCE.d("UltimaSync", "Downloading plugin: " + file.getInternalName() + " from " + downloadUrl);
                        tempFile = File.createTempFile(file.getInternalName(), ".tmp", context.getCacheDir());
                        Requests app3 = MainActivityKt.getApp();
                        this.L$0 = $this$withPermit$iv;
                        this.L$1 = file;
                        this.L$2 = localFile;
                        this.L$3 = targetUrl;
                        this.L$4 = SpillingKt.nullOutSpilledVariable(downloadUrl);
                        this.L$5 = tempFile;
                        this.L$6 = SpillingKt.nullOutSpilledVariable(match);
                        this.label = 2;
                        localFile3 = file;
                        $this$withPermit$iv4 = $this$withPermit$iv;
                        targetUrl2 = targetUrl;
                        localFile3 = localFile;
                        z2 = true;
                        str2 = "UltimaSync";
                        th = null;
                        obj = Requests.get$default(app3, downloadUrl, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, this, 4094, (Object) null);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        downloadUrl3 = downloadUrl;
                        $this$withPermit$iv2 = null;
                        match2 = match;
                        tempFile = tempFile;
                        localFile3 = localFile3;
                        response = (NiceResponse) obj;
                        if (response.getCode() == 200) {
                            ResponseBody body3 = response.getOkhttpResponse().body();
                            fileOutputStream = new FileOutputStream(tempFile);
                            FileOutputStream fos3 = fileOutputStream;
                            inputStreamByteStream = body3.byteStream();
                            InputStream bis3 = inputStreamByteStream;
                            ByteStreamsKt.copyTo$default(bis3, fos3, 0, 2, th);
                            CloseableKt.closeFinally(inputStreamByteStream, th);
                            CloseableKt.closeFinally(fileOutputStream, th);
                            if (tempFile.exists()) {
                                localFile4 = localFile3;
                                localFile5 = localFile3;
                            } else {
                                localFile4 = localFile3;
                                localFile5 = localFile3;
                            }
                        } else {
                            localFile4 = localFile3;
                            localFile5 = localFile3;
                        }
                        if (tempFile.exists()) {
                            tempFile.delete();
                        }
                        resultPlugin2 = resultPlugin;
                        $this$withPermit$iv = $this$withPermit$iv4;
                        localFile = localFile4;
                        break;
                    } else {
                        th = null;
                        z2 = true;
                        resultPlugin2 = null;
                    }
                    if (localFile.exists()) {
                        localFile.delete();
                        break;
                    }
                    if (resultPlugin2 != null) {
                        triple = new Triple(resultPlugin2, Boxing.boxBoolean(z2), Boxing.boxBoolean(z2));
                    } else {
                        triple = th;
                    }
                    $this$withPermit$iv.release();
                    return triple;
                } while (!StringsKt.equals(it2.getPlugin().getInternalName(), file.getInternalName(), true));
                match = (PluginWrapper) next;
                if (match != null) {
                    file2 = PluginManager.INSTANCE.getPluginPath(context, file.getInternalName(), match.getRepositoryData().getUrl());
                } else {
                    cleanPath = StringsKt.replace$default(file.getFilePath(), '\\', '/', false, 4, (Object) null);
                    if (StringsKt.contains$default(cleanPath, "Extensions/", false, 2, (Object) null)) {
                        relativePath = "Extensions/" + StringsKt.substringAfter$default(cleanPath, "Extensions/", (String) null, 2, (Object) null);
                    } else {
                        relativePath = "Extensions/DefaultRepo/" + StringsKt.substringAfterLast$default(cleanPath, '/', (String) null, 2, (Object) null);
                    }
                    file2 = new File(context.getFilesDir(), relativePath);
                }
                localFile = file2;
                if (match != null) {
                    url = file.getUrl();
                } else {
                    url = file.getUrl();
                }
                targetUrl = url;
                if (localFile.exists()) {
                    break;
                }
                resultPlugin = null;
                str = targetUrl;
                if (str != null) {
                    z = true;
                } else {
                    z = true;
                }
                if (z) {
                    downloadUrl = UltimaBackupUtils.INSTANCE.forceConvertRawGitUrl(targetUrl);
                    Log.INSTANCE.d("UltimaSync", "Downloading plugin: " + file.getInternalName() + " from " + downloadUrl);
                    tempFile = File.createTempFile(file.getInternalName(), ".tmp", context.getCacheDir());
                    Requests app4 = MainActivityKt.getApp();
                    this.L$0 = $this$withPermit$iv;
                    this.L$1 = file;
                    this.L$2 = localFile;
                    this.L$3 = targetUrl;
                    this.L$4 = SpillingKt.nullOutSpilledVariable(downloadUrl);
                    this.L$5 = tempFile;
                    this.L$6 = SpillingKt.nullOutSpilledVariable(match);
                    this.label = 2;
                    localFile3 = file;
                    $this$withPermit$iv4 = $this$withPermit$iv;
                    targetUrl2 = targetUrl;
                    localFile3 = localFile;
                    z2 = true;
                    str2 = "UltimaSync";
                    th = null;
                    obj = Requests.get$default(app4, downloadUrl, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, this, 4094, (Object) null);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    downloadUrl3 = downloadUrl;
                    $this$withPermit$iv2 = null;
                    match2 = match;
                    tempFile = tempFile;
                    localFile3 = localFile3;
                    response = (NiceResponse) obj;
                    if (response.getCode() == 200) {
                        ResponseBody body4 = response.getOkhttpResponse().body();
                        fileOutputStream = new FileOutputStream(tempFile);
                        FileOutputStream fos4 = fileOutputStream;
                        inputStreamByteStream = body4.byteStream();
                        InputStream bis4 = inputStreamByteStream;
                        ByteStreamsKt.copyTo$default(bis4, fos4, 0, 2, th);
                        CloseableKt.closeFinally(inputStreamByteStream, th);
                        CloseableKt.closeFinally(fileOutputStream, th);
                        if (tempFile.exists()) {
                            localFile4 = localFile3;
                            localFile5 = localFile3;
                        } else {
                            localFile4 = localFile3;
                            localFile5 = localFile3;
                        }
                    } else {
                        localFile4 = localFile3;
                        localFile5 = localFile3;
                    }
                    if (tempFile.exists()) {
                        tempFile.delete();
                    }
                    resultPlugin2 = resultPlugin;
                    $this$withPermit$iv = $this$withPermit$iv4;
                    localFile = localFile4;
                    break;
                } else {
                    th = null;
                    z2 = true;
                    resultPlugin2 = null;
                }
                if (localFile.exists()) {
                    localFile.delete();
                    break;
                }
                if (resultPlugin2 != null) {
                    triple = new Triple(resultPlugin2, Boxing.boxBoolean(z2), Boxing.boxBoolean(z2));
                } else {
                    triple = th;
                }
                $this$withPermit$iv.release();
                return triple;
            case 2:
                $i$f$withPermit2 = 0;
                $this$withPermit$iv2 = null;
                match2 = (PluginWrapper) this.L$6;
                tempFile = (File) this.L$5;
                downloadUrl2 = (String) this.L$4;
                resultPlugin3 = null;
                String targetUrl3 = (String) this.L$3;
                localFile2 = (File) this.L$2;
                file3 = (PluginData) this.L$1;
                $this$withPermit$iv3 = (Semaphore) this.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    $i$f$withPermit = 0;
                    str2 = "UltimaSync";
                    th = null;
                    downloadUrl3 = downloadUrl2;
                    resultPlugin = null;
                    targetUrl2 = targetUrl3;
                    localFile3 = localFile2;
                    localFile3 = file3;
                    $this$withPermit$iv4 = $this$withPermit$iv3;
                    z2 = true;
                    obj = $result;
                    response = (NiceResponse) obj;
                    if (response.getCode() == 200) {
                        ResponseBody body5 = response.getOkhttpResponse().body();
                        fileOutputStream = new FileOutputStream(tempFile);
                        FileOutputStream fos5 = fileOutputStream;
                        inputStreamByteStream = body5.byteStream();
                        InputStream bis5 = inputStreamByteStream;
                        ByteStreamsKt.copyTo$default(bis5, fos5, 0, 2, th);
                        CloseableKt.closeFinally(inputStreamByteStream, th);
                        CloseableKt.closeFinally(fileOutputStream, th);
                        if (tempFile.exists()) {
                            localFile4 = localFile3;
                            localFile5 = localFile3;
                        } else {
                            localFile4 = localFile3;
                            localFile5 = localFile3;
                        }
                    } else {
                        localFile4 = localFile3;
                        localFile5 = localFile3;
                    }
                    if (tempFile.exists()) {
                        tempFile.delete();
                        break;
                    }
                    resultPlugin2 = resultPlugin;
                    $this$withPermit$iv = $this$withPermit$iv4;
                    localFile = localFile4;
                    if (localFile.exists()) {
                        localFile.delete();
                        break;
                    }
                    if (resultPlugin2 != null) {
                        triple = new Triple(resultPlugin2, Boxing.boxBoolean(z2), Boxing.boxBoolean(z2));
                    } else {
                        triple = th;
                    }
                    $this$withPermit$iv.release();
                    return triple;
                } catch (Throwable th21) {
                    th = th21;
                    str2 = "UltimaSync";
                    th = null;
                    z2 = true;
                    if (tempFile.exists()) {
                        tempFile.delete();
                    }
                    throw th;
                }
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
