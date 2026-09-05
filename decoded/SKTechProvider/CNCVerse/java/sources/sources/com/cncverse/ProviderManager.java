package com.cncverse;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.mvvm.ArchComponentExtKt;
import com.lagradost.cloudstream3.utils.AppUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.modules.SerializersModule;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ProviderManager.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/SKTechProvider/CNCVerse/java/classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u0005H\u0002J\u000e\u0010\u000f\u001a\u00020\u0005H\u0082@¢\u0006\u0002\u0010\u0010J \u0010\u0011\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u000e0\rH\u0086@¢\u0006\u0002\u0010\u0010J\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\rH\u0086@¢\u0006\u0002\u0010\u0010J\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\r2\u0006\u0010\u0015\u001a\u00020\u0005H\u0086@¢\u0006\u0002\u0010\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/cncverse/ProviderManager;", "", "<init>", "()V", "DEFAULT_BASE_URL", "", "cachedBaseUrl", "parseDateTime", "date", "time", "client", "Lokhttp3/OkHttpClient;", "fallbackProviders", "", "", "getBaseUrl", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchProviders", "fetchLiveEvents", "Lcom/cncverse/LiveEventData;", "fetchCustomEvents", "catLink", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "SKTechProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nProviderManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ProviderManager.kt\ncom/cncverse/ProviderManager\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,390:1\n1#2:391\n*E\n"})
public final class ProviderManager {

    @NotNull
    private static final String DEFAULT_BASE_URL = "https://matkeritnagurorxbxb.store";

    @Nullable
    private static String cachedBaseUrl;

    @NotNull
    public static final ProviderManager INSTANCE = new ProviderManager();

    @NotNull
    private static final OkHttpClient client = new OkHttpClient.Builder().connectTimeout(30, TimeUnit.SECONDS).readTimeout(30, TimeUnit.SECONDS).build();

    @NotNull
    private static final List<Map<String, Object>> fallbackProviders = CollectionsKt.emptyList();

