package com.phisher98;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lagradost.api.Log;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.mvvm.ArchComponentExtKt;
import com.lagradost.cloudstream3.utils.AppUtils;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KType;
import kotlin.text.StringsKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.sync.Semaphore;
import kotlinx.coroutines.sync.SemaphoreKt;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.modules.SerializersModule;
import okhttp3.Interceptor;

/* JADX INFO: compiled from: StreamPlayUtils.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StreamPlay/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\b\u00028\u00000\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "com/phisher98/StreamPlayUtilsKt$safeAmap$2$1"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.phisher98.StreamPlayExtractor$invokeAnikoto$$inlined$safeAmap$default$1", f = "StreamPlayExtractor.kt", i = {0, 0}, l = {1898}, m = "invokeSuspend", n = {"$this$coroutineScope", "semaphore"}, nl = {-1}, s = {"L$0", "L$1"}, v = 2)
@SourceDebugExtension({"SMAP\nStreamPlayUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,2265:1\n1739#2:2266\n1814#2,3:2267\n*S KotlinDebug\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1\n*L\n1887#1:2266\n1887#1:2267,3\n*E\n"})
public final class StreamPlayExtractor$invokeAnikoto$$inlined$safeAmap$default$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Unit>>, Object> {
    final /* synthetic */ Map $ajaxHeaders$inlined;
    final /* synthetic */ String $anikotoAPI$inlined;
    final /* synthetic */ String $animeUrl$inlined;
    final /* synthetic */ Function1 $callback$inlined;
    final /* synthetic */ int $concurrency;
    final /* synthetic */ Function1 $subtitleCallback$inlined;
    final /* synthetic */ Iterable $this_runCatching;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StreamPlayExtractor$invokeAnikoto$$inlined$safeAmap$default$1(int i, Iterable iterable, Continuation continuation, String str, Map map, String str2, Function1 function1, Function1 function2) {
        super(2, continuation);
        this.$concurrency = i;
        this.$this_runCatching = iterable;
        this.$anikotoAPI$inlined = str;
        this.$ajaxHeaders$inlined = map;
        this.$animeUrl$inlined = str2;
        this.$subtitleCallback$inlined = function1;
        this.$callback$inlined = function2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> streamPlayExtractor$invokeAnikoto$$inlined$safeAmap$default$1 = new StreamPlayExtractor$invokeAnikoto$$inlined$safeAmap$default$1(this.$concurrency, this.$this_runCatching, continuation, this.$anikotoAPI$inlined, this.$ajaxHeaders$inlined, this.$animeUrl$inlined, this.$subtitleCallback$inlined, this.$callback$inlined);
        streamPlayExtractor$invokeAnikoto$$inlined$safeAmap$default$1.L$0 = obj;
        return streamPlayExtractor$invokeAnikoto$$inlined$safeAmap$default$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends Unit>> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: renamed from: com.phisher98.StreamPlayExtractor$invokeAnikoto$$inlined$safeAmap$default$1$1 */
    /* JADX INFO: compiled from: StreamPlayUtils.kt */
    @Metadata(d1 = {"\u0000\n\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", "B", "Lkotlinx/coroutines/CoroutineScope;", "com/phisher98/StreamPlayUtilsKt$safeAmap$2$1$1$1"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StreamPlayExtractor$invokeAnikoto$$inlined$safeAmap$default$1$1", f = "StreamPlayExtractor.kt", i = {0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2}, l = {2266, 2270, 2310}, m = "invokeSuspend", n = {"$this$withPermit$iv", "$this$withPermit$iv", "$completion", "linkId", "serverName", "serverType", "encodedId", "$this$withPermit$iv", "$completion", "linkId", "serverName", "serverType", "encodedId", "serverJson", "embedUrl"}, nl = {2267, 2273, 2311}, s = {"L$0", "L$0", "L$2", "L$3", "L$4", "L$5", "L$6", "L$0", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8"}, v = 2)
    @SourceDebugExtension({"SMAP\nStreamPlayUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1$1$1\n+ 2 Semaphore.kt\nkotlinx/coroutines/sync/SemaphoreKt\n+ 3 StreamPlayExtractor.kt\ncom/phisher98/StreamPlayExtractor\n+ 4 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 5 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 6 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n*L\n1#1,2265:1\n81#2,3:2266\n85#2,2:2312\n5731#3,6:2269\n5737#3,14:2298\n93#4,2:2275\n63#4:2277\n64#4,15:2279\n95#4,2:2296\n1#5:2278\n50#6:2294\n43#6:2295\n*S KotlinDebug\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1$1$1\n+ 2 StreamPlayExtractor.kt\ncom/phisher98/StreamPlayExtractor\n*L\n1889#1:2266,3\n1889#1:2312,2\n5736#2:2275,2\n5736#2:2277\n5736#2:2279,15\n5736#2:2296,2\n5736#2:2278\n5736#2:2294\n5736#2:2295\n*E\n"})
    public static final class C01261 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Map $ajaxHeaders$inlined;
        final /* synthetic */ String $anikotoAPI$inlined;
        final /* synthetic */ String $animeUrl$inlined;
        final /* synthetic */ Function1 $callback$inlined;
        final /* synthetic */ Object $item;
        final /* synthetic */ Semaphore $semaphore;
        final /* synthetic */ Function1 $subtitleCallback$inlined;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C01261(Semaphore semaphore, Object obj, Continuation continuation, String str, Map map, String str2, Function1 function1, Function1 function2) {
            super(2, continuation);
            this.$semaphore = semaphore;
            this.$item = obj;
            this.$anikotoAPI$inlined = str;
            this.$ajaxHeaders$inlined = map;
            this.$animeUrl$inlined = str2;
            this.$subtitleCallback$inlined = function1;
            this.$callback$inlined = function2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C01261(this.$semaphore, this.$item, continuation, this.$anikotoAPI$inlined, this.$ajaxHeaders$inlined, this.$animeUrl$inlined, this.$subtitleCallback$inlined, this.$callback$inlined);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:110:0x0294 A[Catch: Exception -> 0x025d, all -> 0x0392, TRY_ENTER, TRY_LEAVE, TryCatch #16 {all -> 0x0392, blocks: (B:36:0x0159, B:83:0x0221, B:85:0x0225, B:87:0x022b, B:128:0x038b, B:90:0x0237, B:93:0x0241, B:95:0x0250, B:108:0x028e, B:110:0x0294, B:118:0x02c8, B:120:0x0329, B:114:0x02ad, B:116:0x02b3, B:99:0x0268, B:101:0x026e, B:103:0x027d, B:45:0x0193, B:62:0x01db, B:65:0x01e2, B:74:0x01fd, B:73:0x01f7, B:61:0x01d1, B:44:0x0189), top: B:170:0x0159 }] */
        /* JADX WARN: Code duplicated, block: B:112:0x02a9  */
        /* JADX WARN: Code duplicated, block: B:116:0x02b3 A[Catch: Exception -> 0x0383, all -> 0x0392, TryCatch #16 {all -> 0x0392, blocks: (B:36:0x0159, B:83:0x0221, B:85:0x0225, B:87:0x022b, B:128:0x038b, B:90:0x0237, B:93:0x0241, B:95:0x0250, B:108:0x028e, B:110:0x0294, B:118:0x02c8, B:120:0x0329, B:114:0x02ad, B:116:0x02b3, B:99:0x0268, B:101:0x026e, B:103:0x027d, B:45:0x0193, B:62:0x01db, B:65:0x01e2, B:74:0x01fd, B:73:0x01f7, B:61:0x01d1, B:44:0x0189), top: B:170:0x0159 }] */
        /* JADX WARN: Code duplicated, block: B:117:0x02c7  */
        /* JADX WARN: Code duplicated, block: B:122:0x036d A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:123:0x036e  */
        /* JADX WARN: Code duplicated, block: B:127:0x0387 A[ADDED_TO_REGION, REMOVE] */
        /* JADX WARN: Code duplicated, block: B:172:0x01a1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:189:0x01e8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:34:0x014f A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:35:0x0150  */
        /* JADX WARN: Code duplicated, block: B:39:0x0168  */
        /* JADX WARN: Code duplicated, block: B:40:0x016d  */
        /* JADX WARN: Code duplicated, block: B:47:0x0199  */
        /* JADX WARN: Code duplicated, block: B:64:0x01e1  */
        /* JADX WARN: Code duplicated, block: B:74:0x01fd A[Catch: Exception -> 0x0216, all -> 0x0392, TRY_LEAVE, TryCatch #14 {Exception -> 0x0216, blocks: (B:62:0x01db, B:65:0x01e2, B:74:0x01fd, B:73:0x01f7, B:61:0x01d1), top: B:174:0x01d1 }] */
        /* JADX WARN: Code duplicated, block: B:85:0x0225 A[Catch: all -> 0x0392, Exception -> 0x0398, TryCatch #11 {Exception -> 0x0398, blocks: (B:36:0x0159, B:83:0x0221, B:85:0x0225, B:87:0x022b, B:90:0x0237, B:99:0x0268), top: B:170:0x0159 }] */
        /* JADX WARN: Code duplicated, block: B:99:0x0268 A[Catch: all -> 0x0392, Exception -> 0x0398, TRY_ENTER, TRY_LEAVE, TryCatch #11 {Exception -> 0x0398, blocks: (B:36:0x0159, B:83:0x0221, B:85:0x0225, B:87:0x022b, B:90:0x0237, B:99:0x0268), top: B:170:0x0159 }] */
        public final Object invokeSuspend(Object $result) throws Throwable {
            Semaphore $this$withPermit$iv;
            Object obj;
            int $i$f$withPermit;
            Semaphore $this$withPermit$iv2;
            int i;
            String serverName;
            int $i$f$withPermit2;
            int i2;
            Semaphore $this$withPermit$iv3;
            Object obj2;
            Continuation $completion;
            int i3;
            String serverType;
            Semaphore $this$withPermit$iv4;
            String encodedId;
            Object obj3;
            String linkId;
            Object obj4;
            Object obj5;
            Continuation $completion2;
            String linkId2;
            Semaphore $this$withPermit$iv5;
            Object obj6;
            String serverName2;
            String serverJson;
            Object obj7;
            Object obj8;
            Object objDecodeFromString;
            Object obj9;
            DeserializationStrategy deserializationStrategy;
            AnikotoServerResponse anikotoServerResponse;
            Object obj10;
            AnikotoServerResult result;
            String url;
            String embedUrl;
            String str;
            Object obj11;
            Object objLoadSourceNameExtractor$default;
            Object obj12;
            C01261 c01261 = this;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            try {
                switch (c01261.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        Semaphore $this$withPermit$iv6 = c01261.$semaphore;
                        obj = c01261.$item;
                        c01261.L$0 = $this$withPermit$iv6;
                        c01261.L$1 = obj;
                        c01261.label = 1;
                        if ($this$withPermit$iv6.acquire((Continuation) c01261) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        $i$f$withPermit = 0;
                        $this$withPermit$iv2 = $this$withPermit$iv6;
                        i = 0;
                        try {
                            try {
                                $completion = (Continuation) c01261;
                                Triple triple = (Triple) obj;
                                i3 = 0;
                                String linkId3 = (String) triple.component1();
                                String serverName3 = (String) triple.component2();
                                serverType = (String) triple.component3();
                                String encodedId2 = URLEncoder.encode(linkId3, "UTF-8");
                                Requests app = MainActivityKt.getApp();
                                String str2 = c01261.$anikotoAPI$inlined + "/ajax/server?get=" + encodedId2;
                                try {
                                    Map map = c01261.$ajaxHeaders$inlined;
                                    String str3 = c01261.$animeUrl$inlined;
                                    c01261.L$0 = $this$withPermit$iv2;
                                    c01261.L$1 = obj;
                                    try {
                                        c01261.L$2 = SpillingKt.nullOutSpilledVariable($completion);
                                        c01261.L$3 = SpillingKt.nullOutSpilledVariable(linkId3);
                                        c01261.L$4 = serverName3;
                                        c01261.L$5 = serverType;
                                        c01261.L$6 = SpillingKt.nullOutSpilledVariable(encodedId2);
                                        c01261.label = 2;
                                        $this$withPermit$iv4 = $this$withPermit$iv2;
                                        serverName = serverName3;
                                        encodedId = encodedId2;
                                        obj3 = obj;
                                        linkId = linkId3;
                                        obj4 = coroutine_suspended;
                                        try {
                                            obj5 = Requests.get$default(app, str2, map, str3, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, this, 4088, (Object) null);
                                            c01261 = this;
                                            if (obj5 == obj4) {
                                                return obj4;
                                            }
                                            $completion2 = $completion;
                                            linkId2 = serverName;
                                            $this$withPermit$iv5 = $this$withPermit$iv4;
                                            obj6 = obj3;
                                            serverName2 = serverType;
                                            try {
                                                try {
                                                    serverJson = ((NiceResponse) obj5).getText();
                                                    AppUtils appUtils = AppUtils.INSTANCE;
                                                    if (serverJson != null) {
                                                        obj8 = obj4;
                                                        obj9 = null;
                                                    } else {
                                                        try {
                                                            Result.Companion companion = Result.Companion;
                                                            KType kTypeTypeOf = Reflection.typeOf(AnikotoServerResponse.class);
                                                            MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                                                            obj7 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                                                            break;
                                                        } catch (Throwable th) {
                                                            try {
                                                                Result.Companion companion2 = Result.Companion;
                                                                obj7 = Result.constructor-impl(ResultKt.createFailure(th));
                                                            } catch (Exception e) {
                                                                obj8 = obj4;
                                                                objDecodeFromString = null;
                                                                obj9 = objDecodeFromString;
                                                                anikotoServerResponse = (AnikotoServerResponse) obj9;
                                                                if (anikotoServerResponse != null) {
                                                                }
                                                                obj10 = Unit.INSTANCE;
                                                                $this$withPermit$iv5.release();
                                                                return obj10;
                                                            }
                                                        }
                                                        if (Result.exceptionOrNull-impl(obj7) == null) {
                                                            obj8 = obj4;
                                                        } else {
                                                            try {
                                                                Result.Companion companion3 = Result.Companion;
                                                                obj8 = obj4;
                                                                try {
                                                                    try {
                                                                        obj7 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(AnikotoServerResponse.class), (List) null, 2, (Object) null));
                                                                        break;
                                                                    } catch (Throwable th2) {
                                                                        th = th2;
                                                                        try {
                                                                            Result.Companion companion4 = Result.Companion;
                                                                            obj7 = Result.constructor-impl(ResultKt.createFailure(th));
                                                                        } catch (Exception e2) {
                                                                            objDecodeFromString = null;
                                                                        }
                                                                    }
                                                                } catch (Throwable th3) {
                                                                    th = th3;
                                                                    Result.Companion companion5 = Result.Companion;
                                                                    obj7 = Result.constructor-impl(ResultKt.createFailure(th));
                                                                    if (Result.isFailure-impl(obj7)) {
                                                                        obj7 = null;
                                                                    }
                                                                    deserializationStrategy = (KSerializer) obj7;
                                                                    if (deserializationStrategy != null) {
                                                                        try {
                                                                            objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, serverJson);
                                                                        } catch (SerializationException e3) {
                                                                            ArchComponentExtKt.logError(e3);
                                                                            ObjectMapper $this$readValue$iv$iv$iv = MainAPIKt.getMapper();
                                                                            objDecodeFromString = $this$readValue$iv$iv$iv.readValue(serverJson, new TypeReference<AnikotoServerResponse>() { // from class: com.phisher98.StreamPlayExtractor$invokeAnikoto$lambda$8$$inlined$tryParseJson$1
                                                                            });
                                                                        } catch (Throwable th4) {
                                                                            ObjectMapper $this$readValue$iv$iv$iv2 = MainAPIKt.getMapper();
                                                                            objDecodeFromString = $this$readValue$iv$iv$iv2.readValue(serverJson, new TypeReference<AnikotoServerResponse>() { // from class: com.phisher98.StreamPlayExtractor$invokeAnikoto$lambda$8$$inlined$tryParseJson$1
                                                                            });
                                                                        }
                                                                        break;
                                                                    } else {
                                                                        ObjectMapper $this$readValue$iv$iv$iv3 = MainAPIKt.getMapper();
                                                                        objDecodeFromString = $this$readValue$iv$iv$iv3.readValue(serverJson, new TypeReference<AnikotoServerResponse>() { // from class: com.phisher98.StreamPlayExtractor$invokeAnikoto$lambda$8$$inlined$tryParseJson$1
                                                                        });
                                                                    }
                                                                    obj9 = objDecodeFromString;
                                                                    anikotoServerResponse = (AnikotoServerResponse) obj9;
                                                                    if (anikotoServerResponse != null) {
                                                                    }
                                                                    obj10 = Unit.INSTANCE;
                                                                    $this$withPermit$iv5.release();
                                                                    return obj10;
                                                                }
                                                            } catch (Throwable th5) {
                                                                th = th5;
                                                                obj8 = obj4;
                                                            }
                                                        }
                                                        if (Result.isFailure-impl(obj7)) {
                                                            obj7 = null;
                                                        }
                                                        deserializationStrategy = (KSerializer) obj7;
                                                        if (deserializationStrategy != null) {
                                                            objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, serverJson);
                                                        } else {
                                                            ObjectMapper $this$readValue$iv$iv$iv4 = MainAPIKt.getMapper();
                                                            objDecodeFromString = $this$readValue$iv$iv$iv4.readValue(serverJson, new TypeReference<AnikotoServerResponse>() { // from class: com.phisher98.StreamPlayExtractor$invokeAnikoto$lambda$8$$inlined$tryParseJson$1
                                                            });
                                                        }
                                                        obj9 = objDecodeFromString;
                                                    }
                                                    anikotoServerResponse = (AnikotoServerResponse) obj9;
                                                    try {
                                                        if (anikotoServerResponse != null || (result = anikotoServerResponse.getResult()) == null || (url = result.getUrl()) == null) {
                                                            obj10 = Unit.INSTANCE;
                                                            $this$withPermit$iv5.release();
                                                            return obj10;
                                                        }
                                                        String embedUrl2 = url;
                                                        if (Intrinsics.areEqual(serverName2, "dub")) {
                                                            try {
                                                                if (StringsKt.contains$default(embedUrl2, "/sub", false, 2, (Object) null)) {
                                                                    embedUrl2 = StringsKt.replace$default(embedUrl2, "/sub", "/dub", false, 4, (Object) null);
                                                                } else if (!Intrinsics.areEqual(serverName2, "dub") && StringsKt.contains$default(embedUrl2, "/dub", false, 2, (Object) null)) {
                                                                    embedUrl2 = StringsKt.replace$default(embedUrl2, "/dub", "/sub", false, 4, (Object) null);
                                                                }
                                                                embedUrl = null;
                                                                try {
                                                                    if (StringsKt.startsWith$default(embedUrl2, "//", false, 2, (Object) null)) {
                                                                        str = "https:" + embedUrl2;
                                                                        embedUrl = null;
                                                                    } else {
                                                                        embedUrl = null;
                                                                        if (StringsKt.startsWith$default(embedUrl2, "/", false, 2, (Object) null)) {
                                                                            str = c01261.$anikotoAPI$inlined + embedUrl2;
                                                                        } else {
                                                                            str = embedUrl2;
                                                                        }
                                                                    }
                                                                    String embedUrl3 = str;
                                                                    Log.INSTANCE.d("Anikoto", "embedUrl: " + embedUrl3 + " [" + linkId2 + '/' + serverName2 + ']');
                                                                    String str4 = "Anikoto [" + linkId2 + ']';
                                                                    String str5 = c01261.$anikotoAPI$inlined + '/';
                                                                    Function1 function1 = c01261.$subtitleCallback$inlined;
                                                                    Function1 function2 = c01261.$callback$inlined;
                                                                    c01261.L$0 = $this$withPermit$iv5;
                                                                    c01261.L$1 = obj6;
                                                                    c01261.L$2 = SpillingKt.nullOutSpilledVariable($completion2);
                                                                    c01261.L$3 = SpillingKt.nullOutSpilledVariable(linkId);
                                                                    c01261.L$4 = SpillingKt.nullOutSpilledVariable(linkId2);
                                                                    c01261.L$5 = SpillingKt.nullOutSpilledVariable(serverName2);
                                                                    c01261.L$6 = SpillingKt.nullOutSpilledVariable(encodedId);
                                                                    c01261.L$7 = SpillingKt.nullOutSpilledVariable(serverJson);
                                                                    c01261.L$8 = SpillingKt.nullOutSpilledVariable(embedUrl3);
                                                                    c01261.label = 3;
                                                                    obj11 = obj8;
                                                                    objLoadSourceNameExtractor$default = StreamPlayUtilsKt.loadSourceNameExtractor$default(str4, embedUrl3, str5, function1, function2, null, null, c01261, 96, null);
                                                                    if (objLoadSourceNameExtractor$default == obj11) {
                                                                        return obj11;
                                                                    }
                                                                    $this$withPermit$iv3 = $this$withPermit$iv5;
                                                                    i2 = i;
                                                                    obj12 = objLoadSourceNameExtractor$default;
                                                                    obj10 = obj12;
                                                                    $this$withPermit$iv5 = $this$withPermit$iv3;
                                                                } catch (Exception e4) {
                                                                    e = e4;
                                                                    serverName = embedUrl;
                                                                    obj2 = obj6;
                                                                    $this$withPermit$iv3 = $this$withPermit$iv5;
                                                                    $i$f$withPermit2 = $i$f$withPermit;
                                                                    i2 = i;
                                                                    Log.INSTANCE.e("safeMap", "Request failed for " + obj2 + ' ' + e);
                                                                    $this$withPermit$iv5 = $this$withPermit$iv3;
                                                                    obj10 = serverName;
                                                                }
                                                            } catch (Exception e5) {
                                                                e = e5;
                                                                obj2 = obj6;
                                                                $this$withPermit$iv3 = $this$withPermit$iv5;
                                                                $i$f$withPermit2 = $i$f$withPermit;
                                                                i2 = i;
                                                                serverName = null;
                                                                Log.INSTANCE.e("safeMap", "Request failed for " + obj2 + ' ' + e);
                                                                $this$withPermit$iv5 = $this$withPermit$iv3;
                                                                obj10 = serverName;
                                                            }
                                                        } else {
                                                            if (!Intrinsics.areEqual(serverName2, "dub")) {
                                                                embedUrl2 = StringsKt.replace$default(embedUrl2, "/dub", "/sub", false, 4, (Object) null);
                                                            }
                                                            embedUrl = null;
                                                            if (StringsKt.startsWith$default(embedUrl2, "//", false, 2, (Object) null)) {
                                                                str = "https:" + embedUrl2;
                                                                embedUrl = null;
                                                            } else {
                                                                embedUrl = null;
                                                                if (StringsKt.startsWith$default(embedUrl2, "/", false, 2, (Object) null)) {
                                                                    str = c01261.$anikotoAPI$inlined + embedUrl2;
                                                                } else {
                                                                    str = embedUrl2;
                                                                }
                                                            }
                                                            String embedUrl4 = str;
                                                            Log.INSTANCE.d("Anikoto", "embedUrl: " + embedUrl4 + " [" + linkId2 + '/' + serverName2 + ']');
                                                            String str6 = "Anikoto [" + linkId2 + ']';
                                                            String str7 = c01261.$anikotoAPI$inlined + '/';
                                                            Function1 function3 = c01261.$subtitleCallback$inlined;
                                                            Function1 function4 = c01261.$callback$inlined;
                                                            c01261.L$0 = $this$withPermit$iv5;
                                                            c01261.L$1 = obj6;
                                                            c01261.L$2 = SpillingKt.nullOutSpilledVariable($completion2);
                                                            c01261.L$3 = SpillingKt.nullOutSpilledVariable(linkId);
                                                            c01261.L$4 = SpillingKt.nullOutSpilledVariable(linkId2);
                                                            c01261.L$5 = SpillingKt.nullOutSpilledVariable(serverName2);
                                                            c01261.L$6 = SpillingKt.nullOutSpilledVariable(encodedId);
                                                            c01261.L$7 = SpillingKt.nullOutSpilledVariable(serverJson);
                                                            c01261.L$8 = SpillingKt.nullOutSpilledVariable(embedUrl4);
                                                            c01261.label = 3;
                                                            obj11 = obj8;
                                                            objLoadSourceNameExtractor$default = StreamPlayUtilsKt.loadSourceNameExtractor$default(str6, embedUrl4, str7, function3, function4, null, null, c01261, 96, null);
                                                            if (objLoadSourceNameExtractor$default == obj11) {
                                                                return obj11;
                                                            }
                                                            $this$withPermit$iv3 = $this$withPermit$iv5;
                                                            i2 = i;
                                                            obj12 = objLoadSourceNameExtractor$default;
                                                            obj10 = obj12;
                                                            $this$withPermit$iv5 = $this$withPermit$iv3;
                                                        }
                                                        $this$withPermit$iv5.release();
                                                        return obj10;
                                                    } catch (Exception e6) {
                                                        e = e6;
                                                    }
                                                    break;
                                                } catch (Exception e7) {
                                                    e = e7;
                                                    serverName = null;
                                                }
                                                $this$withPermit$iv5.release();
                                                return obj10;
                                            } catch (Throwable th6) {
                                                th = th6;
                                                $this$withPermit$iv = $this$withPermit$iv5;
                                                $this$withPermit$iv.release();
                                                throw th;
                                            }
                                            obj2 = obj6;
                                            $this$withPermit$iv3 = $this$withPermit$iv5;
                                            $i$f$withPermit2 = $i$f$withPermit;
                                            i2 = i;
                                            Log.INSTANCE.e("safeMap", "Request failed for " + obj2 + ' ' + e);
                                            $this$withPermit$iv5 = $this$withPermit$iv3;
                                            obj10 = serverName;
                                        } catch (Exception e8) {
                                            e = e8;
                                            serverName = null;
                                            $i$f$withPermit2 = $i$f$withPermit;
                                            i2 = 0;
                                            $this$withPermit$iv3 = $this$withPermit$iv4;
                                            obj2 = obj3;
                                        } catch (Throwable th7) {
                                            th = th7;
                                            $this$withPermit$iv = $this$withPermit$iv4;
                                            $this$withPermit$iv.release();
                                            throw th;
                                        }
                                    } catch (Exception e9) {
                                        e = e9;
                                        serverName = null;
                                        $i$f$withPermit2 = $i$f$withPermit;
                                        i2 = 0;
                                        $this$withPermit$iv3 = $this$withPermit$iv2;
                                        obj2 = obj;
                                    }
                                } catch (Exception e10) {
                                    e = e10;
                                    serverName = null;
                                }
                            } catch (Exception e11) {
                                e = e11;
                                serverName = null;
                            }
                        } catch (Throwable th8) {
                            th = th8;
                            $this$withPermit$iv = $this$withPermit$iv2;
                        }
                        break;
                    case 1:
                        obj = c01261.L$1;
                        $this$withPermit$iv2 = (Semaphore) c01261.L$0;
                        ResultKt.throwOnFailure($result);
                        $i$f$withPermit = 0;
                        i = 0;
                        $completion = (Continuation) c01261;
                        Triple triple2 = (Triple) obj;
                        i3 = 0;
                        String linkId4 = (String) triple2.component1();
                        String serverName4 = (String) triple2.component2();
                        serverType = (String) triple2.component3();
                        String encodedId3 = URLEncoder.encode(linkId4, "UTF-8");
                        Requests app2 = MainActivityKt.getApp();
                        String str8 = c01261.$anikotoAPI$inlined + "/ajax/server?get=" + encodedId3;
                        Map map2 = c01261.$ajaxHeaders$inlined;
                        String str9 = c01261.$animeUrl$inlined;
                        c01261.L$0 = $this$withPermit$iv2;
                        c01261.L$1 = obj;
                        c01261.L$2 = SpillingKt.nullOutSpilledVariable($completion);
                        c01261.L$3 = SpillingKt.nullOutSpilledVariable(linkId4);
                        c01261.L$4 = serverName4;
                        c01261.L$5 = serverType;
                        c01261.L$6 = SpillingKt.nullOutSpilledVariable(encodedId3);
                        c01261.label = 2;
                        $this$withPermit$iv4 = $this$withPermit$iv2;
                        serverName = serverName4;
                        encodedId = encodedId3;
                        obj3 = obj;
                        linkId = linkId4;
                        obj4 = coroutine_suspended;
                        obj5 = Requests.get$default(app2, str8, map2, str9, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, this, 4088, (Object) null);
                        c01261 = this;
                        if (obj5 == obj4) {
                            return obj4;
                        }
                        $completion2 = $completion;
                        linkId2 = serverName;
                        $this$withPermit$iv5 = $this$withPermit$iv4;
                        obj6 = obj3;
                        serverName2 = serverType;
                        serverJson = ((NiceResponse) obj5).getText();
                        AppUtils appUtils2 = AppUtils.INSTANCE;
                        if (serverJson != null) {
                            Result.Companion companion6 = Result.Companion;
                            KType kTypeTypeOf2 = Reflection.typeOf(AnikotoServerResponse.class);
                            MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                            obj7 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf2));
                            if (Result.exceptionOrNull-impl(obj7) == null) {
                                Result.Companion companion7 = Result.Companion;
                                obj8 = obj4;
                                obj7 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(AnikotoServerResponse.class), (List) null, 2, (Object) null));
                            } else {
                                obj8 = obj4;
                            }
                            if (Result.isFailure-impl(obj7)) {
                                obj7 = null;
                            }
                            deserializationStrategy = (KSerializer) obj7;
                            if (deserializationStrategy != null) {
                                objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, serverJson);
                            } else {
                                ObjectMapper $this$readValue$iv$iv$iv5 = MainAPIKt.getMapper();
                                objDecodeFromString = $this$readValue$iv$iv$iv5.readValue(serverJson, new TypeReference<AnikotoServerResponse>() { // from class: com.phisher98.StreamPlayExtractor$invokeAnikoto$lambda$8$$inlined$tryParseJson$1
                                });
                            }
                            obj9 = objDecodeFromString;
                            break;
                        } else {
                            obj8 = obj4;
                            obj9 = null;
                        }
                        anikotoServerResponse = (AnikotoServerResponse) obj9;
                        if (anikotoServerResponse != null) {
                        }
                        obj10 = Unit.INSTANCE;
                        $this$withPermit$iv5.release();
                        return obj10;
                    case 2:
                        String encodedId4 = (String) c01261.L$6;
                        String serverType2 = (String) c01261.L$5;
                        String serverName5 = (String) c01261.L$4;
                        String linkId5 = (String) c01261.L$3;
                        $completion2 = (Continuation) c01261.L$2;
                        obj6 = c01261.L$1;
                        $this$withPermit$iv5 = (Semaphore) c01261.L$0;
                        try {
                            ResultKt.throwOnFailure($result);
                            i3 = 0;
                            obj4 = coroutine_suspended;
                            $i$f$withPermit = 0;
                            i = 0;
                            encodedId = encodedId4;
                            linkId = linkId5;
                            obj5 = $result;
                            linkId2 = serverName5;
                            serverName2 = serverType2;
                            serverJson = ((NiceResponse) obj5).getText();
                            AppUtils appUtils3 = AppUtils.INSTANCE;
                            if (serverJson != null) {
                                obj8 = obj4;
                                obj9 = null;
                            } else {
                                Result.Companion companion8 = Result.Companion;
                                KType kTypeTypeOf3 = Reflection.typeOf(AnikotoServerResponse.class);
                                MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                                obj7 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf3));
                                if (Result.exceptionOrNull-impl(obj7) == null) {
                                    Result.Companion companion9 = Result.Companion;
                                    obj8 = obj4;
                                    obj7 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(AnikotoServerResponse.class), (List) null, 2, (Object) null));
                                } else {
                                    obj8 = obj4;
                                }
                                if (Result.isFailure-impl(obj7)) {
                                    obj7 = null;
                                }
                                deserializationStrategy = (KSerializer) obj7;
                                if (deserializationStrategy != null) {
                                    objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, serverJson);
                                } else {
                                    ObjectMapper $this$readValue$iv$iv$iv6 = MainAPIKt.getMapper();
                                    objDecodeFromString = $this$readValue$iv$iv$iv6.readValue(serverJson, new TypeReference<AnikotoServerResponse>() { // from class: com.phisher98.StreamPlayExtractor$invokeAnikoto$lambda$8$$inlined$tryParseJson$1
                                    });
                                }
                                obj9 = objDecodeFromString;
                            }
                            anikotoServerResponse = (AnikotoServerResponse) obj9;
                            if (anikotoServerResponse != null) {
                            }
                            obj10 = Unit.INSTANCE;
                            break;
                        } catch (Exception e12) {
                            e = e12;
                            serverName = null;
                            $i$f$withPermit2 = 0;
                            i2 = 0;
                            obj2 = obj6;
                            $this$withPermit$iv3 = $this$withPermit$iv5;
                            break;
                        } catch (Throwable th9) {
                            th = th9;
                            $this$withPermit$iv = $this$withPermit$iv5;
                            $this$withPermit$iv.release();
                            throw th;
                        }
                        $this$withPermit$iv5.release();
                        return obj10;
                    case 3:
                        $i$f$withPermit2 = 0;
                        i2 = 0;
                        obj2 = c01261.L$1;
                        $this$withPermit$iv3 = (Semaphore) c01261.L$0;
                        try {
                            ResultKt.throwOnFailure($result);
                            obj12 = $result;
                            obj10 = obj12;
                            $this$withPermit$iv5 = $this$withPermit$iv3;
                        } catch (Exception e13) {
                            e = e13;
                            serverName = null;
                            Log.INSTANCE.e("safeMap", "Request failed for " + obj2 + ' ' + e);
                            $this$withPermit$iv5 = $this$withPermit$iv3;
                            obj10 = serverName;
                        }
                        $this$withPermit$iv5.release();
                        return obj10;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } catch (Throwable th10) {
                th = th10;
            }
        }
    }

    public final Object invokeSuspend(Object $result) {
        Object objAwaitAll;
        CoroutineScope $this$coroutineScope = (CoroutineScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Semaphore semaphore = SemaphoreKt.Semaphore$default(this.$concurrency, 0, 2, (Object) null);
                Iterable $this$map$iv = this.$this_runCatching;
                Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                for (Object item$iv$iv : $this$map$iv) {
                    Collection destination$iv$iv2 = destination$iv$iv;
                    destination$iv$iv2.add(BuildersKt.async$default($this$coroutineScope, Dispatchers.getIO(), (CoroutineStart) null, new C01261(semaphore, item$iv$iv, null, this.$anikotoAPI$inlined, this.$ajaxHeaders$inlined, this.$animeUrl$inlined, this.$subtitleCallback$inlined, this.$callback$inlined), 2, (Object) null));
                    $this$map$iv = $this$map$iv;
                    destination$iv$iv = destination$iv$iv2;
                }
                this.L$0 = SpillingKt.nullOutSpilledVariable($this$coroutineScope);
                this.L$1 = SpillingKt.nullOutSpilledVariable(semaphore);
                this.label = 1;
                objAwaitAll = AwaitKt.awaitAll((List) destination$iv$iv, (Continuation) this);
                if (objAwaitAll == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                objAwaitAll = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return CollectionsKt.filterNotNull((Iterable) objAwaitAll);
    }
}
