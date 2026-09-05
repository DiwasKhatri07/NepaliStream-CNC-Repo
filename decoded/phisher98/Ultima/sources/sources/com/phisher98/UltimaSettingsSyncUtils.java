package com.phisher98;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.util.Base64;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lagradost.api.Log;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import okhttp3.Interceptor;
import okhttp3.RequestBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: UltimaSettingsSyncUtils.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/Ultima/classes.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H\u0002J*\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rH\u0007b\u0010\b\u000e\u0012\f\b\u000f\u0012\b\b\fJ\u0004\b\b(\u0010J\u000e\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0005J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0086@¢\u0006\u0002\u0010\u0015J\u0016\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0014H\u0086@¢\u0006\u0002\u0010\u0019J\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0086@¢\u0006\u0002\u0010\u001eJ\u000e\u0010\u001f\u001a\u00020\u0017H\u0086@¢\u0006\u0002\u0010\u0015J4\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001d0!2\u001e\u0010\"\u001a\u001a\u0012\u0004\u0012\u00020\u001d\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050$0#H\u0086@¢\u0006\u0002\u0010%J\u0016\u0010&\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010'H\u0086@¢\u0006\u0002\u0010\u0015J\u0010\u0010)\u001a\u0004\u0018\u00010*H\u0086@¢\u0006\u0002\u0010\u0015J\u000e\u0010+\u001a\u00020\u0017H\u0086@¢\u0006\u0002\u0010\u0015J\u001c\u0010,\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u00050$H\u0086@¢\u0006\u0002\u0010\u0015J$\u0010-\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u00050$2\u0006\u0010.\u001a\u00020\u0005H\u0086@¢\u0006\u0002\u0010/R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/phisher98/UltimaSettingsSyncUtils;", "", "<init>", "()V", "TAG", "", "COMPRESSED_PREFIX", "compressData", "data", "decompressData", "getDeviceId", "packageName", "context", "Landroid/content/Context;", "Landroid/annotation/SuppressLint;", "value", "HardwareIds", "md5", "input", "fetchManifest", "Lcom/phisher98/SyncManifest;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "pushManifest", "", "manifest", "(Lcom/phisher98/SyncManifest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchCategory", "Lcom/phisher98/SyncCategoryPayload;", "category", "Lcom/phisher98/SyncCategory;", "(Lcom/phisher98/SyncCategory;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "registerDevice", "pushCategories", "", "categoryData", "", "Lkotlin/Pair;", "(Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchDevices", "", "Lcom/phisher98/FirebaseDevice;", "fetchSharedData", "Lcom/phisher98/FirebaseSharedData;", "deleteSharedData", "deregisterThisDevice", "removeDevice", "deviceId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Ultima"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nUltimaSettingsSyncUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UltimaSettingsSyncUtils.kt\ncom/phisher98/UltimaSettingsSyncUtils\n+ 2 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n*L\n1#1,459:1\n50#2:460\n43#2:461\n50#2:462\n43#2:463\n50#2:464\n43#2:465\n50#2:466\n43#2:467\n50#2:468\n43#2:469\n*S KotlinDebug\n*F\n+ 1 UltimaSettingsSyncUtils.kt\ncom/phisher98/UltimaSettingsSyncUtils\n*L\n246#1:460\n246#1:461\n278#1:462\n278#1:463\n365#1:464\n365#1:465\n393#1:466\n393#1:467\n409#1:468\n409#1:469\n*E\n"})
public final class UltimaSettingsSyncUtils {

    @NotNull
    private static final String COMPRESSED_PREFIX = "gz:";

    @NotNull
    public static final UltimaSettingsSyncUtils INSTANCE = new UltimaSettingsSyncUtils();

    @NotNull
    private static final String TAG = "UltimaSync";

    /* JADX INFO: renamed from: com.phisher98.UltimaSettingsSyncUtils$deleteSharedData$1 */
    /* JADX INFO: compiled from: UltimaSettingsSyncUtils.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.UltimaSettingsSyncUtils", f = "UltimaSettingsSyncUtils.kt", i = {0, 0}, l = {420}, m = "deleteSharedData", n = {"creds", "url"}, nl = {421}, s = {"L$0", "L$1"}, v = 2)
    static final class C00211 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C00211(Continuation<? super C00211> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UltimaSettingsSyncUtils.this.deleteSharedData((Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.UltimaSettingsSyncUtils$deregisterThisDevice$1 */
    /* JADX INFO: compiled from: UltimaSettingsSyncUtils.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.UltimaSettingsSyncUtils", f = "UltimaSettingsSyncUtils.kt", i = {0, 0}, l = {431}, m = "deregisterThisDevice", n = {"creds", "url"}, nl = {432}, s = {"L$0", "L$1"}, v = 2)
    static final class C00221 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C00221(Continuation<? super C00221> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UltimaSettingsSyncUtils.this.deregisterThisDevice((Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.UltimaSettingsSyncUtils$fetchCategory$1 */
    /* JADX INFO: compiled from: UltimaSettingsSyncUtils.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.UltimaSettingsSyncUtils", f = "UltimaSettingsSyncUtils.kt", i = {0, 0, 0}, l = {274}, m = "fetchCategory", n = {"category", "creds", "url"}, nl = {275}, s = {"L$0", "L$1", "L$2"}, v = 2)
    static final class C00231 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C00231(Continuation<? super C00231> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UltimaSettingsSyncUtils.this.fetchCategory(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.UltimaSettingsSyncUtils$fetchDevices$1 */
    /* JADX INFO: compiled from: UltimaSettingsSyncUtils.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.UltimaSettingsSyncUtils", f = "UltimaSettingsSyncUtils.kt", i = {0, 0}, l = {389}, m = "fetchDevices", n = {"creds", "url"}, nl = {390}, s = {"L$0", "L$1"}, v = 2)
    static final class C00241 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C00241(Continuation<? super C00241> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UltimaSettingsSyncUtils.this.fetchDevices((Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.UltimaSettingsSyncUtils$fetchManifest$1 */
    /* JADX INFO: compiled from: UltimaSettingsSyncUtils.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.UltimaSettingsSyncUtils", f = "UltimaSettingsSyncUtils.kt", i = {0, 0}, l = {242}, m = "fetchManifest", n = {"creds", "url"}, nl = {243}, s = {"L$0", "L$1"}, v = 2)
    static final class C00251 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C00251(Continuation<? super C00251> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UltimaSettingsSyncUtils.this.fetchManifest((Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.UltimaSettingsSyncUtils$fetchSharedData$1 */
    /* JADX INFO: compiled from: UltimaSettingsSyncUtils.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.UltimaSettingsSyncUtils", f = "UltimaSettingsSyncUtils.kt", i = {0, 0}, l = {405}, m = "fetchSharedData", n = {"creds", "url"}, nl = {406}, s = {"L$0", "L$1"}, v = 2)
    static final class C00261 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C00261(Continuation<? super C00261> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UltimaSettingsSyncUtils.this.fetchSharedData((Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.UltimaSettingsSyncUtils$pushCategories$1 */
    /* JADX INFO: compiled from: UltimaSettingsSyncUtils.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.UltimaSettingsSyncUtils", f = "UltimaSettingsSyncUtils.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2}, l = {320, 348, 355}, m = "pushCategories", n = {"categoryData", "creds", "deviceName", "successfulCategories", "now", "categoryData", "creds", "deviceName", "successfulCategories", "now", "categoryData", "creds", "deviceName", "successfulCategories", "currentManifest", "updatedManifest", "now"}, nl = {345, 349, 358}, s = {"L$0", "L$1", "L$2", "L$3", "J$0", "L$0", "L$1", "L$2", "L$3", "J$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "J$0"}, v = 2)
    static final class C00271 extends ContinuationImpl {
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        C00271(Continuation<? super C00271> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UltimaSettingsSyncUtils.this.pushCategories(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.UltimaSettingsSyncUtils$pushManifest$1 */
    /* JADX INFO: compiled from: UltimaSettingsSyncUtils.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.UltimaSettingsSyncUtils", f = "UltimaSettingsSyncUtils.kt", i = {0, 0, 0}, l = {260}, m = "pushManifest", n = {"manifest", "creds", "url"}, nl = {261}, s = {"L$0", "L$1", "L$2"}, v = 2)
    static final class C00291 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C00291(Continuation<? super C00291> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UltimaSettingsSyncUtils.this.pushManifest(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.UltimaSettingsSyncUtils$registerDevice$1 */
    /* JADX INFO: compiled from: UltimaSettingsSyncUtils.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.UltimaSettingsSyncUtils", f = "UltimaSettingsSyncUtils.kt", i = {0, 0, 0}, l = {293}, m = "registerDevice", n = {"creds", "deviceUrl", "device"}, nl = {294}, s = {"L$0", "L$1", "L$2"}, v = 2)
    static final class C00301 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C00301(Continuation<? super C00301> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UltimaSettingsSyncUtils.this.registerDevice((Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.UltimaSettingsSyncUtils$removeDevice$1 */
    /* JADX INFO: compiled from: UltimaSettingsSyncUtils.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.UltimaSettingsSyncUtils", f = "UltimaSettingsSyncUtils.kt", i = {0, 0, 0}, l = {448}, m = "removeDevice", n = {"deviceId", "creds", "url"}, nl = {449}, s = {"L$0", "L$1", "L$2"}, v = 2)
    static final class C00311 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C00311(Continuation<? super C00311> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UltimaSettingsSyncUtils.this.removeDevice(null, (Continuation) this);
        }
    }

    private UltimaSettingsSyncUtils() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String compressData(String data) {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(bos);
        try {
            GZIPOutputStream gz = gZIPOutputStream;
            byte[] bytes = data.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            gz.write(bytes);
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(gZIPOutputStream, (Throwable) null);
            return COMPRESSED_PREFIX + Base64.encodeToString(bos.toByteArray(), 2);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(gZIPOutputStream, th);
                throw th2;
            }
        }
    }

    private final String decompressData(String data) {
        if (!StringsKt.startsWith$default(data, COMPRESSED_PREFIX, false, 2, (Object) null)) {
            return data;
        }
        byte[] compressed = Base64.decode(StringsKt.removePrefix(data, COMPRESSED_PREFIX), 2);
        ByteArrayInputStream bis = new ByteArrayInputStream(compressed);
        Reader inputStreamReader = new InputStreamReader(new GZIPInputStream(bis), Charsets.UTF_8);
        return TextStreamsKt.readText(inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192));
    }

    @SuppressLint({"HardwareIds"})
    @NotNull
    public final String getDeviceId(@NotNull String packageName, @NotNull Context context) {
        String androidId = Settings.Secure.getString(context.getContentResolver(), "android_id");
        String str = androidId;
        if (!(str == null || str.length() == 0)) {
            return md5(packageName + androidId);
        }
        String deviceInfo = Build.BRAND + '_' + Build.MODEL + '_' + Build.DEVICE;
        StringBuilder sbAppend = new StringBuilder().append(packageName);
        byte[] bytes = deviceInfo.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        return md5(sbAppend.append(UUID.nameUUIDFromBytes(bytes)).toString());
    }

    @NotNull
    public final String md5(@NotNull String input) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("MD5");
        byte[] bytes = input.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        byte[] bytes2 = digest.digest(bytes);
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes2) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b)}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            sb.append(str);
        }
        return sb.toString();
    }

    /* JADX WARN: Code duplicated, block: B:32:0x00db A[Catch: Exception -> 0x0112, TryCatch #3 {Exception -> 0x0112, blocks: (B:30:0x00d1, B:32:0x00db, B:37:0x00ed, B:40:0x00f6), top: B:59:0x00d1 }] */
    /* JADX WARN: Code duplicated, block: B:34:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:35:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:62:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public final Object fetchManifest(@NotNull Continuation<? super SyncManifest> continuation) {
        C00251 c00251;
        NiceResponse res;
        String body;
        boolean z;
        if (continuation instanceof C00251) {
            c00251 = (C00251) continuation;
            if ((c00251.label & Integer.MIN_VALUE) != 0) {
                c00251.label -= Integer.MIN_VALUE;
            } else {
                c00251 = new C00251(continuation);
            }
        } else {
            c00251 = new C00251(continuation);
        }
        C00251 c00252 = c00251;
        Object $result = c00252.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00252.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                AppSettingsSyncCreds creds = UltimaStorageManager.INSTANCE.getAppSettingsSyncCreds();
                if (creds == null || !creds.isLoggedIn()) {
                    return null;
                }
                try {
                    String url = creds.getActiveUrl() + "sync/" + creds.getSyncKey() + "/manifest.json";
                    Requests app = MainActivityKt.getApp();
                    c00252.L$0 = SpillingKt.nullOutSpilledVariable(creds);
                    c00252.L$1 = SpillingKt.nullOutSpilledVariable(url);
                    c00252.label = 1;
                    try {
                        Object obj = Requests.get$default(app, url, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00252, 4094, (Object) null);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        $result = obj;
                        try {
                            res = (NiceResponse) $result;
                            if (res.getCode() == 200) {
                                return null;
                            }
                            body = res.getText();
                            if (body.length() == 0) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (!z && !Intrinsics.areEqual(body, "null")) {
                                ObjectMapper $this$readValue$iv = MainAPIKt.getMapper();
                                return (SyncManifest) $this$readValue$iv.readValue(body, new TypeReference<SyncManifest>() { // from class: com.phisher98.UltimaSettingsSyncUtils$fetchManifest$$inlined$readValue$1
                                });
                            }
                            return null;
                        } catch (Exception e) {
                            e = e;
                            Log.INSTANCE.e(TAG, "fetchManifest failed: " + e.getMessage());
                            return null;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        Log.INSTANCE.e(TAG, "fetchManifest failed: " + e.getMessage());
                        return null;
                    }
                } catch (Exception e3) {
                    e = e3;
                }
                break;
            case 1:
                try {
                    ResultKt.throwOnFailure($result);
                    res = (NiceResponse) $result;
                    if (res.getCode() == 200) {
                        return null;
                    }
                    body = res.getText();
                    if (body.length() == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!z) {
                        ObjectMapper $this$readValue$iv2 = MainAPIKt.getMapper();
                        return (SyncManifest) $this$readValue$iv2.readValue(body, new TypeReference<SyncManifest>() { // from class: com.phisher98.UltimaSettingsSyncUtils$fetchManifest$$inlined$readValue$1
                        });
                    }
                    return null;
                } catch (Exception e4) {
                    e = e4;
                    Log.INSTANCE.e(TAG, "fetchManifest failed: " + e.getMessage());
                    return null;
                }
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Code duplicated, block: B:38:0x0105  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public final Object pushManifest(@NotNull SyncManifest manifest, @NotNull Continuation<? super Boolean> continuation) {
        C00291 c00291;
        int code;
        boolean z;
        if (continuation instanceof C00291) {
            c00291 = (C00291) continuation;
            if ((c00291.label & Integer.MIN_VALUE) != 0) {
                c00291.label -= Integer.MIN_VALUE;
            } else {
                c00291 = new C00291(continuation);
            }
        } else {
            c00291 = new C00291(continuation);
        }
        C00291 c00292 = c00291;
        Object $result = c00292.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        boolean z2 = false;
        switch (c00292.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                AppSettingsSyncCreds creds = UltimaStorageManager.INSTANCE.getAppSettingsSyncCreds();
                if (creds != null && creds.isLoggedIn()) {
                    try {
                        String url = creds.getActiveUrl() + "sync/" + creds.getSyncKey() + "/manifest.json";
                        Requests app = MainActivityKt.getApp();
                        c00292.L$0 = SpillingKt.nullOutSpilledVariable(manifest);
                        c00292.L$1 = SpillingKt.nullOutSpilledVariable(creds);
                        c00292.L$2 = SpillingKt.nullOutSpilledVariable(url);
                        c00292.label = 1;
                        try {
                            Object objPut$default = Requests.put$default(app, url, (Map) null, (String) null, (Map) null, (Map) null, (Map) null, (List) null, manifest, (RequestBody) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00292, 65406, (Object) null);
                            if (objPut$default == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            $result = objPut$default;
                            try {
                                NiceResponse res = (NiceResponse) $result;
                                code = res.getCode();
                                if (200 <= code || code >= 300) {
                                    z = false;
                                } else {
                                    z = true;
                                }
                                z2 = z;
                            } catch (Exception e) {
                                e = e;
                                Log.INSTANCE.e(TAG, "pushManifest failed: " + e.getMessage());
                            }
                            return Boxing.boxBoolean(z2);
                        } catch (Exception e2) {
                            e = e2;
                            Log.INSTANCE.e(TAG, "pushManifest failed: " + e.getMessage());
                            return Boxing.boxBoolean(z2);
                        }
                    } catch (Exception e3) {
                        e = e3;
                    }
                }
                return Boxing.boxBoolean(false);
            case 1:
                try {
                    ResultKt.throwOnFailure($result);
                    NiceResponse res2 = (NiceResponse) $result;
                    code = res2.getCode();
                    if (200 <= code) {
                        z = false;
                    } else {
                        z = false;
                    }
                    z2 = z;
                } catch (Exception e4) {
                    e = e4;
                    Log.INSTANCE.e(TAG, "pushManifest failed: " + e.getMessage());
                    return Boxing.boxBoolean(z2);
                }
                return Boxing.boxBoolean(z2);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Code duplicated, block: B:32:0x00f0 A[Catch: Exception -> 0x013b, TryCatch #2 {Exception -> 0x013b, blocks: (B:30:0x00e6, B:32:0x00f0, B:37:0x0102, B:40:0x010b), top: B:56:0x00e6 }] */
    /* JADX WARN: Code duplicated, block: B:34:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:35:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public final Object fetchCategory(@NotNull SyncCategory category, @NotNull Continuation<? super SyncCategoryPayload> continuation) {
        C00231 c00231;
        SyncCategory category2;
        NiceResponse res;
        String body;
        boolean z;
        if (continuation instanceof C00231) {
            c00231 = (C00231) continuation;
            if ((c00231.label & Integer.MIN_VALUE) != 0) {
                c00231.label -= Integer.MIN_VALUE;
            } else {
                c00231 = new C00231(continuation);
            }
        } else {
            c00231 = new C00231(continuation);
        }
        C00231 c00232 = c00231;
        Object $result = c00232.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00232.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                AppSettingsSyncCreds creds = UltimaStorageManager.INSTANCE.getAppSettingsSyncCreds();
                if (creds == null || !creds.isLoggedIn()) {
                    return null;
                }
                try {
                    String url = creds.getActiveUrl() + "sync/" + creds.getSyncKey() + "/categories/" + category.getKey() + ".json";
                    Requests app = MainActivityKt.getApp();
                    c00232.L$0 = category;
                    c00232.L$1 = SpillingKt.nullOutSpilledVariable(creds);
                    c00232.L$2 = SpillingKt.nullOutSpilledVariable(url);
                    c00232.label = 1;
                    try {
                        Object obj = Requests.get$default(app, url, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00232, 4094, (Object) null);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        category2 = category;
                        $result = obj;
                        try {
                            res = (NiceResponse) $result;
                            if (res.getCode() == 200) {
                                body = res.getText();
                                if (body.length() == 0) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                                if (!z && !Intrinsics.areEqual(body, "null")) {
                                    ObjectMapper $this$readValue$iv = MainAPIKt.getMapper();
                                    SyncCategoryPayload payload = (SyncCategoryPayload) $this$readValue$iv.readValue(body, new TypeReference<SyncCategoryPayload>() { // from class: com.phisher98.UltimaSettingsSyncUtils$fetchCategory$$inlined$readValue$1
                                    });
                                    return SyncCategoryPayload.copy$default(payload, decompressData(payload.getData()), 0L, null, 6, null);
                                }
                                return null;
                            }
                        } catch (Exception e) {
                            e = e;
                            Log.INSTANCE.e(TAG, "fetchCategory(" + category2.getKey() + ") failed: " + e.getMessage());
                        }
                        return null;
                    } catch (Exception e2) {
                        e = e2;
                        category2 = category;
                        Log.INSTANCE.e(TAG, "fetchCategory(" + category2.getKey() + ") failed: " + e.getMessage());
                        return null;
                    }
                } catch (Exception e3) {
                    e = e3;
                    category2 = category;
                }
                break;
            case 1:
                category2 = (SyncCategory) c00232.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    res = (NiceResponse) $result;
                    if (res.getCode() == 200) {
                        body = res.getText();
                        if (body.length() == 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (!z) {
                            ObjectMapper $this$readValue$iv2 = MainAPIKt.getMapper();
                            SyncCategoryPayload payload2 = (SyncCategoryPayload) $this$readValue$iv2.readValue(body, new TypeReference<SyncCategoryPayload>() { // from class: com.phisher98.UltimaSettingsSyncUtils$fetchCategory$$inlined$readValue$1
                            });
                            return SyncCategoryPayload.copy$default(payload2, decompressData(payload2.getData()), 0L, null, 6, null);
                        }
                        return null;
                    }
                } catch (Exception e4) {
                    e = e4;
                    Log.INSTANCE.e(TAG, "fetchCategory(" + category2.getKey() + ") failed: " + e.getMessage());
                    return null;
                }
                return null;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Code duplicated, block: B:47:0x0132  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 4 */
    @Nullable
    public final Object registerDevice(@NotNull Continuation<? super Boolean> continuation) {
        C00301 c00301;
        int code;
        boolean z;
        if (continuation instanceof C00301) {
            c00301 = (C00301) continuation;
            if ((c00301.label & Integer.MIN_VALUE) != 0) {
                c00301.label -= Integer.MIN_VALUE;
            } else {
                c00301 = new C00301(continuation);
            }
        } else {
            c00301 = new C00301(continuation);
        }
        C00301 c00302 = c00301;
        Object $result = c00302.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        boolean z2 = false;
        switch (c00302.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                AppSettingsSyncCreds creds = UltimaStorageManager.INSTANCE.getAppSettingsSyncCreds();
                if (creds != null && creds.isLoggedIn()) {
                    try {
                        String deviceUrl = creds.getActiveUrl() + "sync/" + creds.getSyncKey() + "/devices/" + creds.getDeviceId() + ".json";
                        String deviceName = creds.getDeviceName();
                        if (deviceName == null) {
                            deviceName = "Unknown";
                        }
                        String deviceId = creds.getDeviceId();
                        if (deviceId == null) {
                            deviceId = "";
                        }
                        FirebaseDevice device = new FirebaseDevice(deviceName, deviceId, System.currentTimeMillis());
                        Requests app = MainActivityKt.getApp();
                        c00302.L$0 = SpillingKt.nullOutSpilledVariable(creds);
                        c00302.L$1 = SpillingKt.nullOutSpilledVariable(deviceUrl);
                        c00302.L$2 = SpillingKt.nullOutSpilledVariable(device);
                        c00302.label = 1;
                        try {
                            Object objPut$default = Requests.put$default(app, deviceUrl, (Map) null, (String) null, (Map) null, (Map) null, (Map) null, (List) null, device, (RequestBody) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00302, 65406, (Object) null);
                            if (objPut$default == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            $result = objPut$default;
                            try {
                                NiceResponse res = (NiceResponse) $result;
                                code = res.getCode();
                                if (200 <= code || code >= 300) {
                                    z = false;
                                } else {
                                    z = true;
                                }
                                z2 = z;
                            } catch (Exception e) {
                                e = e;
                                Log.INSTANCE.e(TAG, "registerDevice failed: " + e.getMessage());
                            }
                            return Boxing.boxBoolean(z2);
                        } catch (Exception e2) {
                            e = e2;
                            Log.INSTANCE.e(TAG, "registerDevice failed: " + e.getMessage());
                            return Boxing.boxBoolean(z2);
                        }
                    } catch (Exception e3) {
                        e = e3;
                    }
                }
                return Boxing.boxBoolean(false);
            case 1:
                try {
                    ResultKt.throwOnFailure($result);
                    NiceResponse res2 = (NiceResponse) $result;
                    code = res2.getCode();
                    if (200 <= code) {
                        z = false;
                    } else {
                        z = false;
                    }
                    z2 = z;
                } catch (Exception e4) {
                    e = e4;
                    Log.INSTANCE.e(TAG, "registerDevice failed: " + e.getMessage());
                    return Boxing.boxBoolean(z2);
                }
                return Boxing.boxBoolean(z2);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    /* JADX WARN: Code duplicated, block: B:52:0x0105 A[Catch: Exception -> 0x0093, TRY_ENTER, TRY_LEAVE, TryCatch #6 {Exception -> 0x0093, blocks: (B:18:0x0073, B:59:0x0126, B:67:0x0158, B:21:0x008e, B:52:0x0105), top: B:125:0x002a }] */
    /* JADX WARN: Code duplicated, block: B:54:0x010a A[Catch: Exception -> 0x028d, TRY_ENTER, TryCatch #2 {Exception -> 0x028d, blocks: (B:57:0x0122, B:62:0x013c, B:63:0x0140, B:65:0x0146, B:50:0x00ff, B:54:0x010a), top: B:117:0x00ff }] */
    /* JADX WARN: Code duplicated, block: B:56:0x0121 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:59:0x0126 A[Catch: Exception -> 0x0093, TRY_ENTER, TRY_LEAVE, TryCatch #6 {Exception -> 0x0093, blocks: (B:18:0x0073, B:59:0x0126, B:67:0x0158, B:21:0x008e, B:52:0x0105), top: B:125:0x002a }] */
    /* JADX WARN: Code duplicated, block: B:65:0x0146 A[Catch: Exception -> 0x028d, TRY_LEAVE, TryCatch #2 {Exception -> 0x028d, blocks: (B:57:0x0122, B:62:0x013c, B:63:0x0140, B:65:0x0146, B:50:0x00ff, B:54:0x010a), top: B:117:0x00ff }] */
    /* JADX WARN: Code duplicated, block: B:67:0x0158 A[Catch: Exception -> 0x0093, TRY_ENTER, TRY_LEAVE, TryCatch #6 {Exception -> 0x0093, blocks: (B:18:0x0073, B:59:0x0126, B:67:0x0158, B:21:0x008e, B:52:0x0105), top: B:125:0x002a }] */
    /* JADX WARN: Code duplicated, block: B:69:0x0160  */
    /* JADX WARN: Code duplicated, block: B:74:0x01a7 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:75:0x01a8  */
    /* JADX WARN: Code duplicated, block: B:79:0x01b7 A[Catch: Exception -> 0x0288, TryCatch #5 {Exception -> 0x0288, blocks: (B:76:0x01ad, B:77:0x01b1, B:79:0x01b7, B:81:0x01c6, B:84:0x01d0, B:86:0x01d9, B:89:0x01e3, B:98:0x0225, B:99:0x0257), top: B:123:0x01ad }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:81:0x01c6 A[Catch: Exception -> 0x0288, TryCatch #5 {Exception -> 0x0288, blocks: (B:76:0x01ad, B:77:0x01b1, B:79:0x01b7, B:81:0x01c6, B:84:0x01d0, B:86:0x01d9, B:89:0x01e3, B:98:0x0225, B:99:0x0257), top: B:123:0x01ad }] */
    /* JADX WARN: Code duplicated, block: B:83:0x01ce  */
    /* JADX WARN: Code duplicated, block: B:86:0x01d9 A[Catch: Exception -> 0x0288, TryCatch #5 {Exception -> 0x0288, blocks: (B:76:0x01ad, B:77:0x01b1, B:79:0x01b7, B:81:0x01c6, B:84:0x01d0, B:86:0x01d9, B:89:0x01e3, B:98:0x0225, B:99:0x0257), top: B:123:0x01ad }] */
    /* JADX WARN: Code duplicated, block: B:88:0x01e1  */
    @Nullable
    public final Object pushCategories(@NotNull Map<SyncCategory, Pair<String, String>> map, @NotNull Continuation<? super Set<? extends SyncCategory>> continuation) throws NoWhenBranchMatchedException {
        C00271 c00271;
        Set<SyncCategory> successfulCategories;
        Map<SyncCategory, Pair<String, String>> map2;
        long now;
        String deviceName;
        AppSettingsSyncCreds creds;
        Object objFetchManifest;
        SyncManifest currentManifest;
        SyncManifest updatedManifest;
        String str;
        Map<SyncCategory, Pair<String, String>> map3;
        Pair<String, String> pair;
        String str2;
        Iterator it;
        SyncCategory category;
        Pair<String, String> pair2;
        String str3;
        Pair<String, String> pair3;
        String str4;
        Iterator it2;
        if (continuation instanceof C00271) {
            c00271 = (C00271) continuation;
            if ((c00271.label & Integer.MIN_VALUE) != 0) {
                c00271.label -= Integer.MIN_VALUE;
            } else {
                c00271 = new C00271(continuation);
            }
        } else {
            c00271 = new C00271(continuation);
        }
        C00271 c00272 = c00271;
        Object $result = c00272.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        String hash = "";
        try {
            switch (c00272.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    AppSettingsSyncCreds creds2 = UltimaStorageManager.INSTANCE.getAppSettingsSyncCreds();
                    if (creds2 != null && creds2.isLoggedIn() && !map.isEmpty()) {
                        long now2 = System.currentTimeMillis();
                        String deviceName2 = creds2.getDeviceName();
                        if (deviceName2 == null) {
                            deviceName2 = "Unknown";
                        }
                        String deviceName3 = deviceName2;
                        Set successfulCategories2 = new LinkedHashSet();
                        try {
                            Map<SyncCategory, Pair<String, String>> map4 = map;
                            try {
                                C00282 c00282 = new C00282(map4, creds2, now2, deviceName3, successfulCategories2, null);
                                map4 = map;
                                c00272.L$0 = map4;
                                c00272.L$1 = SpillingKt.nullOutSpilledVariable(creds2);
                                c00272.L$2 = deviceName3;
                                c00272.L$3 = successfulCategories2;
                                c00272.J$0 = now2;
                                c00272.label = 1;
                                if (CoroutineScopeKt.coroutineScope(c00282, c00272) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                map2 = map4;
                                now = now2;
                                deviceName = deviceName3;
                                creds = creds2;
                                successfulCategories = successfulCategories2;
                                try {
                                    if (successfulCategories.isEmpty()) {
                                        return SetsKt.emptySet();
                                    }
                                    c00272.L$0 = map2;
                                    c00272.L$1 = SpillingKt.nullOutSpilledVariable(creds);
                                    c00272.L$2 = deviceName;
                                    c00272.L$3 = successfulCategories;
                                    c00272.J$0 = now;
                                    c00272.label = 2;
                                    objFetchManifest = fetchManifest(c00272);
                                    if (objFetchManifest == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    currentManifest = (SyncManifest) objFetchManifest;
                                    if (currentManifest == null) {
                                        currentManifest = new SyncManifest(null, null, null, null, null, 0, 63, null);
                                    }
                                    updatedManifest = currentManifest;
                                    for (SyncCategory category2 : successfulCategories) {
                                        pair = map2.get(category2);
                                        if (pair != null || (str2 = (String) pair.getSecond()) == null) {
                                            str2 = hash;
                                        }
                                        String hash2 = str2;
                                        Object $result2 = $result;
                                        try {
                                            SyncCategoryMeta meta = new SyncCategoryMeta(now, hash2, deviceName);
                                            updatedManifest = updatedManifest.withUpdated(category2, meta);
                                            $result = $result2;
                                            hash = hash;
                                        } catch (Exception e) {
                                            e = e;
                                            Log.INSTANCE.e(TAG, "pushCategories batch error: " + e.getMessage());
                                            return successfulCategories;
                                        }
                                        break;
                                    }
                                    str = hash;
                                    c00272.L$0 = map2;
                                    c00272.L$1 = SpillingKt.nullOutSpilledVariable(creds);
                                    c00272.L$2 = SpillingKt.nullOutSpilledVariable(deviceName);
                                    c00272.L$3 = successfulCategories;
                                    c00272.L$4 = SpillingKt.nullOutSpilledVariable(currentManifest);
                                    c00272.L$5 = SpillingKt.nullOutSpilledVariable(updatedManifest);
                                    c00272.J$0 = now;
                                    c00272.label = 3;
                                    if (pushManifest(updatedManifest, c00272) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    map3 = map2;
                                    try {
                                        it = successfulCategories.iterator();
                                        while (it.hasNext()) {
                                            category = (SyncCategory) it.next();
                                            pair2 = map3.get(category);
                                            if (pair2 != null || (str3 = (String) pair2.getSecond()) == null) {
                                                str3 = str;
                                            }
                                            String hash3 = str3;
                                            pair3 = map3.get(category);
                                            if (pair3 != null || (str4 = (String) pair3.getFirst()) == null) {
                                                str4 = str;
                                            }
                                            String data = str4;
                                            UltimaStorageManager.INSTANCE.setCategoryTimestamp(category, now);
                                            UltimaStorageManager.INSTANCE.setCategoryHash(category, hash3);
                                            try {
                                                ObjectMapper $this$readValue$iv = MainAPIKt.getMapper();
                                                it2 = it;
                                                try {
                                                    BackupFile backupFile = (BackupFile) $this$readValue$iv.readValue(data, new TypeReference<BackupFile>() { // from class: com.phisher98.UltimaSettingsSyncUtils$pushCategories$$inlined$readValue$1
                                                    });
                                                    UltimaStorageManager.INSTANCE.setCategorySyncedKeys(category, UltimaBackupUtils.INSTANCE.getBackupFileKeys(backupFile));
                                                    it = it2;
                                                } catch (Exception e2) {
                                                    e = e2;
                                                    Log.INSTANCE.e(TAG, "Failed to update local synced keys for " + category.getKey() + ": " + e.getMessage());
                                                    it = it2;
                                                }
                                            } catch (Exception e3) {
                                                e = e3;
                                                it2 = it;
                                            }
                                        }
                                        Log.INSTANCE.d(TAG, "Batch pushed " + successfulCategories.size() + '/' + map3.size() + " categories");
                                        break;
                                    } catch (Exception e4) {
                                        e = e4;
                                        Log.INSTANCE.e(TAG, "pushCategories batch error: " + e.getMessage());
                                    }
                                    return successfulCategories;
                                } catch (Exception e5) {
                                    e = e5;
                                    Log.INSTANCE.e(TAG, "pushCategories batch error: " + e.getMessage());
                                    return successfulCategories;
                                }
                            } catch (Exception e6) {
                                e = e6;
                                successfulCategories = successfulCategories2;
                                Log.INSTANCE.e(TAG, "pushCategories batch error: " + e.getMessage());
                                return successfulCategories;
                            }
                        } catch (Exception e7) {
                            e = e7;
                            successfulCategories = successfulCategories2;
                        }
                    }
                    return SetsKt.emptySet();
                case 1:
                    now = c00272.J$0;
                    successfulCategories = (Set) c00272.L$3;
                    deviceName = (String) c00272.L$2;
                    creds = (AppSettingsSyncCreds) c00272.L$1;
                    map2 = (Map) c00272.L$0;
                    ResultKt.throwOnFailure($result);
                    if (successfulCategories.isEmpty()) {
                        return SetsKt.emptySet();
                    }
                    c00272.L$0 = map2;
                    c00272.L$1 = SpillingKt.nullOutSpilledVariable(creds);
                    c00272.L$2 = deviceName;
                    c00272.L$3 = successfulCategories;
                    c00272.J$0 = now;
                    c00272.label = 2;
                    objFetchManifest = fetchManifest(c00272);
                    if (objFetchManifest == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    currentManifest = (SyncManifest) objFetchManifest;
                    if (currentManifest == null) {
                        currentManifest = new SyncManifest(null, null, null, null, null, 0, 63, null);
                    }
                    updatedManifest = currentManifest;
                    while (r15.hasNext()) {
                        pair = map2.get(category2);
                        if (pair != null) {
                            str2 = hash;
                        } else {
                            str2 = hash;
                        }
                        String hash4 = str2;
                        Object $result3 = $result;
                        SyncCategoryMeta meta2 = new SyncCategoryMeta(now, hash4, deviceName);
                        updatedManifest = updatedManifest.withUpdated(category2, meta2);
                        $result = $result3;
                        hash = hash;
                        break;
                    }
                    str = hash;
                    c00272.L$0 = map2;
                    c00272.L$1 = SpillingKt.nullOutSpilledVariable(creds);
                    c00272.L$2 = SpillingKt.nullOutSpilledVariable(deviceName);
                    c00272.L$3 = successfulCategories;
                    c00272.L$4 = SpillingKt.nullOutSpilledVariable(currentManifest);
                    c00272.L$5 = SpillingKt.nullOutSpilledVariable(updatedManifest);
                    c00272.J$0 = now;
                    c00272.label = 3;
                    if (pushManifest(updatedManifest, c00272) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    map3 = map2;
                    it = successfulCategories.iterator();
                    while (it.hasNext()) {
                        category = (SyncCategory) it.next();
                        pair2 = map3.get(category);
                        if (pair2 != null) {
                            str3 = str;
                        } else {
                            str3 = str;
                        }
                        String hash5 = str3;
                        pair3 = map3.get(category);
                        if (pair3 != null) {
                            str4 = str;
                        } else {
                            str4 = str;
                        }
                        String data2 = str4;
                        UltimaStorageManager.INSTANCE.setCategoryTimestamp(category, now);
                        UltimaStorageManager.INSTANCE.setCategoryHash(category, hash5);
                        ObjectMapper $this$readValue$iv2 = MainAPIKt.getMapper();
                        it2 = it;
                        BackupFile backupFile2 = (BackupFile) $this$readValue$iv2.readValue(data2, new TypeReference<BackupFile>() { // from class: com.phisher98.UltimaSettingsSyncUtils$pushCategories$$inlined$readValue$1
                        });
                        UltimaStorageManager.INSTANCE.setCategorySyncedKeys(category, UltimaBackupUtils.INSTANCE.getBackupFileKeys(backupFile2));
                        it = it2;
                    }
                    Log.INSTANCE.d(TAG, "Batch pushed " + successfulCategories.size() + '/' + map3.size() + " categories");
                    return successfulCategories;
                case 2:
                    now = c00272.J$0;
                    successfulCategories = (Set) c00272.L$3;
                    deviceName = (String) c00272.L$2;
                    creds = (AppSettingsSyncCreds) c00272.L$1;
                    map2 = (Map) c00272.L$0;
                    ResultKt.throwOnFailure($result);
                    objFetchManifest = $result;
                    currentManifest = (SyncManifest) objFetchManifest;
                    if (currentManifest == null) {
                        currentManifest = new SyncManifest(null, null, null, null, null, 0, 63, null);
                    }
                    updatedManifest = currentManifest;
                    while (r15.hasNext()) {
                        pair = map2.get(category2);
                        if (pair != null) {
                            str2 = hash;
                        } else {
                            str2 = hash;
                        }
                        String hash6 = str2;
                        Object $result4 = $result;
                        SyncCategoryMeta meta3 = new SyncCategoryMeta(now, hash6, deviceName);
                        updatedManifest = updatedManifest.withUpdated(category2, meta3);
                        $result = $result4;
                        hash = hash;
                        break;
                    }
                    str = hash;
                    c00272.L$0 = map2;
                    c00272.L$1 = SpillingKt.nullOutSpilledVariable(creds);
                    c00272.L$2 = SpillingKt.nullOutSpilledVariable(deviceName);
                    c00272.L$3 = successfulCategories;
                    c00272.L$4 = SpillingKt.nullOutSpilledVariable(currentManifest);
                    c00272.L$5 = SpillingKt.nullOutSpilledVariable(updatedManifest);
                    c00272.J$0 = now;
                    c00272.label = 3;
                    if (pushManifest(updatedManifest, c00272) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    map3 = map2;
                    it = successfulCategories.iterator();
                    while (it.hasNext()) {
                        category = (SyncCategory) it.next();
                        pair2 = map3.get(category);
                        if (pair2 != null) {
                            str3 = str;
                        } else {
                            str3 = str;
                        }
                        String hash7 = str3;
                        pair3 = map3.get(category);
                        if (pair3 != null) {
                            str4 = str;
                        } else {
                            str4 = str;
                        }
                        String data3 = str4;
                        UltimaStorageManager.INSTANCE.setCategoryTimestamp(category, now);
                        UltimaStorageManager.INSTANCE.setCategoryHash(category, hash7);
                        ObjectMapper $this$readValue$iv3 = MainAPIKt.getMapper();
                        it2 = it;
                        BackupFile backupFile3 = (BackupFile) $this$readValue$iv3.readValue(data3, new TypeReference<BackupFile>() { // from class: com.phisher98.UltimaSettingsSyncUtils$pushCategories$$inlined$readValue$1
                        });
                        UltimaStorageManager.INSTANCE.setCategorySyncedKeys(category, UltimaBackupUtils.INSTANCE.getBackupFileKeys(backupFile3));
                        it = it2;
                    }
                    Log.INSTANCE.d(TAG, "Batch pushed " + successfulCategories.size() + '/' + map3.size() + " categories");
                    return successfulCategories;
                case 3:
                    now = c00272.J$0;
                    successfulCategories = (Set) c00272.L$3;
                    map3 = (Map) c00272.L$0;
                    try {
                        ResultKt.throwOnFailure($result);
                        str = "";
                        it = successfulCategories.iterator();
                        while (it.hasNext()) {
                            category = (SyncCategory) it.next();
                            pair2 = map3.get(category);
                            if (pair2 != null) {
                                str3 = str;
                            } else {
                                str3 = str;
                            }
                            String hash8 = str3;
                            pair3 = map3.get(category);
                            if (pair3 != null) {
                                str4 = str;
                            } else {
                                str4 = str;
                            }
                            String data4 = str4;
                            UltimaStorageManager.INSTANCE.setCategoryTimestamp(category, now);
                            UltimaStorageManager.INSTANCE.setCategoryHash(category, hash8);
                            ObjectMapper $this$readValue$iv4 = MainAPIKt.getMapper();
                            it2 = it;
                            BackupFile backupFile4 = (BackupFile) $this$readValue$iv4.readValue(data4, new TypeReference<BackupFile>() { // from class: com.phisher98.UltimaSettingsSyncUtils$pushCategories$$inlined$readValue$1
                            });
                            UltimaStorageManager.INSTANCE.setCategorySyncedKeys(category, UltimaBackupUtils.INSTANCE.getBackupFileKeys(backupFile4));
                            it = it2;
                        }
                        Log.INSTANCE.d(TAG, "Batch pushed " + successfulCategories.size() + '/' + map3.size() + " categories");
                        break;
                    } catch (Exception e8) {
                        e = e8;
                        Log.INSTANCE.e(TAG, "pushCategories batch error: " + e.getMessage());
                        return successfulCategories;
                    }
                    return successfulCategories;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } catch (Exception e9) {
            e = e9;
        }
    }

    /* JADX INFO: renamed from: com.phisher98.UltimaSettingsSyncUtils$pushCategories$2 */
    /* JADX INFO: compiled from: UltimaSettingsSyncUtils.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.UltimaSettingsSyncUtils$pushCategories$2", f = "UltimaSettingsSyncUtils.kt", i = {0, 0}, l = {341}, m = "invokeSuspend", n = {"$this$coroutineScope", "jobs"}, nl = {342}, s = {"L$0", "L$1"}, v = 2)
    @SourceDebugExtension({"SMAP\nUltimaSettingsSyncUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UltimaSettingsSyncUtils.kt\ncom/phisher98/UltimaSettingsSyncUtils$pushCategories$2\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,459:1\n129#2:460\n158#2,3:461\n777#3:464\n873#3,2:465\n2068#3,2:467\n*S KotlinDebug\n*F\n+ 1 UltimaSettingsSyncUtils.kt\ncom/phisher98/UltimaSettingsSyncUtils$pushCategories$2\n*L\n321#1:460\n321#1:461,3\n342#1:464\n342#1:465,2\n342#1:467,2\n*E\n"})
    static final class C00282 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Map<SyncCategory, Pair<String, String>> $categoryData;
        final /* synthetic */ AppSettingsSyncCreds $creds;
        final /* synthetic */ String $deviceName;
        final /* synthetic */ long $now;
        final /* synthetic */ Set<SyncCategory> $successfulCategories;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00282(Map<SyncCategory, Pair<String, String>> map, AppSettingsSyncCreds appSettingsSyncCreds, long j, String str, Set<SyncCategory> set, Continuation<? super C00282> continuation) {
            super(2, continuation);
            this.$categoryData = map;
            this.$creds = appSettingsSyncCreds;
            this.$now = j;
            this.$deviceName = str;
            this.$successfulCategories = set;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00282 = new C00282(this.$categoryData, this.$creds, this.$now, this.$deviceName, this.$successfulCategories, continuation);
            c00282.L$0 = obj;
            return c00282;
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object objAwaitAll;
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    Map<SyncCategory, Pair<String, String>> map = this.$categoryData;
                    AppSettingsSyncCreds appSettingsSyncCreds = this.$creds;
                    long j = this.$now;
                    String str = this.$deviceName;
                    ArrayList arrayList = new ArrayList(map.size());
                    for (Map.Entry<SyncCategory, Pair<String, String>> entry : map.entrySet()) {
                        SyncCategory key = entry.getKey();
                        Pair<String, String> value = entry.getValue();
                        ArrayList arrayList2 = arrayList;
                        arrayList2.add(BuildersKt.async$default(coroutineScope, Dispatchers.getIO(), (CoroutineStart) null, new UltimaSettingsSyncUtils$pushCategories$2$jobs$1$1(appSettingsSyncCreds, key, value, j, str, null), 2, (Object) null));
                        arrayList = arrayList2;
                    }
                    ArrayList arrayList3 = arrayList;
                    this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(arrayList3);
                    this.label = 1;
                    objAwaitAll = AwaitKt.awaitAll(arrayList3, (Continuation) this);
                    if (objAwaitAll == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                    break;
                case 1:
                    ResultKt.throwOnFailure(obj);
                    objAwaitAll = obj;
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ArrayList arrayList4 = new ArrayList();
            for (Object obj2 : (List) objAwaitAll) {
                if (((Boolean) ((Pair) obj2).getSecond()).booleanValue()) {
                    arrayList4.add(obj2);
                }
            }
            Set<SyncCategory> set = this.$successfulCategories;
            Iterator it = arrayList4.iterator();
            while (it.hasNext()) {
                set.add((SyncCategory) ((Pair) it.next()).getFirst());
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public final Object fetchDevices(@NotNull Continuation<? super List<FirebaseDevice>> continuation) {
        C00241 c00241;
        if (continuation instanceof C00241) {
            c00241 = (C00241) continuation;
            if ((c00241.label & Integer.MIN_VALUE) != 0) {
                c00241.label -= Integer.MIN_VALUE;
            } else {
                c00241 = new C00241(continuation);
            }
        } else {
            c00241 = new C00241(continuation);
        }
        C00241 c00242 = c00241;
        Object $result = c00242.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00242.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                AppSettingsSyncCreds creds = UltimaStorageManager.INSTANCE.getAppSettingsSyncCreds();
                if (creds == null || !creds.isLoggedIn()) {
                    return null;
                }
                try {
                    String url = creds.getActiveUrl() + "sync/" + creds.getSyncKey() + "/devices.json";
                    Requests app = MainActivityKt.getApp();
                    c00242.L$0 = SpillingKt.nullOutSpilledVariable(creds);
                    c00242.L$1 = SpillingKt.nullOutSpilledVariable(url);
                    c00242.label = 1;
                    try {
                        Object obj = Requests.get$default(app, url, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00242, 4094, (Object) null);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        $result = obj;
                    } catch (Exception e) {
                        return null;
                    }
                } catch (Exception e2) {
                    return null;
                }
                break;
                break;
            case 1:
                try {
                    ResultKt.throwOnFailure($result);
                } catch (Exception e3) {
                    return null;
                }
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        try {
            NiceResponse res = (NiceResponse) $result;
            if (res.getCode() != 200) {
                return null;
            }
            String body = res.getText();
            if (!(body.length() == 0) && !Intrinsics.areEqual(body, "null")) {
                ObjectMapper $this$readValue$iv = MainAPIKt.getMapper();
                Map map = (Map) $this$readValue$iv.readValue(body, new TypeReference<Map<String, ? extends FirebaseDevice>>() { // from class: com.phisher98.UltimaSettingsSyncUtils$fetchDevices$$inlined$readValue$1
                });
                return CollectionsKt.toList(map.values());
            }
            return CollectionsKt.emptyList();
        } catch (Exception e4) {
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public final Object fetchSharedData(@NotNull Continuation<? super FirebaseSharedData> continuation) {
        C00261 c00261;
        if (continuation instanceof C00261) {
            c00261 = (C00261) continuation;
            if ((c00261.label & Integer.MIN_VALUE) != 0) {
                c00261.label -= Integer.MIN_VALUE;
            } else {
                c00261 = new C00261(continuation);
            }
        } else {
            c00261 = new C00261(continuation);
        }
        C00261 c00262 = c00261;
        Object $result = c00262.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00262.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                AppSettingsSyncCreds creds = UltimaStorageManager.INSTANCE.getAppSettingsSyncCreds();
                if (creds == null || !creds.isLoggedIn()) {
                    return null;
                }
                try {
                    String url = creds.getActiveUrl() + "sync/" + creds.getSyncKey() + "/shared_data.json";
                    Requests app = MainActivityKt.getApp();
                    c00262.L$0 = SpillingKt.nullOutSpilledVariable(creds);
                    c00262.L$1 = SpillingKt.nullOutSpilledVariable(url);
                    c00262.label = 1;
                    try {
                        Object obj = Requests.get$default(app, url, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00262, 4094, (Object) null);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        $result = obj;
                    } catch (Exception e) {
                        return null;
                    }
                } catch (Exception e2) {
                    return null;
                }
                break;
                break;
            case 1:
                try {
                    ResultKt.throwOnFailure($result);
                } catch (Exception e3) {
                    return null;
                }
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        try {
            NiceResponse res = (NiceResponse) $result;
            if (res.getCode() != 200) {
                return null;
            }
            String body = res.getText();
            if (!(body.length() == 0) && !Intrinsics.areEqual(body, "null")) {
                ObjectMapper $this$readValue$iv = MainAPIKt.getMapper();
                return (FirebaseSharedData) $this$readValue$iv.readValue(body, new TypeReference<FirebaseSharedData>() { // from class: com.phisher98.UltimaSettingsSyncUtils$fetchSharedData$$inlined$readValue$1
                });
            }
            return null;
        } catch (Exception e4) {
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:38:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public final Object deleteSharedData(@NotNull Continuation<? super Boolean> continuation) {
        C00211 c00211;
        int code;
        boolean z;
        if (continuation instanceof C00211) {
            c00211 = (C00211) continuation;
            if ((c00211.label & Integer.MIN_VALUE) != 0) {
                c00211.label -= Integer.MIN_VALUE;
            } else {
                c00211 = new C00211(continuation);
            }
        } else {
            c00211 = new C00211(continuation);
        }
        C00211 c00212 = c00211;
        Object $result = c00212.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        boolean z2 = false;
        switch (c00212.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                AppSettingsSyncCreds creds = UltimaStorageManager.INSTANCE.getAppSettingsSyncCreds();
                if (creds != null && creds.isLoggedIn()) {
                    try {
                        String url = creds.getActiveUrl() + "sync/" + creds.getSyncKey() + "/shared_data.json";
                        Requests app = MainActivityKt.getApp();
                        c00212.L$0 = SpillingKt.nullOutSpilledVariable(creds);
                        c00212.L$1 = SpillingKt.nullOutSpilledVariable(url);
                        c00212.label = 1;
                        try {
                            Object objDelete$default = Requests.delete$default(app, url, (Map) null, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, (RequestBody) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00212, 65534, (Object) null);
                            if (objDelete$default == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            $result = objDelete$default;
                            try {
                                NiceResponse res = (NiceResponse) $result;
                                code = res.getCode();
                                if (200 <= code || code >= 300) {
                                    z = false;
                                } else {
                                    z = true;
                                }
                                z2 = z;
                            } catch (Exception e) {
                            }
                            return Boxing.boxBoolean(z2);
                        } catch (Exception e2) {
                        }
                    } catch (Exception e3) {
                    }
                }
                return Boxing.boxBoolean(false);
            case 1:
                try {
                    ResultKt.throwOnFailure($result);
                    NiceResponse res2 = (NiceResponse) $result;
                    code = res2.getCode();
                    if (200 <= code) {
                        z = false;
                    } else {
                        z = false;
                    }
                    z2 = z;
                } catch (Exception e4) {
                }
                return Boxing.boxBoolean(z2);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Code duplicated, block: B:37:0x0112  */
    /* JADX WARN: Code duplicated, block: B:39:0x0115 A[Catch: Exception -> 0x0140, TryCatch #0 {Exception -> 0x0140, blocks: (B:32:0x0102, B:39:0x0115, B:40:0x0120), top: B:51:0x0102 }] */
    /* JADX WARN: Code duplicated, block: B:40:0x0120 A[Catch: Exception -> 0x0140, TRY_LEAVE, TryCatch #0 {Exception -> 0x0140, blocks: (B:32:0x0102, B:39:0x0115, B:40:0x0120), top: B:51:0x0102 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public final Object deregisterThisDevice(@NotNull Continuation<? super Pair<Boolean, String>> continuation) {
        C00221 c00221;
        boolean z;
        NiceResponse res;
        int code;
        boolean z2;
        Pair pair;
        if (continuation instanceof C00221) {
            c00221 = (C00221) continuation;
            if ((c00221.label & Integer.MIN_VALUE) != 0) {
                c00221.label -= Integer.MIN_VALUE;
            } else {
                c00221 = new C00221(continuation);
            }
        } else {
            c00221 = new C00221(continuation);
        }
        C00221 c00222 = c00221;
        Object $result = c00222.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00222.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                AppSettingsSyncCreds creds = UltimaStorageManager.INSTANCE.getAppSettingsSyncCreds();
                if (creds == null) {
                    return TuplesKt.to(Boxing.boxBoolean(false), "Credentials not found");
                }
                if (!creds.isLoggedIn()) {
                    return TuplesKt.to(Boxing.boxBoolean(false), "Not logged in");
                }
                try {
                    String url = creds.getActiveUrl() + "sync/" + creds.getSyncKey() + "/devices/" + creds.getDeviceId() + ".json";
                    Requests app = MainActivityKt.getApp();
                    c00222.L$0 = SpillingKt.nullOutSpilledVariable(creds);
                    c00222.L$1 = SpillingKt.nullOutSpilledVariable(url);
                    c00222.label = 1;
                    z = true;
                    try {
                        Object objDelete$default = Requests.delete$default(app, url, (Map) null, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, (RequestBody) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00222, 65534, (Object) null);
                        if (objDelete$default == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        $result = objDelete$default;
                        try {
                            res = (NiceResponse) $result;
                            code = res.getCode();
                            if (200 <= code || code >= 300) {
                                z2 = false;
                            } else {
                                z2 = true;
                            }
                            if (z2) {
                                pair = TuplesKt.to(Boxing.boxBoolean(z), "Device removed");
                            } else {
                                pair = TuplesKt.to(Boxing.boxBoolean(false), "Failed to remove device with code " + res.getCode());
                            }
                            return pair;
                        } catch (Exception e) {
                            e = e;
                            return TuplesKt.to(Boxing.boxBoolean(false), e.getMessage());
                        }
                    } catch (Exception e2) {
                        e = e2;
                        return TuplesKt.to(Boxing.boxBoolean(false), e.getMessage());
                    }
                } catch (Exception e3) {
                    e = e3;
                }
                break;
            case 1:
                try {
                    ResultKt.throwOnFailure($result);
                    z = true;
                    res = (NiceResponse) $result;
                    code = res.getCode();
                    if (200 <= code) {
                        z2 = false;
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        pair = TuplesKt.to(Boxing.boxBoolean(z), "Device removed");
                    } else {
                        pair = TuplesKt.to(Boxing.boxBoolean(false), "Failed to remove device with code " + res.getCode());
                    }
                    return pair;
                } catch (Exception e4) {
                    e = e4;
                    return TuplesKt.to(Boxing.boxBoolean(false), e.getMessage());
                }
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Code duplicated, block: B:37:0x011b  */
    /* JADX WARN: Code duplicated, block: B:39:0x011e A[Catch: Exception -> 0x0149, TryCatch #2 {Exception -> 0x0149, blocks: (B:32:0x010b, B:39:0x011e, B:40:0x0129), top: B:55:0x010b }] */
    /* JADX WARN: Code duplicated, block: B:40:0x0129 A[Catch: Exception -> 0x0149, TRY_LEAVE, TryCatch #2 {Exception -> 0x0149, blocks: (B:32:0x010b, B:39:0x011e, B:40:0x0129), top: B:55:0x010b }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public final Object removeDevice(@NotNull String deviceId, @NotNull Continuation<? super Pair<Boolean, String>> continuation) {
        C00311 c00311;
        boolean z;
        NiceResponse res;
        int code;
        boolean z2;
        Pair pair;
        if (continuation instanceof C00311) {
            c00311 = (C00311) continuation;
            if ((c00311.label & Integer.MIN_VALUE) != 0) {
                c00311.label -= Integer.MIN_VALUE;
            } else {
                c00311 = new C00311(continuation);
            }
        } else {
            c00311 = new C00311(continuation);
        }
        C00311 c00312 = c00311;
        Object $result = c00312.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00312.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                AppSettingsSyncCreds creds = UltimaStorageManager.INSTANCE.getAppSettingsSyncCreds();
                if (creds == null) {
                    return TuplesKt.to(Boxing.boxBoolean(false), "Credentials not found");
                }
                if (!creds.isLoggedIn()) {
                    return TuplesKt.to(Boxing.boxBoolean(false), "Not logged in");
                }
                try {
                    String url = creds.getActiveUrl() + "sync/" + creds.getSyncKey() + "/devices/" + deviceId + ".json";
                    Requests app = MainActivityKt.getApp();
                    c00312.L$0 = SpillingKt.nullOutSpilledVariable(deviceId);
                    c00312.L$1 = SpillingKt.nullOutSpilledVariable(creds);
                    c00312.L$2 = SpillingKt.nullOutSpilledVariable(url);
                    c00312.label = 1;
                    z = true;
                    try {
                        Object objDelete$default = Requests.delete$default(app, url, (Map) null, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, (RequestBody) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00312, 65534, (Object) null);
                        if (objDelete$default == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        $result = objDelete$default;
                        try {
                            res = (NiceResponse) $result;
                            code = res.getCode();
                            if (200 <= code || code >= 300) {
                                z2 = false;
                            } else {
                                z2 = true;
                            }
                            if (z2) {
                                pair = TuplesKt.to(Boxing.boxBoolean(z), "Device removed");
                            } else {
                                pair = TuplesKt.to(Boxing.boxBoolean(false), "Failed with code " + res.getCode());
                            }
                            return pair;
                        } catch (Exception e) {
                            e = e;
                            return TuplesKt.to(Boxing.boxBoolean(false), e.getMessage());
                        }
                    } catch (Exception e2) {
                        e = e2;
                        return TuplesKt.to(Boxing.boxBoolean(false), e.getMessage());
                    }
                } catch (Exception e3) {
                    e = e3;
                }
                break;
            case 1:
                try {
                    ResultKt.throwOnFailure($result);
                    z = true;
                    res = (NiceResponse) $result;
                    code = res.getCode();
                    if (200 <= code) {
                        z2 = false;
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        pair = TuplesKt.to(Boxing.boxBoolean(z), "Device removed");
                    } else {
                        pair = TuplesKt.to(Boxing.boxBoolean(false), "Failed with code " + res.getCode());
                    }
                    return pair;
                } catch (Exception e4) {
                    e = e4;
                    return TuplesKt.to(Boxing.boxBoolean(false), e.getMessage());
                }
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