    /* JADX INFO: renamed from: com.cncverse.ProviderManager$getBaseUrl$1 */
    /* JADX INFO: compiled from: ProviderManager.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.ProviderManager", f = "ProviderManager.kt", i = {}, l = {144}, m = "getBaseUrl", n = {}, nl = {145}, s = {}, v = 2)
    static final class C00341 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C00341(Continuation<? super C00341> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ProviderManager.this.getBaseUrl((Continuation) this);
        }
    }

    private ProviderManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String parseDateTime(String date, String time) {
        if (date == null || time == null) {
            return null;
        }
        try {
            List parts = StringsKt.split$default(date, new String[]{"/"}, false, 0, 6, (Object) null);
            if (parts.size() == 3) {
                String day = (String) parts.get(0);
                String month = (String) parts.get(1);
                String year = (String) parts.get(2);
                return year + '/' + month + '/' + day + ' ' + time + " +0000";
            }
        } catch (Exception e) {
            System.out.println((Object) ("SKTech: Failed to parse date/time: " + date + ' ' + time));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object getBaseUrl(Continuation<? super String> continuation) {
        C00341 c00341;
        Object baseApiUrl;
        if (continuation instanceof C00341) {
            c00341 = (C00341) continuation;
            if ((c00341.label & Integer.MIN_VALUE) != 0) {
                c00341.label -= Integer.MIN_VALUE;
            } else {
                c00341 = new C00341(continuation);
            }
        } else {
            c00341 = new C00341(continuation);
        }
        Object $result = c00341.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        boolean z = true;
        switch (c00341.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                String it = cachedBaseUrl;
                if (it != null) {
                    return it;
                }
                FirebaseRemoteConfigFetcher firebaseRemoteConfigFetcher = FirebaseRemoteConfigFetcher.INSTANCE;
                c00341.label = 1;
                baseApiUrl = firebaseRemoteConfigFetcher.getBaseApiUrl(c00341);
                if (baseApiUrl == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                baseApiUrl = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        String firebaseUrl = (String) baseApiUrl;
        String str = firebaseUrl;
        if (str != null && !StringsKt.isBlank(str)) {
            z = false;
        }
        if (!z) {
            cachedBaseUrl = firebaseUrl;
            String str2 = cachedBaseUrl;
            Intrinsics.checkNotNull(str2);
            return str2;
        }
        cachedBaseUrl = DEFAULT_BASE_URL;
        return DEFAULT_BASE_URL;
    }

    /* JADX INFO: renamed from: com.cncverse.ProviderManager$fetchProviders$2 */
    /* JADX INFO: compiled from: ProviderManager.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010 \n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001*\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "", "", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.ProviderManager$fetchProviders$2", f = "ProviderManager.kt", i = {}, l = {159}, m = "invokeSuspend", n = {}, nl = {160}, s = {}, v = 2)
    @SourceDebugExtension({"SMAP\nProviderManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ProviderManager.kt\ncom/cncverse/ProviderManager$fetchProviders$2\n+ 2 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n+ 5 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,390:1\n63#2:391\n64#2,15:393\n63#2:414\n64#2,15:416\n1#3:392\n1#3:415\n1#3:433\n50#4:408\n43#4:409\n50#4:431\n43#4:432\n1606#5:410\n1617#5:411\n1924#5,2:412\n1926#5:434\n1618#5:435\n*S KotlinDebug\n*F\n+ 1 ProviderManager.kt\ncom/cncverse/ProviderManager$fetchProviders$2\n*L\n178#1:391\n178#1:393,15\n183#1:414\n183#1:416,15\n178#1:392\n183#1:415\n181#1:433\n178#1:408\n178#1:409\n183#1:431\n183#1:432\n181#1:410\n181#1:411\n181#1:412,2\n181#1:434\n181#1:435\n*E\n"})
    static final class C00312 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Map<String, ? extends Object>>>, Object> {
        int label;

        C00312(Continuation<? super C00312> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C00312(continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends Map<String, ? extends Object>>> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:101:0x024e  */
        /* JADX WARN: Code duplicated, block: B:118:0x0275  */
        /* JADX WARN: Code duplicated, block: B:122:0x02a2 A[Catch: Exception -> 0x0300, TryCatch #7 {Exception -> 0x0300, blocks: (B:99:0x0248, B:102:0x024f, B:120:0x0292, B:122:0x02a2, B:125:0x02ca, B:119:0x0277, B:117:0x026e, B:98:0x023e), top: B:162:0x0248 }] */
        /* JADX WARN: Code duplicated, block: B:124:0x02c8  */
        /* JADX WARN: Code duplicated, block: B:129:0x02e9  */
        /* JADX WARN: Code duplicated, block: B:134:0x02fa  */
        /* JADX WARN: Code duplicated, block: B:143:0x033c A[Catch: Exception -> 0x001e, TryCatch #10 {Exception -> 0x001e, blocks: (B:6:0x0018, B:14:0x0033, B:16:0x0070, B:18:0x007d, B:24:0x0089, B:26:0x00bf, B:32:0x00cb, B:48:0x0129, B:56:0x0158, B:59:0x015f, B:69:0x0191, B:70:0x01aa, B:72:0x01b0, B:74:0x01b8, B:75:0x01bb, B:143:0x033c, B:140:0x030d, B:145:0x034a, B:68:0x017a, B:67:0x0174, B:55:0x014d, B:47:0x011f, B:147:0x0355, B:148:0x035f, B:149:0x0369, B:11:0x0025, B:52:0x0131, B:62:0x0165), top: B:166:0x000d, inners: #3, #16 }] */
        /* JADX WARN: Code duplicated, block: B:156:0x0131 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:167:0x0209 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:179:0x0255 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:181:0x0165 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:185:0x0340 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:58:0x015e  */
        /* JADX WARN: Code duplicated, block: B:68:0x017a A[Catch: Exception -> 0x001e, TryCatch #10 {Exception -> 0x001e, blocks: (B:6:0x0018, B:14:0x0033, B:16:0x0070, B:18:0x007d, B:24:0x0089, B:26:0x00bf, B:32:0x00cb, B:48:0x0129, B:56:0x0158, B:59:0x015f, B:69:0x0191, B:70:0x01aa, B:72:0x01b0, B:74:0x01b8, B:75:0x01bb, B:143:0x033c, B:140:0x030d, B:145:0x034a, B:68:0x017a, B:67:0x0174, B:55:0x014d, B:47:0x011f, B:147:0x0355, B:148:0x035f, B:149:0x0369, B:11:0x0025, B:52:0x0131, B:62:0x0165), top: B:166:0x000d, inners: #3, #16 }] */
        /* JADX WARN: Code duplicated, block: B:72:0x01b0 A[Catch: Exception -> 0x001e, TryCatch #10 {Exception -> 0x001e, blocks: (B:6:0x0018, B:14:0x0033, B:16:0x0070, B:18:0x007d, B:24:0x0089, B:26:0x00bf, B:32:0x00cb, B:48:0x0129, B:56:0x0158, B:59:0x015f, B:69:0x0191, B:70:0x01aa, B:72:0x01b0, B:74:0x01b8, B:75:0x01bb, B:143:0x033c, B:140:0x030d, B:145:0x034a, B:68:0x017a, B:67:0x0174, B:55:0x014d, B:47:0x011f, B:147:0x0355, B:148:0x035f, B:149:0x0369, B:11:0x0025, B:52:0x0131, B:62:0x0165), top: B:166:0x000d, inners: #3, #16 }] */
        /* JADX WARN: Code duplicated, block: B:74:0x01b8 A[Catch: Exception -> 0x001e, TryCatch #10 {Exception -> 0x001e, blocks: (B:6:0x0018, B:14:0x0033, B:16:0x0070, B:18:0x007d, B:24:0x0089, B:26:0x00bf, B:32:0x00cb, B:48:0x0129, B:56:0x0158, B:59:0x015f, B:69:0x0191, B:70:0x01aa, B:72:0x01b0, B:74:0x01b8, B:75:0x01bb, B:143:0x033c, B:140:0x030d, B:145:0x034a, B:68:0x017a, B:67:0x0174, B:55:0x014d, B:47:0x011f, B:147:0x0355, B:148:0x035f, B:149:0x0369, B:11:0x0025, B:52:0x0131, B:62:0x0165), top: B:166:0x000d, inners: #3, #16 }] */
        /* JADX WARN: Code duplicated, block: B:85:0x0201  */
        /* JADX WARN: Type inference failed for: r18v2, types: [boolean] */
        /* JADX WARN: Type inference failed for: r18v4 */
        /* JADX WARN: Type inference failed for: r18v5 */
        public final Object invokeSuspend(Object obj) {
            Object baseUrl;
            char c;
            boolean z;
            Object obj2;
            ?? r18;
            DeserializationStrategy deserializationStrategy;
            Object objDecodeFromString;
            List list;
            ArrayList arrayList;
            int i;
            int i2;
            List list2;
            String str;
            String str2;
            Map mapMapOf;
            String cat;
            Object obj3;
            String str3;
            DeserializationStrategy deserializationStrategy2;
            String str4;
            Object objDecodeFromString2;
            SKTechCategoryData sKTechCategoryData;
            String logo;
            String type;
            String str5 = "kotlinx.serialization.serializer.simple";
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            try {
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure(obj);
                        this.label = 1;
                        baseUrl = ProviderManager.INSTANCE.getBaseUrl((Continuation) this);
                        if (baseUrl == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        ResultKt.throwOnFailure(obj);
                        baseUrl = obj;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                String str6 = ((String) baseUrl) + "/categories.txt";
                Response responseExecute = ProviderManager.client.newCall(new Request.Builder().url(str6).header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36").build()).execute();
                if (responseExecute.isSuccessful()) {
                    String strString = responseExecute.body().string();
                    String str7 = strString;
                    if (str7 == null || StringsKt.isBlank(str7)) {
                        System.out.println((Object) "SKTech: Empty response from categories URL");
                    } else {
                        System.out.println((Object) ("SKTech: Fetched encrypted categories data: " + strString.length() + " chars"));
                        String strDecryptSKLive = SKLiveCryptoUtils.INSTANCE.decryptSKLive(StringsKt.trim(strString).toString());
                        String str8 = strDecryptSKLive;
                        if (!(str8 == null || StringsKt.isBlank(str8))) {
                            System.out.println((Object) ("SKTech: Decrypted categories successfully: " + strDecryptSKLive.length() + " chars"));
                            AppUtils appUtils = AppUtils.INSTANCE;
                            try {
                                Result.Companion companion = Result.Companion;
                                c = 1;
                                try {
                                    z = false;
                                    r18 = 0;
                                    try {
                                        KType kTypeTypeOf = Reflection.typeOf(List.class, KTypeProjection.Companion.invariant(Reflection.typeOf(SKTechCategoryWrapper.class)));
                                        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                                        obj2 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                                    } catch (Throwable th) {
                                        th = th;
                                        Result.Companion companion2 = Result.Companion;
                                        obj2 = Result.constructor-impl(ResultKt.createFailure(th));
                                        r18 = z;
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    z = false;
                                    Result.Companion companion3 = Result.Companion;
                                    obj2 = Result.constructor-impl(ResultKt.createFailure(th));
                                    r18 = z;
                                    if (Result.exceptionOrNull-impl(obj2) != null) {
                                        try {
                                            Result.Companion companion4 = Result.Companion;
                                            obj2 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(List.class), (List) null, 2, (Object) null));
                                        } catch (Throwable th3) {
                                            Result.Companion companion5 = Result.Companion;
                                            obj2 = Result.constructor-impl(ResultKt.createFailure(th3));
                                        }
                                    }
                                    if (Result.isFailure-impl(obj2)) {
                                        obj2 = null;
                                    }
                                    deserializationStrategy = (KSerializer) obj2;
                                    if (deserializationStrategy != null) {
                                        try {
                                            objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, strDecryptSKLive);
                                        } catch (SerializationException e) {
                                            ArchComponentExtKt.logError(e);
                                            objDecodeFromString = MainAPIKt.getMapper().readValue(strDecryptSKLive, new TypeReference<List<? extends SKTechCategoryWrapper>>() { // from class: com.cncverse.ProviderManager$fetchProviders$2$invokeSuspend$$inlined$parseJson$1
                                            });
                                        } catch (Throwable th4) {
                                            objDecodeFromString = MainAPIKt.getMapper().readValue(strDecryptSKLive, new TypeReference<List<? extends SKTechCategoryWrapper>>() { // from class: com.cncverse.ProviderManager$fetchProviders$2$invokeSuspend$$inlined$parseJson$1
                                            });
                                        }
                                    } else {
                                        objDecodeFromString = MainAPIKt.getMapper().readValue(strDecryptSKLive, new TypeReference<List<? extends SKTechCategoryWrapper>>() { // from class: com.cncverse.ProviderManager$fetchProviders$2$invokeSuspend$$inlined$parseJson$1
                                        });
                                    }
                                    list = (List) objDecodeFromString;
                                    arrayList = new ArrayList();
                                    i = 0;
                                    for (Object obj4 : list) {
                                        int i3 = i + 1;
                                        if (i < 0) {
                                            CollectionsKt.throwIndexOverflow();
                                        }
                                        i2 = i;
                                        SKTechCategoryWrapper sKTechCategoryWrapper = (SKTechCategoryWrapper) obj4;
                                        try {
                                            AppUtils appUtils2 = AppUtils.INSTANCE;
                                            cat = sKTechCategoryWrapper.getCat();
                                            try {
                                                Result.Companion companion6 = Result.Companion;
                                                KType kTypeTypeOf2 = Reflection.typeOf(SKTechCategoryData.class);
                                                MagicApiIntrinsics.voidMagicApiCall(str5);
                                                obj3 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf2));
                                            } catch (Throwable th5) {
                                                Result.Companion companion7 = Result.Companion;
                                                obj3 = Result.constructor-impl(ResultKt.createFailure(th5));
                                            }
                                            if (Result.exceptionOrNull-impl(obj3) == null) {
                                                list2 = list;
                                                str = str5;
                                                str2 = str6;
                                                str3 = null;
                                            } else {
                                                try {
                                                    Result.Companion companion8 = Result.Companion;
                                                    list2 = list;
                                                    try {
                                                        str = str5;
                                                        str2 = str6;
                                                        str3 = null;
                                                        try {
                                                            obj3 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(SKTechCategoryData.class), (List) null, 2, (Object) null));
                                                        } catch (Throwable th6) {
                                                            th = th6;
                                                            Result.Companion companion9 = Result.Companion;
                                                            obj3 = Result.constructor-impl(ResultKt.createFailure(th));
                                                        }
                                                    } catch (Throwable th7) {
                                                        th = th7;
                                                        str = str5;
                                                        str2 = str6;
                                                        str3 = null;
                                                    }
                                                } catch (Throwable th8) {
                                                    th = th8;
                                                    list2 = list;
                                                    str = str5;
                                                    str2 = str6;
                                                    str3 = null;
                                                }
                                            }
                                            try {
                                                if (Result.isFailure-impl(obj3)) {
                                                    obj3 = str3;
                                                }
                                                deserializationStrategy2 = (KSerializer) obj3;
                                                if (deserializationStrategy2 != null) {
                                                    try {
                                                        str4 = cat;
                                                        try {
                                                            objDecodeFromString2 = MainAPIKt.getJson().decodeFromString(deserializationStrategy2, str4);
                                                        } catch (SerializationException e2) {
                                                            e = e2;
                                                            ArchComponentExtKt.logError((Throwable) e);
                                                            objDecodeFromString2 = MainAPIKt.getMapper().readValue(str4, new TypeReference<SKTechCategoryData>() { // from class: com.cncverse.ProviderManager$fetchProviders$2$invokeSuspend$lambda$0$$inlined$parseJson$1
                                                            });
                                                        } catch (Throwable th9) {
                                                            objDecodeFromString2 = MainAPIKt.getMapper().readValue(str4, new TypeReference<SKTechCategoryData>() { // from class: com.cncverse.ProviderManager$fetchProviders$2$invokeSuspend$lambda$0$$inlined$parseJson$1
                                                            });
                                                        }
                                                    } catch (SerializationException e3) {
                                                        e = e3;
                                                        str4 = cat;
                                                    } catch (Throwable th10) {
                                                        str4 = cat;
                                                    }
                                                    sKTechCategoryData = (SKTechCategoryData) objDecodeFromString2;
                                                    if (Intrinsics.areEqual(sKTechCategoryData.getVisible(), Boxing.boxBoolean((boolean) r18))) {
                                                        mapMapOf = null;
                                                    } else {
                                                        Pair[] pairArr = new Pair[5];
                                                        pairArr[r18] = TuplesKt.to("id", Boxing.boxInt(i2 + 1));
                                                        pairArr[c] = TuplesKt.to("title", sKTechCategoryData.getName());
                                                        logo = sKTechCategoryData.getLogo();
                                                        if (logo == null) {
                                                            logo = "";
                                                        }
                                                        try {
                                                            pairArr[2] = TuplesKt.to("image", logo);
                                                            pairArr[3] = TuplesKt.to("catLink", sKTechCategoryData.getApi());
                                                            type = sKTechCategoryData.getType();
                                                            if (type == null) {
                                                                type = "m3u";
                                                            }
                                                            pairArr[4] = TuplesKt.to("type", type);
                                                            mapMapOf = MapsKt.mapOf(pairArr);
                                                        } catch (Exception e4) {
                                                            e = e4;
                                                            System.out.println((Object) ("SKTech: Failed to parse category at index " + i2 + ": " + e.getMessage()));
                                                            e.printStackTrace();
                                                            mapMapOf = null;
                                                        }
                                                    }
                                                    if (mapMapOf != null) {
                                                        arrayList.add(mapMapOf);
                                                    }
                                                    str6 = str2;
                                                    i = i3;
                                                    str5 = str;
                                                    list = list2;
                                                } else {
                                                    str4 = cat;
                                                }
                                                objDecodeFromString2 = MainAPIKt.getMapper().readValue(str4, new TypeReference<SKTechCategoryData>() { // from class: com.cncverse.ProviderManager$fetchProviders$2$invokeSuspend$lambda$0$$inlined$parseJson$1
                                                });
                                                sKTechCategoryData = (SKTechCategoryData) objDecodeFromString2;
                                                if (Intrinsics.areEqual(sKTechCategoryData.getVisible(), Boxing.boxBoolean((boolean) r18))) {
                                                    Pair[] pairArr2 = new Pair[5];
                                                    pairArr2[r18] = TuplesKt.to("id", Boxing.boxInt(i2 + 1));
                                                    pairArr2[c] = TuplesKt.to("title", sKTechCategoryData.getName());
                                                    logo = sKTechCategoryData.getLogo();
                                                    if (logo == null) {
                                                        logo = "";
                                                    }
                                                    pairArr2[2] = TuplesKt.to("image", logo);
                                                    pairArr2[3] = TuplesKt.to("catLink", sKTechCategoryData.getApi());
                                                    type = sKTechCategoryData.getType();
                                                    if (type == null) {
                                                        type = "m3u";
                                                    }
                                                    pairArr2[4] = TuplesKt.to("type", type);
                                                    mapMapOf = MapsKt.mapOf(pairArr2);
                                                } else {
                                                    mapMapOf = null;
                                                }
                                            } catch (Exception e5) {
                                                e = e5;
                                            }
                                        } catch (Exception e6) {
                                            e = e6;
                                            list2 = list;
                                            str = str5;
                                            str2 = str6;
                                            System.out.println((Object) ("SKTech: Failed to parse category at index " + i2 + ": " + e.getMessage()));
                                            e.printStackTrace();
                                            mapMapOf = null;
                                            if (mapMapOf != null) {
                                                arrayList.add(mapMapOf);
                                            }
                                            str6 = str2;
                                            i = i3;
                                            str5 = str;
                                            list = list2;
                                        }
                                        if (mapMapOf != null) {
                                            arrayList.add(mapMapOf);
                                        }
                                        str6 = str2;
                                        i = i3;
                                        str5 = str;
                                        list = list2;
                                    }
                                    return arrayList;
                                }
                            } catch (Throwable th11) {
                                th = th11;
                                c = 1;
                            }
                            if (Result.exceptionOrNull-impl(obj2) != null) {
                                Result.Companion companion10 = Result.Companion;
                                obj2 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(List.class), (List) null, 2, (Object) null));
                            }
                            if (Result.isFailure-impl(obj2)) {
                                obj2 = null;
                            }
                            deserializationStrategy = (KSerializer) obj2;
                            if (deserializationStrategy != null) {
                                objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, strDecryptSKLive);
                            } else {
                                objDecodeFromString = MainAPIKt.getMapper().readValue(strDecryptSKLive, new TypeReference<List<? extends SKTechCategoryWrapper>>() { // from class: com.cncverse.ProviderManager$fetchProviders$2$invokeSuspend$$inlined$parseJson$1
                                });
                            }
                            list = (List) objDecodeFromString;
                            arrayList = new ArrayList();
                            i = 0;
                            while (r17.hasNext()) {
                                int i4 = i + 1;
                                if (i < 0) {
                                    CollectionsKt.throwIndexOverflow();
                                }
                                i2 = i;
                                SKTechCategoryWrapper sKTechCategoryWrapper2 = (SKTechCategoryWrapper) obj4;
                                AppUtils appUtils3 = AppUtils.INSTANCE;
                                cat = sKTechCategoryWrapper2.getCat();
                                Result.Companion companion11 = Result.Companion;
                                KType kTypeTypeOf3 = Reflection.typeOf(SKTechCategoryData.class);
                                MagicApiIntrinsics.voidMagicApiCall(str5);
                                obj3 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf3));
                                if (Result.exceptionOrNull-impl(obj3) == null) {
                                    list2 = list;
                                    str = str5;
                                    str2 = str6;
                                    str3 = null;
                                } else {
                                    Result.Companion companion12 = Result.Companion;
                                    list2 = list;
                                    str = str5;
                                    str2 = str6;
                                    str3 = null;
                                    obj3 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(SKTechCategoryData.class), (List) null, 2, (Object) null));
                                }
                                if (Result.isFailure-impl(obj3)) {
                                    obj3 = str3;
                                }
                                deserializationStrategy2 = (KSerializer) obj3;
                                if (deserializationStrategy2 != null) {
                                    str4 = cat;
                                    objDecodeFromString2 = MainAPIKt.getJson().decodeFromString(deserializationStrategy2, str4);
                                    sKTechCategoryData = (SKTechCategoryData) objDecodeFromString2;
                                    if (Intrinsics.areEqual(sKTechCategoryData.getVisible(), Boxing.boxBoolean((boolean) r18))) {
                                        Pair[] pairArr3 = new Pair[5];
                                        pairArr3[r18] = TuplesKt.to("id", Boxing.boxInt(i2 + 1));
                                        pairArr3[c] = TuplesKt.to("title", sKTechCategoryData.getName());
                                        logo = sKTechCategoryData.getLogo();
                                        if (logo == null) {
                                            logo = "";
                                        }
                                        pairArr3[2] = TuplesKt.to("image", logo);
                                        pairArr3[3] = TuplesKt.to("catLink", sKTechCategoryData.getApi());
                                        type = sKTechCategoryData.getType();
                                        if (type == null) {
                                            type = "m3u";
                                        }
                                        pairArr3[4] = TuplesKt.to("type", type);
                                        mapMapOf = MapsKt.mapOf(pairArr3);
                                    } else {
                                        mapMapOf = null;
                                    }
                                    if (mapMapOf != null) {
                                        arrayList.add(mapMapOf);
                                    }
                                    str6 = str2;
                                    i = i4;
                                    str5 = str;
                                    list = list2;
                                } else {
                                    str4 = cat;
                                }
                                objDecodeFromString2 = MainAPIKt.getMapper().readValue(str4, new TypeReference<SKTechCategoryData>() { // from class: com.cncverse.ProviderManager$fetchProviders$2$invokeSuspend$lambda$0$$inlined$parseJson$1
                                });
                                sKTechCategoryData = (SKTechCategoryData) objDecodeFromString2;
                                if (Intrinsics.areEqual(sKTechCategoryData.getVisible(), Boxing.boxBoolean((boolean) r18))) {
                                    Pair[] pairArr4 = new Pair[5];
                                    pairArr4[r18] = TuplesKt.to("id", Boxing.boxInt(i2 + 1));
                                    pairArr4[c] = TuplesKt.to("title", sKTechCategoryData.getName());
                                    logo = sKTechCategoryData.getLogo();
                                    if (logo == null) {
                                        logo = "";
                                    }
                                    pairArr4[2] = TuplesKt.to("image", logo);
                                    pairArr4[3] = TuplesKt.to("catLink", sKTechCategoryData.getApi());
                                    type = sKTechCategoryData.getType();
                                    if (type == null) {
                                        type = "m3u";
                                    }
                                    pairArr4[4] = TuplesKt.to("type", type);
                                    mapMapOf = MapsKt.mapOf(pairArr4);
                                } else {
                                    mapMapOf = null;
                                }
                                if (mapMapOf != null) {
                                    arrayList.add(mapMapOf);
                                }
                                str6 = str2;
                                i = i4;
                                str5 = str;
                                list = list2;
                            }
                            return arrayList;
                        }
                        System.out.println((Object) "SKTech: Failed to decrypt categories data");
                    }
                } else {
                    System.out.println((Object) ("SKTech: HTTP error " + responseExecute.code() + " fetching categories"));
                }
            } catch (Exception e7) {
                System.out.println((Object) ("SKTech: Exception fetching providers: " + e7.getMessage()));
                e7.printStackTrace();
            }
            return ProviderManager.fallbackProviders;
        }
    }

    @Nullable
    public final Object fetchProviders(@NotNull Continuation<? super List<? extends Map<String, ? extends Object>>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new C00312(null), continuation);
    }

    /* JADX INFO: renamed from: com.cncverse.ProviderManager$fetchLiveEvents$2 */
    /* JADX INFO: compiled from: ProviderManager.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lcom/cncverse/LiveEventData;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.ProviderManager$fetchLiveEvents$2", f = "ProviderManager.kt", i = {}, l = {229}, m = "invokeSuspend", n = {}, nl = {230}, s = {}, v = 2)
    @SourceDebugExtension({"SMAP\nProviderManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ProviderManager.kt\ncom/cncverse/ProviderManager$fetchLiveEvents$2\n+ 2 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n+ 5 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,390:1\n63#2:391\n64#2,15:393\n63#2:414\n64#2,15:416\n1#3:392\n1#3:415\n1#3:443\n50#4:408\n43#4:409\n50#4:431\n43#4:432\n1606#5:410\n1617#5:411\n1924#5,2:412\n1596#5:433\n1629#5,4:434\n1596#5:438\n1629#5,4:439\n1926#5:444\n1618#5:445\n777#5:446\n873#5,2:447\n*S KotlinDebug\n*F\n+ 1 ProviderManager.kt\ncom/cncverse/ProviderManager$fetchLiveEvents$2\n*L\n248#1:391\n248#1:393,15\n253#1:414\n253#1:416,15\n248#1:392\n253#1:415\n251#1:443\n248#1:408\n248#1:409\n253#1:431\n253#1:432\n251#1:410\n251#1:411\n251#1:412,2\n276#1:433\n276#1:434,4\n281#1:438\n281#1:439,4\n251#1:444\n251#1:445\n296#1:446\n296#1:447,2\n*E\n"})
    static final class C00282 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends LiveEventData>>, Object> {
        int label;

        C00282(Continuation<? super C00282> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C00282(continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<LiveEventData>> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:120:0x029b  */
        /* JADX WARN: Code duplicated, block: B:124:0x02a9  */
        /* JADX WARN: Code duplicated, block: B:128:0x02b5  */
        /* JADX WARN: Code duplicated, block: B:131:0x02bd  */
        /* JADX WARN: Code duplicated, block: B:135:0x02ed A[Catch: Exception -> 0x0434, TryCatch #9 {Exception -> 0x0434, blocks: (B:126:0x02af, B:133:0x02c3, B:135:0x02ed, B:139:0x02fc, B:143:0x0333, B:145:0x033b, B:146:0x0352, B:148:0x0358, B:150:0x0360, B:151:0x0363, B:152:0x038a, B:166:0x042a, B:153:0x0398, B:155:0x03a0, B:157:0x03b8, B:158:0x03ce, B:160:0x03d4, B:162:0x03dc, B:163:0x03df, B:164:0x0417, B:165:0x0423), top: B:210:0x02af }] */
        /* JADX WARN: Code duplicated, block: B:138:0x02fa  */
        /* JADX WARN: Code duplicated, block: B:141:0x032e  */
        /* JADX WARN: Code duplicated, block: B:142:0x0331  */
        /* JADX WARN: Code duplicated, block: B:145:0x033b A[Catch: Exception -> 0x0434, TryCatch #9 {Exception -> 0x0434, blocks: (B:126:0x02af, B:133:0x02c3, B:135:0x02ed, B:139:0x02fc, B:143:0x0333, B:145:0x033b, B:146:0x0352, B:148:0x0358, B:150:0x0360, B:151:0x0363, B:152:0x038a, B:166:0x042a, B:153:0x0398, B:155:0x03a0, B:157:0x03b8, B:158:0x03ce, B:160:0x03d4, B:162:0x03dc, B:163:0x03df, B:164:0x0417, B:165:0x0423), top: B:210:0x02af }] */
        /* JADX WARN: Code duplicated, block: B:148:0x0358 A[Catch: Exception -> 0x0434, TryCatch #9 {Exception -> 0x0434, blocks: (B:126:0x02af, B:133:0x02c3, B:135:0x02ed, B:139:0x02fc, B:143:0x0333, B:145:0x033b, B:146:0x0352, B:148:0x0358, B:150:0x0360, B:151:0x0363, B:152:0x038a, B:166:0x042a, B:153:0x0398, B:155:0x03a0, B:157:0x03b8, B:158:0x03ce, B:160:0x03d4, B:162:0x03dc, B:163:0x03df, B:164:0x0417, B:165:0x0423), top: B:210:0x02af }] */
        /* JADX WARN: Code duplicated, block: B:150:0x0360 A[Catch: Exception -> 0x0434, TryCatch #9 {Exception -> 0x0434, blocks: (B:126:0x02af, B:133:0x02c3, B:135:0x02ed, B:139:0x02fc, B:143:0x0333, B:145:0x033b, B:146:0x0352, B:148:0x0358, B:150:0x0360, B:151:0x0363, B:152:0x038a, B:166:0x042a, B:153:0x0398, B:155:0x03a0, B:157:0x03b8, B:158:0x03ce, B:160:0x03d4, B:162:0x03dc, B:163:0x03df, B:164:0x0417, B:165:0x0423), top: B:210:0x02af }] */
        /* JADX WARN: Code duplicated, block: B:153:0x0398 A[Catch: Exception -> 0x0434, TryCatch #9 {Exception -> 0x0434, blocks: (B:126:0x02af, B:133:0x02c3, B:135:0x02ed, B:139:0x02fc, B:143:0x0333, B:145:0x033b, B:146:0x0352, B:148:0x0358, B:150:0x0360, B:151:0x0363, B:152:0x038a, B:166:0x042a, B:153:0x0398, B:155:0x03a0, B:157:0x03b8, B:158:0x03ce, B:160:0x03d4, B:162:0x03dc, B:163:0x03df, B:164:0x0417, B:165:0x0423), top: B:210:0x02af }] */
        /* JADX WARN: Code duplicated, block: B:155:0x03a0 A[Catch: Exception -> 0x0434, TryCatch #9 {Exception -> 0x0434, blocks: (B:126:0x02af, B:133:0x02c3, B:135:0x02ed, B:139:0x02fc, B:143:0x0333, B:145:0x033b, B:146:0x0352, B:148:0x0358, B:150:0x0360, B:151:0x0363, B:152:0x038a, B:166:0x042a, B:153:0x0398, B:155:0x03a0, B:157:0x03b8, B:158:0x03ce, B:160:0x03d4, B:162:0x03dc, B:163:0x03df, B:164:0x0417, B:165:0x0423), top: B:210:0x02af }] */
        /* JADX WARN: Code duplicated, block: B:165:0x0423 A[Catch: Exception -> 0x0434, TryCatch #9 {Exception -> 0x0434, blocks: (B:126:0x02af, B:133:0x02c3, B:135:0x02ed, B:139:0x02fc, B:143:0x0333, B:145:0x033b, B:146:0x0352, B:148:0x0358, B:150:0x0360, B:151:0x0363, B:152:0x038a, B:166:0x042a, B:153:0x0398, B:155:0x03a0, B:157:0x03b8, B:158:0x03ce, B:160:0x03d4, B:162:0x03dc, B:163:0x03df, B:164:0x0417, B:165:0x0423), top: B:210:0x02af }] */
        /* JADX WARN: Code duplicated, block: B:178:0x0472 A[Catch: Exception -> 0x001e, TryCatch #11 {Exception -> 0x001e, blocks: (B:6:0x0018, B:14:0x0033, B:16:0x0070, B:18:0x007d, B:24:0x0089, B:26:0x00bf, B:32:0x00cb, B:43:0x0123, B:51:0x0152, B:54:0x0159, B:64:0x018b, B:65:0x01a4, B:67:0x01aa, B:69:0x01b2, B:70:0x01b5, B:178:0x0472, B:175:0x0443, B:180:0x0482, B:181:0x049f, B:183:0x04a5, B:188:0x04b9, B:189:0x04bd, B:63:0x0174, B:62:0x016e, B:50:0x0147, B:42:0x0119, B:191:0x04c2, B:192:0x04ce, B:193:0x04da, B:11:0x0025, B:47:0x012b, B:57:0x015f), top: B:214:0x000d, inners: #4, #16 }] */
        /* JADX WARN: Code duplicated, block: B:229:0x0476 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:232:0x0363 A[SYNTHETIC] */
        /* JADX WARN: Unreachable blocks removed: 2, instructions: 5 */
        public final Object invokeSuspend(Object $result) {
            Object baseUrl;
            boolean z;
            Object obj;
            Object objDecodeFromString;
            List wrappers;
            String str;
            String eventsUrl;
            String baseUrl2;
            LiveEventData liveEventData;
            Object obj2;
            String value$iv;
            Object objDecodeFromString2;
            SKTechEventData eventData;
            String eventName;
            String links;
            String strSubstringBeforeLast$default;
            String str2;
            int i;
            Iterable link_names;
            String links2;
            List listEmptyList;
            Iterable iterableSplit$default;
            Iterable $this$mapIndexed$iv;
            Collection destination$iv$iv;
            Iterable $this$mapIndexedTo$iv$iv;
            int index$iv$iv;
            String str3 = "kotlinx.serialization.serializer.simple";
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            try {
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        this.label = 1;
                        baseUrl = ProviderManager.INSTANCE.getBaseUrl((Continuation) this);
                        if (baseUrl == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        ResultKt.throwOnFailure($result);
                        baseUrl = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                String baseUrl3 = (String) baseUrl;
                String eventsUrl2 = baseUrl3 + "/events.txt";
                Request request = new Request.Builder().url(eventsUrl2).header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36").build();
                Response response = ProviderManager.client.newCall(request).execute();
                if (response.isSuccessful()) {
                    String encryptedData = response.body().string();
                    String str4 = encryptedData;
                    if (str4 == null || StringsKt.isBlank(str4)) {
                        System.out.println((Object) "SKTech: Empty response from events URL");
                    } else {
                        System.out.println((Object) ("SKTech: Fetched encrypted events data: " + encryptedData.length() + " chars"));
                        String decryptedData = SKLiveCryptoUtils.INSTANCE.decryptSKLive(StringsKt.trim(encryptedData).toString());
                        String str5 = decryptedData;
                        if (!(str5 == null || StringsKt.isBlank(str5))) {
                            System.out.println((Object) ("SKTech: Decrypted events successfully: " + decryptedData.length() + " chars"));
                            AppUtils appUtils = AppUtils.INSTANCE;
                            try {
                                Result.Companion companion = Result.Companion;
                                z = false;
                                try {
                                    KType kTypeTypeOf = Reflection.typeOf(List.class, KTypeProjection.Companion.invariant(Reflection.typeOf(SKTechEventWrapper.class)));
                                    MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                                    obj = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                                } catch (Throwable th) {
                                    th = th;
                                    Result.Companion companion2 = Result.Companion;
                                    obj = Result.constructor-impl(ResultKt.createFailure(th));
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                z = false;
                            }
                            if (Result.exceptionOrNull-impl(obj) != null) {
                                try {
                                    Result.Companion companion3 = Result.Companion;
                                    obj = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(List.class), (List) null, 2, (Object) null));
                                } catch (Throwable th3) {
                                    Result.Companion companion4 = Result.Companion;
                                    obj = Result.constructor-impl(ResultKt.createFailure(th3));
                                }
                            }
                            if (Result.isFailure-impl(obj)) {
                                obj = null;
                            }
                            DeserializationStrategy deserializationStrategy = (KSerializer) obj;
                            if (deserializationStrategy != null) {
                                try {
                                    objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, decryptedData);
                                } catch (SerializationException e) {
                                    ArchComponentExtKt.logError(e);
                                    ObjectMapper $this$readValue$iv$iv = MainAPIKt.getMapper();
                                    objDecodeFromString = $this$readValue$iv$iv.readValue(decryptedData, new TypeReference<List<? extends SKTechEventWrapper>>() { // from class: com.cncverse.ProviderManager$fetchLiveEvents$2$invokeSuspend$$inlined$parseJson$1
                                    });
                                } catch (Throwable th4) {
                                    ObjectMapper $this$readValue$iv$iv2 = MainAPIKt.getMapper();
                                    objDecodeFromString = $this$readValue$iv$iv2.readValue(decryptedData, new TypeReference<List<? extends SKTechEventWrapper>>() { // from class: com.cncverse.ProviderManager$fetchLiveEvents$2$invokeSuspend$$inlined$parseJson$1
                                    });
                                }
                            } else {
                                ObjectMapper $this$readValue$iv$iv3 = MainAPIKt.getMapper();
                                objDecodeFromString = $this$readValue$iv$iv3.readValue(decryptedData, new TypeReference<List<? extends SKTechEventWrapper>>() { // from class: com.cncverse.ProviderManager$fetchLiveEvents$2$invokeSuspend$$inlined$parseJson$1
                                });
                            }
                            List wrappers2 = (List) objDecodeFromString;
                            List $this$mapIndexedNotNull$iv = wrappers2;
                            Collection destination$iv$iv2 = new ArrayList();
                            int index$iv$iv$iv = 0;
                            for (Object item$iv$iv$iv : $this$mapIndexedNotNull$iv) {
                                int index$iv$iv$iv2 = index$iv$iv$iv + 1;
                                if (index$iv$iv$iv < 0) {
                                    CollectionsKt.throwIndexOverflow();
                                }
                                int index$iv$iv2 = index$iv$iv$iv;
                                SKTechEventWrapper wrapper = (SKTechEventWrapper) item$iv$iv$iv;
                                try {
                                    AppUtils appUtils2 = AppUtils.INSTANCE;
                                    String value$iv2 = wrapper.getEvent();
                                    try {
                                        Result.Companion companion5 = Result.Companion;
                                        KType kTypeTypeOf2 = Reflection.typeOf(SKTechEventData.class);
                                        MagicApiIntrinsics.voidMagicApiCall(str3);
                                        obj2 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf2));
                                    } catch (Throwable th5) {
                                        Result.Companion companion6 = Result.Companion;
                                        obj2 = Result.constructor-impl(ResultKt.createFailure(th5));
                                    }
                                    if (Result.exceptionOrNull-impl(obj2) == null) {
                                        wrappers = wrappers2;
                                        str = str3;
                                        eventsUrl = eventsUrl2;
                                    } else {
                                        try {
                                            Result.Companion companion7 = Result.Companion;
                                            wrappers = wrappers2;
                                            try {
                                                str = str3;
                                                eventsUrl = eventsUrl2;
                                                try {
                                                    obj2 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(SKTechEventData.class), (List) null, 2, (Object) null));
                                                } catch (Throwable th6) {
                                                    th = th6;
                                                    Result.Companion companion8 = Result.Companion;
                                                    obj2 = Result.constructor-impl(ResultKt.createFailure(th));
                                                }
                                            } catch (Throwable th7) {
                                                th = th7;
                                                str = str3;
                                                eventsUrl = eventsUrl2;
                                            }
                                        } catch (Throwable th8) {
                                            th = th8;
                                            wrappers = wrappers2;
                                            str = str3;
                                            eventsUrl = eventsUrl2;
                                        }
                                    }
                                    try {
                                        DeserializationStrategy deserializationStrategy2 = (KSerializer) (Result.isFailure-impl(obj2) ? null : obj2);
                                        if (deserializationStrategy2 != null) {
                                            try {
                                                value$iv = value$iv2;
                                                try {
                                                    objDecodeFromString2 = MainAPIKt.getJson().decodeFromString(deserializationStrategy2, value$iv);
                                                } catch (SerializationException e2) {
                                                    e$iv = e2;
                                                    try {
                                                        ArchComponentExtKt.logError((Throwable) e$iv);
                                                        ObjectMapper $this$readValue$iv$iv4 = MainAPIKt.getMapper();
                                                        String content$iv$iv = value$iv;
                                                        objDecodeFromString2 = $this$readValue$iv$iv4.readValue(content$iv$iv, new TypeReference<SKTechEventData>() { // from class: com.cncverse.ProviderManager$fetchLiveEvents$2$invokeSuspend$lambda$0$$inlined$parseJson$1
                                                        });
                                                    } catch (Exception e3) {
                                                        e = e3;
                                                        baseUrl2 = baseUrl3;
                                                        System.out.println((Object) ("SKTech: Failed to parse event at index " + index$iv$iv2 + ": " + e.getMessage()));
                                                        e.printStackTrace();
                                                        liveEventData = null;
                                                        if (liveEventData != null) {
                                                            destination$iv$iv2.add(liveEventData);
                                                        }
                                                        baseUrl3 = baseUrl2;
                                                        index$iv$iv$iv = index$iv$iv$iv2;
                                                        str3 = str;
                                                        wrappers2 = wrappers;
                                                        eventsUrl2 = eventsUrl;
                                                    }
                                                } catch (Throwable th9) {
                                                    ObjectMapper $this$readValue$iv$iv5 = MainAPIKt.getMapper();
                                                    String content$iv$iv2 = value$iv;
                                                    objDecodeFromString2 = $this$readValue$iv$iv5.readValue(content$iv$iv2, new TypeReference<SKTechEventData>() { // from class: com.cncverse.ProviderManager$fetchLiveEvents$2$invokeSuspend$lambda$0$$inlined$parseJson$1
                                                    });
                                                }
                                            } catch (SerializationException e4) {
                                                e$iv = e4;
                                                value$iv = value$iv2;
                                            } catch (Throwable th10) {
                                                value$iv = value$iv2;
                                            }
                                            eventData = (SKTechEventData) objDecodeFromString2;
                                            int i2 = index$iv$iv2 + 1;
                                            eventName = eventData.getEventName();
                                            if (eventName == null) {
                                                eventName = "Unknown Event";
                                            }
                                            String str6 = eventName;
                                            String eventLogo = eventData.getEventLogo();
                                            links = eventData.getLinks();
                                            if (links != null) {
                                                baseUrl2 = baseUrl3;
                                                try {
                                                    strSubstringBeforeLast$default = StringsKt.substringBeforeLast$default(links, ".", (String) null, 2, (Object) null);
                                                    if (strSubstringBeforeLast$default == null) {
                                                    }
                                                    String str7 = strSubstringBeforeLast$default;
                                                    String category = eventData.getCategory();
                                                    String teamAName = eventData.getTeamAName();
                                                    String teamBName = eventData.getTeamBName();
                                                    String teamAFlag = eventData.getTeamAFlag();
                                                    String teamBFlag = eventData.getTeamBFlag();
                                                    String category2 = eventData.getCategory();
                                                    String eventName2 = eventData.getEventName();
                                                    String eventLogo2 = eventData.getEventLogo();
                                                    if (eventData.getPriority() != null || eventData.getPriority().intValue() <= 0) {
                                                        str2 = "0";
                                                    } else {
                                                        str2 = "1";
                                                    }
                                                    LiveEventInfo liveEventInfo = new LiveEventInfo(teamAName, teamBName, teamAFlag, teamBFlag, category2, eventName2, eventLogo2, str2, null, ProviderManager.INSTANCE.parseDateTime(eventData.getDate(), eventData.getTime()), ProviderManager.INSTANCE.parseDateTime(eventData.getEnd_date(), eventData.getEnd_time()));
                                                    if (Intrinsics.areEqual(eventData.getVisible(), Boxing.boxBoolean(z))) {
                                                        i = 0;
                                                    } else {
                                                        i = 1;
                                                    }
                                                    link_names = eventData.getLink_names();
                                                    if (link_names != null) {
                                                        $this$mapIndexed$iv = link_names;
                                                        destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$mapIndexed$iv, 10));
                                                        $this$mapIndexedTo$iv$iv = $this$mapIndexed$iv;
                                                        index$iv$iv = 0;
                                                        for (Object item$iv$iv : $this$mapIndexedTo$iv$iv) {
                                                            int index$iv$iv3 = index$iv$iv + 1;
                                                            if (index$iv$iv < 0) {
                                                                CollectionsKt.throwIndexOverflow();
                                                            }
                                                            String name = (String) item$iv$iv;
                                                            SKTechEventData eventData2 = eventData;
                                                            destination$iv$iv.add(new LiveEventFormat(name, eventData2.getLinks()));
                                                            index$iv$iv = index$iv$iv3;
                                                            eventData = eventData2;
                                                            $this$mapIndexed$iv = $this$mapIndexed$iv;
                                                            $this$mapIndexedTo$iv$iv = $this$mapIndexedTo$iv$iv;
                                                        }
                                                        listEmptyList = (List) destination$iv$iv;
                                                    } else {
                                                        links2 = eventData.getLinks();
                                                        if (links2 != null || (iterableSplit$default = StringsKt.split$default(links2, new String[]{", "}, false, 0, 6, (Object) null)) == null) {
                                                            listEmptyList = CollectionsKt.emptyList();
                                                        } else {
                                                            Iterable $this$mapIndexed$iv2 = iterableSplit$default;
                                                            int $i$f$mapIndexed = 0;
                                                            Collection destination$iv$iv3 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$mapIndexed$iv2, 10));
                                                            Iterable $this$mapIndexedTo$iv$iv2 = $this$mapIndexed$iv2;
                                                            int index$iv$iv4 = 0;
                                                            for (Object item$iv$iv2 : $this$mapIndexedTo$iv$iv2) {
                                                                int index$iv$iv5 = index$iv$iv4 + 1;
                                                                if (index$iv$iv4 < 0) {
                                                                    CollectionsKt.throwIndexOverflow();
                                                                }
                                                                String link = (String) item$iv$iv2;
                                                                destination$iv$iv3.add(new LiveEventFormat("Link " + (index$iv$iv4 + 1), link));
                                                                index$iv$iv4 = index$iv$iv5;
                                                                $this$mapIndexed$iv2 = $this$mapIndexed$iv2;
                                                                $i$f$mapIndexed = $i$f$mapIndexed;
                                                                $this$mapIndexedTo$iv$iv2 = $this$mapIndexedTo$iv$iv2;
                                                            }
                                                            listEmptyList = (List) destination$iv$iv3;
                                                        }
                                                    }
                                                    liveEventData = new LiveEventData(i2, str6, eventLogo, str7, category, liveEventInfo, i, listEmptyList);
                                                } catch (Exception e5) {
                                                    e = e5;
                                                    System.out.println((Object) ("SKTech: Failed to parse event at index " + index$iv$iv2 + ": " + e.getMessage()));
                                                    e.printStackTrace();
                                                    liveEventData = null;
                                                }
                                                if (liveEventData != null) {
                                                    destination$iv$iv2.add(liveEventData);
                                                }
                                                baseUrl3 = baseUrl2;
                                                index$iv$iv$iv = index$iv$iv$iv2;
                                                str3 = str;
                                                wrappers2 = wrappers;
                                                eventsUrl2 = eventsUrl;
                                            } else {
                                                baseUrl2 = baseUrl3;
                                            }
                                            strSubstringBeforeLast$default = "";
                                            String str8 = strSubstringBeforeLast$default;
                                            String category3 = eventData.getCategory();
                                            String teamAName2 = eventData.getTeamAName();
                                            String teamBName2 = eventData.getTeamBName();
                                            String teamAFlag2 = eventData.getTeamAFlag();
                                            String teamBFlag2 = eventData.getTeamBFlag();
                                            String category4 = eventData.getCategory();
                                            String eventName3 = eventData.getEventName();
                                            String eventLogo3 = eventData.getEventLogo();
                                            if (eventData.getPriority() != null) {
                                                str2 = "0";
                                            } else {
                                                str2 = "0";
                                            }
                                            LiveEventInfo liveEventInfo2 = new LiveEventInfo(teamAName2, teamBName2, teamAFlag2, teamBFlag2, category4, eventName3, eventLogo3, str2, null, ProviderManager.INSTANCE.parseDateTime(eventData.getDate(), eventData.getTime()), ProviderManager.INSTANCE.parseDateTime(eventData.getEnd_date(), eventData.getEnd_time()));
                                            if (Intrinsics.areEqual(eventData.getVisible(), Boxing.boxBoolean(z))) {
                                                i = 1;
                                            } else {
                                                i = 0;
                                            }
                                            link_names = eventData.getLink_names();
                                            if (link_names != null) {
                                                $this$mapIndexed$iv = link_names;
                                                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$mapIndexed$iv, 10));
                                                $this$mapIndexedTo$iv$iv = $this$mapIndexed$iv;
                                                index$iv$iv = 0;
                                                while (r30.hasNext()) {
                                                    int index$iv$iv6 = index$iv$iv + 1;
                                                    if (index$iv$iv < 0) {
                                                        CollectionsKt.throwIndexOverflow();
                                                    }
                                                    String name2 = (String) item$iv$iv;
                                                    SKTechEventData eventData3 = eventData;
                                                    destination$iv$iv.add(new LiveEventFormat(name2, eventData3.getLinks()));
                                                    index$iv$iv = index$iv$iv6;
                                                    eventData = eventData3;
                                                    $this$mapIndexed$iv = $this$mapIndexed$iv;
                                                    $this$mapIndexedTo$iv$iv = $this$mapIndexedTo$iv$iv;
                                                }
                                                listEmptyList = (List) destination$iv$iv;
                                            } else {
                                                links2 = eventData.getLinks();
                                                if (links2 != null) {
                                                    listEmptyList = CollectionsKt.emptyList();
                                                } else {
                                                    listEmptyList = CollectionsKt.emptyList();
                                                }
                                            }
                                            liveEventData = new LiveEventData(i2, str6, eventLogo, str8, category3, liveEventInfo2, i, listEmptyList);
                                            if (liveEventData != null) {
                                                destination$iv$iv2.add(liveEventData);
                                            }
                                            baseUrl3 = baseUrl2;
                                            index$iv$iv$iv = index$iv$iv$iv2;
                                            str3 = str;
                                            wrappers2 = wrappers;
                                            eventsUrl2 = eventsUrl;
                                        } else {
                                            value$iv = value$iv2;
                                        }
                                        ObjectMapper $this$readValue$iv$iv6 = MainAPIKt.getMapper();
                                        String content$iv$iv3 = value$iv;
                                        objDecodeFromString2 = $this$readValue$iv$iv6.readValue(content$iv$iv3, new TypeReference<SKTechEventData>() { // from class: com.cncverse.ProviderManager$fetchLiveEvents$2$invokeSuspend$lambda$0$$inlined$parseJson$1
                                        });
                                        eventData = (SKTechEventData) objDecodeFromString2;
                                        int i3 = index$iv$iv2 + 1;
                                        eventName = eventData.getEventName();
                                        if (eventName == null) {
                                            eventName = "Unknown Event";
                                        }
                                        String str9 = eventName;
                                        String eventLogo4 = eventData.getEventLogo();
                                        links = eventData.getLinks();
                                        if (links != null) {
                                            baseUrl2 = baseUrl3;
                                            strSubstringBeforeLast$default = StringsKt.substringBeforeLast$default(links, ".", (String) null, 2, (Object) null);
                                            if (strSubstringBeforeLast$default == null) {
                                            }
                                            String str10 = strSubstringBeforeLast$default;
                                            String category5 = eventData.getCategory();
                                            String teamAName3 = eventData.getTeamAName();
                                            String teamBName3 = eventData.getTeamBName();
                                            String teamAFlag3 = eventData.getTeamAFlag();
                                            String teamBFlag3 = eventData.getTeamBFlag();
                                            String category6 = eventData.getCategory();
                                            String eventName4 = eventData.getEventName();
                                            String eventLogo5 = eventData.getEventLogo();
                                            if (eventData.getPriority() != null) {
                                                str2 = "0";
                                            } else {
                                                str2 = "0";
                                            }
                                            LiveEventInfo liveEventInfo3 = new LiveEventInfo(teamAName3, teamBName3, teamAFlag3, teamBFlag3, category6, eventName4, eventLogo5, str2, null, ProviderManager.INSTANCE.parseDateTime(eventData.getDate(), eventData.getTime()), ProviderManager.INSTANCE.parseDateTime(eventData.getEnd_date(), eventData.getEnd_time()));
                                            if (Intrinsics.areEqual(eventData.getVisible(), Boxing.boxBoolean(z))) {
                                                i = 1;
                                            } else {
                                                i = 0;
                                            }
                                            link_names = eventData.getLink_names();
                                            if (link_names != null) {
                                                $this$mapIndexed$iv = link_names;
                                                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$mapIndexed$iv, 10));
                                                $this$mapIndexedTo$iv$iv = $this$mapIndexed$iv;
                                                index$iv$iv = 0;
                                                while (r30.hasNext()) {
                                                    int index$iv$iv7 = index$iv$iv + 1;
                                                    if (index$iv$iv < 0) {
                                                        CollectionsKt.throwIndexOverflow();
                                                    }
                                                    String name3 = (String) item$iv$iv;
                                                    SKTechEventData eventData4 = eventData;
                                                    destination$iv$iv.add(new LiveEventFormat(name3, eventData4.getLinks()));
                                                    index$iv$iv = index$iv$iv7;
                                                    eventData = eventData4;
                                                    $this$mapIndexed$iv = $this$mapIndexed$iv;
                                                    $this$mapIndexedTo$iv$iv = $this$mapIndexedTo$iv$iv;
                                                }
                                                listEmptyList = (List) destination$iv$iv;
                                            } else {
                                                links2 = eventData.getLinks();
                                                if (links2 != null) {
                                                    listEmptyList = CollectionsKt.emptyList();
                                                } else {
                                                    listEmptyList = CollectionsKt.emptyList();
                                                }
                                            }
                                            liveEventData = new LiveEventData(i3, str9, eventLogo4, str10, category5, liveEventInfo3, i, listEmptyList);
                                            if (liveEventData != null) {
                                                destination$iv$iv2.add(liveEventData);
                                            }
                                            baseUrl3 = baseUrl2;
                                            index$iv$iv$iv = index$iv$iv$iv2;
                                            str3 = str;
                                            wrappers2 = wrappers;
                                            eventsUrl2 = eventsUrl;
                                        } else {
                                            baseUrl2 = baseUrl3;
                                        }
                                        strSubstringBeforeLast$default = "";
                                        String str11 = strSubstringBeforeLast$default;
                                        String category7 = eventData.getCategory();
                                        String teamAName4 = eventData.getTeamAName();
                                        String teamBName4 = eventData.getTeamBName();
                                        String teamAFlag4 = eventData.getTeamAFlag();
                                        String teamBFlag4 = eventData.getTeamBFlag();
                                        String category8 = eventData.getCategory();
                                        String eventName5 = eventData.getEventName();
                                        String eventLogo6 = eventData.getEventLogo();
                                        if (eventData.getPriority() != null) {
                                            str2 = "0";
                                        } else {
                                            str2 = "0";
                                        }
                                        LiveEventInfo liveEventInfo4 = new LiveEventInfo(teamAName4, teamBName4, teamAFlag4, teamBFlag4, category8, eventName5, eventLogo6, str2, null, ProviderManager.INSTANCE.parseDateTime(eventData.getDate(), eventData.getTime()), ProviderManager.INSTANCE.parseDateTime(eventData.getEnd_date(), eventData.getEnd_time()));
                                        if (Intrinsics.areEqual(eventData.getVisible(), Boxing.boxBoolean(z))) {
                                            i = 1;
                                        } else {
                                            i = 0;
                                        }
                                        link_names = eventData.getLink_names();
                                        if (link_names != null) {
                                            $this$mapIndexed$iv = link_names;
                                            destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$mapIndexed$iv, 10));
                                            $this$mapIndexedTo$iv$iv = $this$mapIndexed$iv;
                                            index$iv$iv = 0;
                                            while (r30.hasNext()) {
                                                int index$iv$iv8 = index$iv$iv + 1;
                                                if (index$iv$iv < 0) {
                                                    CollectionsKt.throwIndexOverflow();
                                                }
                                                String name4 = (String) item$iv$iv;
                                                SKTechEventData eventData5 = eventData;
                                                destination$iv$iv.add(new LiveEventFormat(name4, eventData5.getLinks()));
                                                index$iv$iv = index$iv$iv8;
                                                eventData = eventData5;
                                                $this$mapIndexed$iv = $this$mapIndexed$iv;
                                                $this$mapIndexedTo$iv$iv = $this$mapIndexedTo$iv$iv;
                                            }
                                            listEmptyList = (List) destination$iv$iv;
                                        } else {
                                            links2 = eventData.getLinks();
                                            if (links2 != null) {
                                                listEmptyList = CollectionsKt.emptyList();
                                            } else {
                                                listEmptyList = CollectionsKt.emptyList();
                                            }
                                        }
                                        liveEventData = new LiveEventData(i3, str9, eventLogo4, str11, category7, liveEventInfo4, i, listEmptyList);
                                    } catch (Exception e6) {
                                        e = e6;
                                        baseUrl2 = baseUrl3;
                                    }
                                } catch (Exception e7) {
                                    e = e7;
                                    wrappers = wrappers2;
                                    str = str3;
                                    eventsUrl = eventsUrl2;
                                    baseUrl2 = baseUrl3;
                                    System.out.println((Object) ("SKTech: Failed to parse event at index " + index$iv$iv2 + ": " + e.getMessage()));
                                    e.printStackTrace();
                                    liveEventData = null;
                                    if (liveEventData != null) {
                                        destination$iv$iv2.add(liveEventData);
                                    }
                                    baseUrl3 = baseUrl2;
                                    index$iv$iv$iv = index$iv$iv$iv2;
                                    str3 = str;
                                    wrappers2 = wrappers;
                                    eventsUrl2 = eventsUrl;
                                }
                                if (liveEventData != null) {
                                    destination$iv$iv2.add(liveEventData);
                                }
                                baseUrl3 = baseUrl2;
                                index$iv$iv$iv = index$iv$iv$iv2;
                                str3 = str;
                                wrappers2 = wrappers;
                                eventsUrl2 = eventsUrl;
                            }
                            Iterable events = (List) destination$iv$iv2;
                            Iterable $this$filter$iv = events;
                            Collection destination$iv$iv4 = new ArrayList();
                            for (Object element$iv$iv : $this$filter$iv) {
                                LiveEventData it = (LiveEventData) element$iv$iv;
                                if (it.getPublish() == 1) {
                                    destination$iv$iv4.add(element$iv$iv);
                                }
                            }
                            return (List) destination$iv$iv4;
                        }
                        System.out.println((Object) "SKTech: Failed to decrypt events data");
                    }
                } else {
                    System.out.println((Object) ("SKTech: HTTP error " + response.code() + " fetching events"));
                }
            } catch (Exception e8) {
                System.out.println((Object) ("SKTech: Exception fetching live events: " + e8.getMessage()));
                e8.printStackTrace();
            }
            return CollectionsKt.emptyList();
        }
    }

    @Nullable
    public final Object fetchLiveEvents(@NotNull Continuation<? super List<LiveEventData>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new C00282(null), continuation);
    }

    /* JADX INFO: renamed from: com.cncverse.ProviderManager$fetchCustomEvents$2 */
    /* JADX INFO: compiled from: ProviderManager.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lcom/cncverse/LiveEventData;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.ProviderManager$fetchCustomEvents$2", f = "ProviderManager.kt", i = {}, l = {320}, m = "invokeSuspend", n = {}, nl = {321}, s = {}, v = 2)
    @SourceDebugExtension({"SMAP\nProviderManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ProviderManager.kt\ncom/cncverse/ProviderManager$fetchCustomEvents$2\n+ 2 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n+ 5 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,390:1\n63#2:391\n64#2,15:393\n63#2:414\n64#2,15:416\n1#3:392\n1#3:415\n1#3:443\n50#4:408\n43#4:409\n50#4:431\n43#4:432\n1606#5:410\n1617#5:411\n1924#5,2:412\n1596#5:433\n1629#5,4:434\n1596#5:438\n1629#5,4:439\n1926#5:444\n1618#5:445\n777#5:446\n873#5,2:447\n*S KotlinDebug\n*F\n+ 1 ProviderManager.kt\ncom/cncverse/ProviderManager$fetchCustomEvents$2\n*L\n337#1:391\n337#1:393,15\n340#1:414\n340#1:416,15\n337#1:392\n340#1:415\n338#1:443\n337#1:408\n337#1:409\n340#1:431\n340#1:432\n338#1:410\n338#1:411\n338#1:412,2\n361#1:433\n361#1:434,4\n366#1:438\n366#1:439,4\n338#1:444\n338#1:445\n378#1:446\n378#1:447,2\n*E\n"})
    static final class C00252 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends LiveEventData>>, Object> {
        final /* synthetic */ String $catLink;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00252(String str, Continuation<? super C00252> continuation) {
            super(2, continuation);
            this.$catLink = str;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C00252(this.$catLink, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<LiveEventData>> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:124:0x028d  */
        /* JADX WARN: Code duplicated, block: B:128:0x029b  */
        /* JADX WARN: Code duplicated, block: B:132:0x02a7  */
        /* JADX WARN: Code duplicated, block: B:135:0x02af  */
        /* JADX WARN: Code duplicated, block: B:139:0x02ee  */
        /* JADX WARN: Code duplicated, block: B:140:0x02f1  */
        /* JADX WARN: Code duplicated, block: B:143:0x02fb A[Catch: Exception -> 0x03ee, TryCatch #3 {Exception -> 0x03ee, blocks: (B:130:0x02a1, B:137:0x02b5, B:141:0x02f3, B:143:0x02fb, B:144:0x0313, B:146:0x0319, B:148:0x0321, B:149:0x0324, B:150:0x0348, B:164:0x03e6, B:151:0x0354, B:153:0x035c, B:155:0x0374, B:156:0x038a, B:158:0x0390, B:160:0x0398, B:161:0x039b, B:162:0x03d3, B:163:0x03df), top: B:202:0x02a1 }] */
        /* JADX WARN: Code duplicated, block: B:146:0x0319 A[Catch: Exception -> 0x03ee, TryCatch #3 {Exception -> 0x03ee, blocks: (B:130:0x02a1, B:137:0x02b5, B:141:0x02f3, B:143:0x02fb, B:144:0x0313, B:146:0x0319, B:148:0x0321, B:149:0x0324, B:150:0x0348, B:164:0x03e6, B:151:0x0354, B:153:0x035c, B:155:0x0374, B:156:0x038a, B:158:0x0390, B:160:0x0398, B:161:0x039b, B:162:0x03d3, B:163:0x03df), top: B:202:0x02a1 }] */
        /* JADX WARN: Code duplicated, block: B:148:0x0321 A[Catch: Exception -> 0x03ee, TryCatch #3 {Exception -> 0x03ee, blocks: (B:130:0x02a1, B:137:0x02b5, B:141:0x02f3, B:143:0x02fb, B:144:0x0313, B:146:0x0319, B:148:0x0321, B:149:0x0324, B:150:0x0348, B:164:0x03e6, B:151:0x0354, B:153:0x035c, B:155:0x0374, B:156:0x038a, B:158:0x0390, B:160:0x0398, B:161:0x039b, B:162:0x03d3, B:163:0x03df), top: B:202:0x02a1 }] */
        /* JADX WARN: Code duplicated, block: B:151:0x0354 A[Catch: Exception -> 0x03ee, TryCatch #3 {Exception -> 0x03ee, blocks: (B:130:0x02a1, B:137:0x02b5, B:141:0x02f3, B:143:0x02fb, B:144:0x0313, B:146:0x0319, B:148:0x0321, B:149:0x0324, B:150:0x0348, B:164:0x03e6, B:151:0x0354, B:153:0x035c, B:155:0x0374, B:156:0x038a, B:158:0x0390, B:160:0x0398, B:161:0x039b, B:162:0x03d3, B:163:0x03df), top: B:202:0x02a1 }] */
        /* JADX WARN: Code duplicated, block: B:153:0x035c A[Catch: Exception -> 0x03ee, TryCatch #3 {Exception -> 0x03ee, blocks: (B:130:0x02a1, B:137:0x02b5, B:141:0x02f3, B:143:0x02fb, B:144:0x0313, B:146:0x0319, B:148:0x0321, B:149:0x0324, B:150:0x0348, B:164:0x03e6, B:151:0x0354, B:153:0x035c, B:155:0x0374, B:156:0x038a, B:158:0x0390, B:160:0x0398, B:161:0x039b, B:162:0x03d3, B:163:0x03df), top: B:202:0x02a1 }] */
        /* JADX WARN: Code duplicated, block: B:163:0x03df A[Catch: Exception -> 0x03ee, TryCatch #3 {Exception -> 0x03ee, blocks: (B:130:0x02a1, B:137:0x02b5, B:141:0x02f3, B:143:0x02fb, B:144:0x0313, B:146:0x0319, B:148:0x0321, B:149:0x0324, B:150:0x0348, B:164:0x03e6, B:151:0x0354, B:153:0x035c, B:155:0x0374, B:156:0x038a, B:158:0x0390, B:160:0x0398, B:161:0x039b, B:162:0x03d3, B:163:0x03df), top: B:202:0x02a1 }] */
        /* JADX WARN: Code duplicated, block: B:176:0x042a A[Catch: Exception -> 0x001c, TryCatch #11 {Exception -> 0x001c, blocks: (B:6:0x0016, B:14:0x0031, B:16:0x007f, B:18:0x008d, B:24:0x0099, B:26:0x00c8, B:32:0x00d4, B:43:0x010e, B:55:0x0144, B:58:0x014b, B:68:0x017b, B:69:0x0194, B:71:0x019a, B:73:0x01a2, B:74:0x01a5, B:176:0x042a, B:173:0x03fd, B:178:0x043c, B:179:0x045b, B:181:0x0461, B:186:0x0479, B:188:0x0481, B:67:0x0166, B:66:0x0160, B:54:0x013a, B:42:0x0104, B:11:0x0023, B:61:0x0151), top: B:208:0x000b, inners: #19 }] */
        /* JADX WARN: Code duplicated, block: B:230:0x0430 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:233:0x0324 A[SYNTHETIC] */
        /* JADX WARN: Unreachable blocks removed: 2, instructions: 5 */
        public final Object invokeSuspend(Object $result) {
            Object baseUrl;
            boolean z;
            Object obj;
            Object obj2;
            Object objDecodeFromString;
            List wrappers;
            Iterable $this$mapIndexedNotNull$iv;
            String baseUrl2;
            int $i$f$mapIndexedNotNull;
            LiveEventData liveEventData;
            Object obj3;
            Object obj4;
            Object obj5;
            String value$iv;
            Object objDecodeFromString2;
            SKTechChannelData channelData;
            String name;
            String links;
            String strSubstringBeforeLast$default;
            int i;
            Iterable link_names;
            String links2;
            List listEmptyList;
            Iterable iterableSplit$default;
            Iterable $this$mapIndexed$iv;
            Collection destination$iv$iv;
            int index$iv$iv;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            try {
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        this.label = 1;
                        baseUrl = ProviderManager.INSTANCE.getBaseUrl((Continuation) this);
                        if (baseUrl == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        ResultKt.throwOnFailure($result);
                        baseUrl = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                String baseUrl3 = (String) baseUrl;
                String safeLink = StringsKt.removePrefix(this.$catLink, "/");
                String eventsUrl = baseUrl3 + '/' + safeLink;
                Request request = new Request.Builder().url(eventsUrl).header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36").build();
                Response response = ProviderManager.client.newCall(request).execute();
                if (response.isSuccessful()) {
                    String encryptedData = response.body().string();
                    String str = encryptedData;
                    if (!(str == null || StringsKt.isBlank(str))) {
                        System.out.println((Object) ("SKTech: Fetched custom events data from " + safeLink));
                        String decryptedData = SKLiveCryptoUtils.INSTANCE.decryptSKLive(StringsKt.trim(encryptedData).toString());
                        String str2 = decryptedData;
                        if (!(str2 == null || StringsKt.isBlank(str2))) {
                            AppUtils appUtils = AppUtils.INSTANCE;
                            try {
                                Result.Companion companion = Result.Companion;
                                z = false;
                                try {
                                    KType kTypeTypeOf = Reflection.typeOf(List.class, KTypeProjection.Companion.invariant(Reflection.typeOf(SKTechChannelWrapper.class)));
                                    MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                                    obj = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                                } catch (Throwable th) {
                                    th = th;
                                    Result.Companion companion2 = Result.Companion;
                                    obj = Result.constructor-impl(ResultKt.createFailure(th));
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                z = false;
                            }
                            if (Result.exceptionOrNull-impl(obj) == null) {
                                obj2 = "kotlinx.serialization.serializer.simple";
                            } else {
                                try {
                                    Result.Companion companion3 = Result.Companion;
                                    obj2 = "kotlinx.serialization.serializer.simple";
                                    try {
                                        obj = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(List.class), (List) null, 2, (Object) null));
                                    } catch (Throwable th3) {
                                        th = th3;
                                        Result.Companion companion4 = Result.Companion;
                                        obj = Result.constructor-impl(ResultKt.createFailure(th));
                                    }
                                } catch (Throwable th4) {
                                    th = th4;
                                    obj2 = "kotlinx.serialization.serializer.simple";
                                }
                            }
                            if (Result.isFailure-impl(obj)) {
                                obj = null;
                            }
                            DeserializationStrategy deserializationStrategy = (KSerializer) obj;
                            if (deserializationStrategy != null) {
                                try {
                                    objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, decryptedData);
                                } catch (SerializationException e) {
                                    ArchComponentExtKt.logError(e);
                                    ObjectMapper $this$readValue$iv$iv = MainAPIKt.getMapper();
                                    objDecodeFromString = $this$readValue$iv$iv.readValue(decryptedData, new TypeReference<List<? extends SKTechChannelWrapper>>() { // from class: com.cncverse.ProviderManager$fetchCustomEvents$2$invokeSuspend$$inlined$parseJson$1
                                    });
                                } catch (Throwable th5) {
                                    ObjectMapper $this$readValue$iv$iv2 = MainAPIKt.getMapper();
                                    objDecodeFromString = $this$readValue$iv$iv2.readValue(decryptedData, new TypeReference<List<? extends SKTechChannelWrapper>>() { // from class: com.cncverse.ProviderManager$fetchCustomEvents$2$invokeSuspend$$inlined$parseJson$1
                                    });
                                }
                            } else {
                                ObjectMapper $this$readValue$iv$iv3 = MainAPIKt.getMapper();
                                objDecodeFromString = $this$readValue$iv$iv3.readValue(decryptedData, new TypeReference<List<? extends SKTechChannelWrapper>>() { // from class: com.cncverse.ProviderManager$fetchCustomEvents$2$invokeSuspend$$inlined$parseJson$1
                                });
                            }
                            List wrappers2 = (List) objDecodeFromString;
                            Iterable $this$mapIndexedNotNull$iv2 = wrappers2;
                            int $i$f$mapIndexedNotNull2 = 0;
                            Collection destination$iv$iv2 = new ArrayList();
                            int index$iv$iv$iv = 0;
                            for (Object item$iv$iv$iv : $this$mapIndexedNotNull$iv2) {
                                int index$iv$iv$iv2 = index$iv$iv$iv + 1;
                                if (index$iv$iv$iv < 0) {
                                    CollectionsKt.throwIndexOverflow();
                                }
                                int index$iv$iv2 = index$iv$iv$iv;
                                SKTechChannelWrapper wrapper = (SKTechChannelWrapper) item$iv$iv$iv;
                                try {
                                    AppUtils appUtils2 = AppUtils.INSTANCE;
                                    String value$iv2 = wrapper.getChannel();
                                    try {
                                        Result.Companion companion5 = Result.Companion;
                                        KType kTypeTypeOf2 = Reflection.typeOf(SKTechChannelData.class);
                                        MagicApiIntrinsics.voidMagicApiCall(obj2);
                                        obj3 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf2));
                                    } catch (Throwable th6) {
                                        Result.Companion companion6 = Result.Companion;
                                        obj3 = Result.constructor-impl(ResultKt.createFailure(th6));
                                    }
                                    if (Result.exceptionOrNull-impl(obj3) == null) {
                                        wrappers = wrappers2;
                                        $this$mapIndexedNotNull$iv = $this$mapIndexedNotNull$iv2;
                                        baseUrl2 = baseUrl3;
                                        obj5 = obj3;
                                    } else {
                                        try {
                                            Result.Companion companion7 = Result.Companion;
                                            wrappers = wrappers2;
                                            try {
                                                $this$mapIndexedNotNull$iv = $this$mapIndexedNotNull$iv2;
                                                baseUrl2 = baseUrl3;
                                                try {
                                                    obj4 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(SKTechChannelData.class), (List) null, 2, (Object) null));
                                                } catch (Throwable th7) {
                                                    th = th7;
                                                    Result.Companion companion8 = Result.Companion;
                                                    obj4 = Result.constructor-impl(ResultKt.createFailure(th));
                                                }
                                            } catch (Throwable th8) {
                                                th = th8;
                                                $this$mapIndexedNotNull$iv = $this$mapIndexedNotNull$iv2;
                                                baseUrl2 = baseUrl3;
                                            }
                                        } catch (Throwable th9) {
                                            th = th9;
                                            wrappers = wrappers2;
                                            $this$mapIndexedNotNull$iv = $this$mapIndexedNotNull$iv2;
                                            baseUrl2 = baseUrl3;
                                        }
                                        obj5 = obj4;
                                    }
                                    try {
                                        if (Result.isFailure-impl(obj5)) {
                                            obj5 = null;
                                        }
                                        DeserializationStrategy deserializationStrategy2 = (KSerializer) obj5;
                                        if (deserializationStrategy2 != null) {
                                            try {
                                                value$iv = value$iv2;
                                                try {
                                                    objDecodeFromString2 = MainAPIKt.getJson().decodeFromString(deserializationStrategy2, value$iv);
                                                } catch (SerializationException e2) {
                                                    e$iv = e2;
                                                    try {
                                                        ArchComponentExtKt.logError((Throwable) e$iv);
                                                        ObjectMapper $this$readValue$iv$iv4 = MainAPIKt.getMapper();
                                                        String content$iv$iv = value$iv;
                                                        objDecodeFromString2 = $this$readValue$iv$iv4.readValue(content$iv$iv, new TypeReference<SKTechChannelData>() { // from class: com.cncverse.ProviderManager$fetchCustomEvents$2$invokeSuspend$lambda$0$$inlined$parseJson$1
                                                        });
                                                    } catch (Exception e3) {
                                                        e = e3;
                                                        $i$f$mapIndexedNotNull = $i$f$mapIndexedNotNull2;
                                                        System.out.println((Object) ("SKTech: Failed to parse custom event at index " + index$iv$iv2 + ": " + e.getMessage()));
                                                        liveEventData = null;
                                                        if (liveEventData != null) {
                                                            destination$iv$iv2.add(liveEventData);
                                                        }
                                                        $i$f$mapIndexedNotNull2 = $i$f$mapIndexedNotNull;
                                                        index$iv$iv$iv = index$iv$iv$iv2;
                                                        $this$mapIndexedNotNull$iv2 = $this$mapIndexedNotNull$iv;
                                                        wrappers2 = wrappers;
                                                        baseUrl3 = baseUrl2;
                                                    }
                                                } catch (Throwable th10) {
                                                    ObjectMapper $this$readValue$iv$iv5 = MainAPIKt.getMapper();
                                                    String content$iv$iv2 = value$iv;
                                                    objDecodeFromString2 = $this$readValue$iv$iv5.readValue(content$iv$iv2, new TypeReference<SKTechChannelData>() { // from class: com.cncverse.ProviderManager$fetchCustomEvents$2$invokeSuspend$lambda$0$$inlined$parseJson$1
                                                    });
                                                }
                                            } catch (SerializationException e4) {
                                                e$iv = e4;
                                                value$iv = value$iv2;
                                            } catch (Throwable th11) {
                                                value$iv = value$iv2;
                                            }
                                            channelData = (SKTechChannelData) objDecodeFromString2;
                                            int i2 = index$iv$iv2 + 1;
                                            name = channelData.getName();
                                            if (name == null) {
                                                name = "Unknown Channel";
                                            }
                                            String str3 = name;
                                            String logo = channelData.getLogo();
                                            links = channelData.getLinks();
                                            if (links != null) {
                                                $i$f$mapIndexedNotNull = $i$f$mapIndexedNotNull2;
                                                try {
                                                    strSubstringBeforeLast$default = StringsKt.substringBeforeLast$default(links, ".", (String) null, 2, (Object) null);
                                                    if (strSubstringBeforeLast$default == null) {
                                                    }
                                                    String str4 = strSubstringBeforeLast$default;
                                                    LiveEventInfo liveEventInfo = new LiveEventInfo(null, null, null, null, null, channelData.getName(), channelData.getLogo(), "0", null, null, null);
                                                    if (Intrinsics.areEqual(channelData.getVisible(), Boxing.boxBoolean(z))) {
                                                        i = 0;
                                                    } else {
                                                        i = 1;
                                                    }
                                                    link_names = channelData.getLink_names();
                                                    if (link_names != null) {
                                                        $this$mapIndexed$iv = link_names;
                                                        destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$mapIndexed$iv, 10));
                                                        index$iv$iv = 0;
                                                        for (Object item$iv$iv : $this$mapIndexed$iv) {
                                                            int index$iv$iv3 = index$iv$iv + 1;
                                                            if (index$iv$iv < 0) {
                                                                CollectionsKt.throwIndexOverflow();
                                                            }
                                                            String name2 = (String) item$iv$iv;
                                                            SKTechChannelData channelData2 = channelData;
                                                            destination$iv$iv.add(new LiveEventFormat(name2, channelData2.getLinks()));
                                                            index$iv$iv = index$iv$iv3;
                                                            channelData = channelData2;
                                                            $this$mapIndexed$iv = $this$mapIndexed$iv;
                                                        }
                                                        listEmptyList = (List) destination$iv$iv;
                                                    } else {
                                                        links2 = channelData.getLinks();
                                                        if (links2 != null || (iterableSplit$default = StringsKt.split$default(links2, new String[]{", "}, false, 0, 6, (Object) null)) == null) {
                                                            listEmptyList = CollectionsKt.emptyList();
                                                        } else {
                                                            Iterable $this$mapIndexed$iv2 = iterableSplit$default;
                                                            int $i$f$mapIndexed = 0;
                                                            Collection destination$iv$iv3 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$mapIndexed$iv2, 10));
                                                            Iterable $this$mapIndexedTo$iv$iv = $this$mapIndexed$iv2;
                                                            int index$iv$iv4 = 0;
                                                            for (Object item$iv$iv2 : $this$mapIndexedTo$iv$iv) {
                                                                int index$iv$iv5 = index$iv$iv4 + 1;
                                                                if (index$iv$iv4 < 0) {
                                                                    CollectionsKt.throwIndexOverflow();
                                                                }
                                                                String link = (String) item$iv$iv2;
                                                                destination$iv$iv3.add(new LiveEventFormat("Link " + (index$iv$iv4 + 1), link));
                                                                index$iv$iv4 = index$iv$iv5;
                                                                $this$mapIndexed$iv2 = $this$mapIndexed$iv2;
                                                                $i$f$mapIndexed = $i$f$mapIndexed;
                                                                $this$mapIndexedTo$iv$iv = $this$mapIndexedTo$iv$iv;
                                                            }
                                                            listEmptyList = (List) destination$iv$iv3;
                                                        }
                                                    }
                                                    liveEventData = new LiveEventData(i2, str3, logo, str4, "Custom", liveEventInfo, i, listEmptyList);
                                                } catch (Exception e5) {
                                                    e = e5;
                                                    System.out.println((Object) ("SKTech: Failed to parse custom event at index " + index$iv$iv2 + ": " + e.getMessage()));
                                                    liveEventData = null;
                                                }
                                                if (liveEventData != null) {
                                                    destination$iv$iv2.add(liveEventData);
                                                }
                                                $i$f$mapIndexedNotNull2 = $i$f$mapIndexedNotNull;
                                                index$iv$iv$iv = index$iv$iv$iv2;
                                                $this$mapIndexedNotNull$iv2 = $this$mapIndexedNotNull$iv;
                                                wrappers2 = wrappers;
                                                baseUrl3 = baseUrl2;
                                            } else {
                                                $i$f$mapIndexedNotNull = $i$f$mapIndexedNotNull2;
                                            }
                                            strSubstringBeforeLast$default = "";
                                            String str5 = strSubstringBeforeLast$default;
                                            LiveEventInfo liveEventInfo2 = new LiveEventInfo(null, null, null, null, null, channelData.getName(), channelData.getLogo(), "0", null, null, null);
                                            if (Intrinsics.areEqual(channelData.getVisible(), Boxing.boxBoolean(z))) {
                                                i = 1;
                                            } else {
                                                i = 0;
                                            }
                                            link_names = channelData.getLink_names();
                                            if (link_names != null) {
                                                $this$mapIndexed$iv = link_names;
                                                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$mapIndexed$iv, 10));
                                                index$iv$iv = 0;
                                                while (r32.hasNext()) {
                                                    int index$iv$iv6 = index$iv$iv + 1;
                                                    if (index$iv$iv < 0) {
                                                        CollectionsKt.throwIndexOverflow();
                                                    }
                                                    String name3 = (String) item$iv$iv;
                                                    SKTechChannelData channelData3 = channelData;
                                                    destination$iv$iv.add(new LiveEventFormat(name3, channelData3.getLinks()));
                                                    index$iv$iv = index$iv$iv6;
                                                    channelData = channelData3;
                                                    $this$mapIndexed$iv = $this$mapIndexed$iv;
                                                }
                                                listEmptyList = (List) destination$iv$iv;
                                            } else {
                                                links2 = channelData.getLinks();
                                                if (links2 != null) {
                                                    listEmptyList = CollectionsKt.emptyList();
                                                } else {
                                                    listEmptyList = CollectionsKt.emptyList();
                                                }
                                            }
                                            liveEventData = new LiveEventData(i2, str3, logo, str5, "Custom", liveEventInfo2, i, listEmptyList);
                                            if (liveEventData != null) {
                                                destination$iv$iv2.add(liveEventData);
                                            }
                                            $i$f$mapIndexedNotNull2 = $i$f$mapIndexedNotNull;
                                            index$iv$iv$iv = index$iv$iv$iv2;
                                            $this$mapIndexedNotNull$iv2 = $this$mapIndexedNotNull$iv;
                                            wrappers2 = wrappers;
                                            baseUrl3 = baseUrl2;
                                        } else {
                                            value$iv = value$iv2;
                                        }
                                        ObjectMapper $this$readValue$iv$iv6 = MainAPIKt.getMapper();
                                        String content$iv$iv3 = value$iv;
                                        objDecodeFromString2 = $this$readValue$iv$iv6.readValue(content$iv$iv3, new TypeReference<SKTechChannelData>() { // from class: com.cncverse.ProviderManager$fetchCustomEvents$2$invokeSuspend$lambda$0$$inlined$parseJson$1
                                        });
                                        channelData = (SKTechChannelData) objDecodeFromString2;
                                        int i3 = index$iv$iv2 + 1;
                                        name = channelData.getName();
                                        if (name == null) {
                                            name = "Unknown Channel";
                                        }
                                        String str6 = name;
                                        String logo2 = channelData.getLogo();
                                        links = channelData.getLinks();
                                        if (links != null) {
                                            $i$f$mapIndexedNotNull = $i$f$mapIndexedNotNull2;
                                            strSubstringBeforeLast$default = StringsKt.substringBeforeLast$default(links, ".", (String) null, 2, (Object) null);
                                            if (strSubstringBeforeLast$default == null) {
                                            }
                                            String str7 = strSubstringBeforeLast$default;
                                            LiveEventInfo liveEventInfo3 = new LiveEventInfo(null, null, null, null, null, channelData.getName(), channelData.getLogo(), "0", null, null, null);
                                            if (Intrinsics.areEqual(channelData.getVisible(), Boxing.boxBoolean(z))) {
                                                i = 1;
                                            } else {
                                                i = 0;
                                            }
                                            link_names = channelData.getLink_names();
                                            if (link_names != null) {
                                                $this$mapIndexed$iv = link_names;
                                                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$mapIndexed$iv, 10));
                                                index$iv$iv = 0;
                                                while (r32.hasNext()) {
                                                    int index$iv$iv7 = index$iv$iv + 1;
                                                    if (index$iv$iv < 0) {
                                                        CollectionsKt.throwIndexOverflow();
                                                    }
                                                    String name4 = (String) item$iv$iv;
                                                    SKTechChannelData channelData4 = channelData;
                                                    destination$iv$iv.add(new LiveEventFormat(name4, channelData4.getLinks()));
                                                    index$iv$iv = index$iv$iv7;
                                                    channelData = channelData4;
                                                    $this$mapIndexed$iv = $this$mapIndexed$iv;
                                                }
                                                listEmptyList = (List) destination$iv$iv;
                                            } else {
                                                links2 = channelData.getLinks();
                                                if (links2 != null) {
                                                    listEmptyList = CollectionsKt.emptyList();
                                                } else {
                                                    listEmptyList = CollectionsKt.emptyList();
                                                }
                                            }
                                            liveEventData = new LiveEventData(i3, str6, logo2, str7, "Custom", liveEventInfo3, i, listEmptyList);
                                            if (liveEventData != null) {
                                                destination$iv$iv2.add(liveEventData);
                                            }
                                            $i$f$mapIndexedNotNull2 = $i$f$mapIndexedNotNull;
                                            index$iv$iv$iv = index$iv$iv$iv2;
                                            $this$mapIndexedNotNull$iv2 = $this$mapIndexedNotNull$iv;
                                            wrappers2 = wrappers;
                                            baseUrl3 = baseUrl2;
                                        } else {
                                            $i$f$mapIndexedNotNull = $i$f$mapIndexedNotNull2;
                                        }
                                        strSubstringBeforeLast$default = "";
                                        String str8 = strSubstringBeforeLast$default;
                                        LiveEventInfo liveEventInfo4 = new LiveEventInfo(null, null, null, null, null, channelData.getName(), channelData.getLogo(), "0", null, null, null);
                                        if (Intrinsics.areEqual(channelData.getVisible(), Boxing.boxBoolean(z))) {
                                            i = 1;
                                        } else {
                                            i = 0;
                                        }
                                        link_names = channelData.getLink_names();
                                        if (link_names != null) {
                                            $this$mapIndexed$iv = link_names;
                                            destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$mapIndexed$iv, 10));
                                            index$iv$iv = 0;
                                            while (r32.hasNext()) {
                                                int index$iv$iv8 = index$iv$iv + 1;
                                                if (index$iv$iv < 0) {
                                                    CollectionsKt.throwIndexOverflow();
                                                }
                                                String name5 = (String) item$iv$iv;
                                                SKTechChannelData channelData5 = channelData;
                                                destination$iv$iv.add(new LiveEventFormat(name5, channelData5.getLinks()));
                                                index$iv$iv = index$iv$iv8;
                                                channelData = channelData5;
                                                $this$mapIndexed$iv = $this$mapIndexed$iv;
                                            }
                                            listEmptyList = (List) destination$iv$iv;
                                        } else {
                                            links2 = channelData.getLinks();
                                            if (links2 != null) {
                                                listEmptyList = CollectionsKt.emptyList();
                                            } else {
                                                listEmptyList = CollectionsKt.emptyList();
                                            }
                                        }
                                        liveEventData = new LiveEventData(i3, str6, logo2, str8, "Custom", liveEventInfo4, i, listEmptyList);
                                    } catch (Exception e6) {
                                        e = e6;
                                        $i$f$mapIndexedNotNull = $i$f$mapIndexedNotNull2;
                                    }
                                } catch (Exception e7) {
                                    e = e7;
                                    wrappers = wrappers2;
                                    $this$mapIndexedNotNull$iv = $this$mapIndexedNotNull$iv2;
                                    baseUrl2 = baseUrl3;
                                    $i$f$mapIndexedNotNull = $i$f$mapIndexedNotNull2;
                                }
                                if (liveEventData != null) {
                                    destination$iv$iv2.add(liveEventData);
                                }
                                $i$f$mapIndexedNotNull2 = $i$f$mapIndexedNotNull;
                                index$iv$iv$iv = index$iv$iv$iv2;
                                $this$mapIndexedNotNull$iv2 = $this$mapIndexedNotNull$iv;
                                wrappers2 = wrappers;
                                baseUrl3 = baseUrl2;
                            }
                            List events = (List) destination$iv$iv2;
                            List $this$filter$iv = events;
                            Collection destination$iv$iv4 = new ArrayList();
                            for (Object element$iv$iv : $this$filter$iv) {
                                LiveEventData it = (LiveEventData) element$iv$iv;
                                List events2 = events;
                                Iterable $this$filter$iv2 = $this$filter$iv;
                                if (it.getPublish() == 1) {
                                    destination$iv$iv4.add(element$iv$iv);
                                }
                                events = events2;
                                $this$filter$iv = $this$filter$iv2;
                            }
                            return (List) destination$iv$iv4;
                        }
                    }
                }
            } catch (Exception e8) {
                System.out.println((Object) ("SKTech: Exception fetching custom events: " + e8.getMessage()));
                e8.printStackTrace();
            }
            return CollectionsKt.emptyList();
        }
    }

    @Nullable
    public final Object fetchCustomEvents(@NotNull String catLink, @NotNull Continuation<? super List<LiveEventData>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new C00252(catLink, null), continuation);
    }
}
