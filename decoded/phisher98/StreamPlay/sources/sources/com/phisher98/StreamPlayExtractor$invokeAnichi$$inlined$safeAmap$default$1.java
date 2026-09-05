package com.phisher98;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lagradost.api.Log;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.mvvm.ArchComponentExtKt;
import com.lagradost.cloudstream3.utils.AppUtils;
import com.lagradost.nicehttp.NiceResponse;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KType;
import kotlin.text.StringsKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.sync.Semaphore;
import kotlinx.coroutines.sync.SemaphoreKt;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.modules.SerializersModule;

/* JADX INFO: compiled from: StreamPlayUtils.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/StreamPlay/classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\b\u00028\u00000\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "com/phisher98/StreamPlayUtilsKt$safeAmap$2$1"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.phisher98.StreamPlayExtractor$invokeAnichi$$inlined$safeAmap$default$1", f = "StreamPlayExtractor.kt", i = {0, 0}, l = {1898}, m = "invokeSuspend", n = {"$this$coroutineScope", "semaphore"}, nl = {-1}, s = {"L$0", "L$1"}, v = 2)
@SourceDebugExtension({"SMAP\nStreamPlayUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,2265:1\n1739#2:2266\n1814#2,3:2267\n*S KotlinDebug\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1\n*L\n1887#1:2266\n1887#1:2267,3\n*E\n"})
public final class StreamPlayExtractor$invokeAnichi$$inlined$safeAmap$default$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Unit>>, Object> {
    final /* synthetic */ Function1 $callback$inlined;
    final /* synthetic */ int $concurrency;
    final /* synthetic */ String $dubtype$inlined;
    final /* synthetic */ String $ephash$inlined;
    final /* synthetic */ Integer $episode$inlined;
    final /* synthetic */ Map $headers$inlined;
    final /* synthetic */ String $id$inlined;
    final /* synthetic */ boolean $isMovie$inlined;
    final /* synthetic */ String $privatereferer$inlined;
    final /* synthetic */ Function1 $subtitleCallback$inlined;
    final /* synthetic */ Iterable $this_runCatching;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StreamPlayExtractor$invokeAnichi$$inlined$safeAmap$default$1(int i, Iterable iterable, Continuation continuation, boolean z, String str, String str2, Integer num, String str3, Map map, String str4, Function1 function1, Function1 function2) {
        super(2, continuation);
        this.$concurrency = i;
        this.$this_runCatching = iterable;
        this.$isMovie$inlined = z;
        this.$dubtype$inlined = str;
        this.$id$inlined = str2;
        this.$episode$inlined = num;
        this.$ephash$inlined = str3;
        this.$headers$inlined = map;
        this.$privatereferer$inlined = str4;
        this.$subtitleCallback$inlined = function1;
        this.$callback$inlined = function2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> streamPlayExtractor$invokeAnichi$$inlined$safeAmap$default$1 = new StreamPlayExtractor$invokeAnichi$$inlined$safeAmap$default$1(this.$concurrency, this.$this_runCatching, continuation, this.$isMovie$inlined, this.$dubtype$inlined, this.$id$inlined, this.$episode$inlined, this.$ephash$inlined, this.$headers$inlined, this.$privatereferer$inlined, this.$subtitleCallback$inlined, this.$callback$inlined);
        streamPlayExtractor$invokeAnichi$$inlined$safeAmap$default$1.L$0 = obj;
        return streamPlayExtractor$invokeAnichi$$inlined$safeAmap$default$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends Unit>> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: renamed from: com.phisher98.StreamPlayExtractor$invokeAnichi$$inlined$safeAmap$default$1$1 */
    /* JADX INFO: compiled from: StreamPlayUtils.kt */
    @Metadata(d1 = {"\u0000\n\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", "B", "Lkotlinx/coroutines/CoroutineScope;", "com/phisher98/StreamPlayUtilsKt$safeAmap$2$1$1$1"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StreamPlayExtractor$invokeAnichi$$inlined$safeAmap$default$1$1", f = "StreamPlayExtractor.kt", i = {0, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {2266, 2272, 2344}, m = "invokeSuspend", n = {"$this$withPermit$iv", "$this$withPermit$iv", "$completion", "lang", "epQuery", "$this$withPermit$iv", "$completion", "lang", "epQuery", "responseText", "$completion$iv", "$this$safeAmap_u24lambda_u240$iv", "$this$safeAmap_u24default$iv", "episodeLinks", "concurrency$iv"}, nl = {2267, 2276, 2345}, s = {"L$0", "L$0", "L$2", "L$3", "L$4", "L$0", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "I$0"}, v = 2)
    @SourceDebugExtension({"SMAP\nStreamPlayUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1$1$1\n+ 2 Semaphore.kt\nkotlinx/coroutines/sync/SemaphoreKt\n+ 3 StreamPlayExtractor.kt\ncom/phisher98/StreamPlayExtractor\n+ 4 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 5 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 6 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n+ 7 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt\n*L\n1#1,2265:1\n81#2,3:2266\n85#2,2:2348\n624#3,13:2269\n638#3,2:2305\n640#3,3:2308\n643#3,6:2334\n761#3:2347\n93#4,2:2282\n63#4:2284\n64#4,15:2286\n95#4,2:2303\n93#4,2:2311\n63#4:2313\n64#4,15:2315\n95#4,2:2332\n1#5:2285\n1#5:2307\n1#5:2314\n50#6:2301\n43#6:2302\n50#6:2330\n43#6:2331\n1880#7,5:2340\n1899#7,2:2345\n*S KotlinDebug\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1$1$1\n+ 2 StreamPlayExtractor.kt\ncom/phisher98/StreamPlayExtractor\n*L\n1889#1:2266,3\n1889#1:2348,2\n634#2:2282,2\n634#2:2284\n634#2:2286,15\n634#2:2303,2\n642#2:2311,2\n642#2:2313\n642#2:2315,15\n642#2:2332,2\n634#2:2285\n642#2:2314\n634#2:2301\n634#2:2302\n642#2:2330\n642#2:2331\n648#2:2340,5\n648#2:2345,2\n*E\n"})
    public static final class C01191 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1 $callback$inlined;
        final /* synthetic */ String $dubtype$inlined;
        final /* synthetic */ String $ephash$inlined;
        final /* synthetic */ Integer $episode$inlined;
        final /* synthetic */ Map $headers$inlined;
        final /* synthetic */ String $id$inlined;
        final /* synthetic */ boolean $isMovie$inlined;
        final /* synthetic */ Object $item;
        final /* synthetic */ String $privatereferer$inlined;
        final /* synthetic */ Semaphore $semaphore;
        final /* synthetic */ Function1 $subtitleCallback$inlined;
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C01191(Semaphore semaphore, Object obj, Continuation continuation, boolean z, String str, String str2, Integer num, String str3, Map map, String str4, Function1 function1, Function1 function2) {
            super(2, continuation);
            this.$semaphore = semaphore;
            this.$item = obj;
            this.$isMovie$inlined = z;
            this.$dubtype$inlined = str;
            this.$id$inlined = str2;
            this.$episode$inlined = num;
            this.$ephash$inlined = str3;
            this.$headers$inlined = map;
            this.$privatereferer$inlined = str4;
            this.$subtitleCallback$inlined = function1;
            this.$callback$inlined = function2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C01191(this.$semaphore, this.$item, continuation, this.$isMovie$inlined, this.$dubtype$inlined, this.$id$inlined, this.$episode$inlined, this.$ephash$inlined, this.$headers$inlined, this.$privatereferer$inlined, this.$subtitleCallback$inlined, this.$callback$inlined);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:100:0x0249  */
        /* JADX WARN: Code duplicated, block: B:104:0x0254  */
        /* JADX WARN: Code duplicated, block: B:105:0x025b  */
        /* JADX WARN: Code duplicated, block: B:112:0x028b  */
        /* JADX WARN: Code duplicated, block: B:128:0x02d8  */
        /* JADX WARN: Code duplicated, block: B:145:0x02ff  */
        /* JADX WARN: Code duplicated, block: B:157:0x032d A[Catch: Exception -> 0x042e, all -> 0x043a, TryCatch #0 {Exception -> 0x042e, blocks: (B:89:0x0229, B:91:0x022e, B:93:0x0235, B:97:0x0240, B:101:0x024b, B:155:0x0329, B:157:0x032d, B:159:0x0334, B:161:0x033a, B:173:0x0355, B:174:0x035d, B:165:0x0343, B:167:0x0349), top: B:216:0x0229 }] */
        /* JADX WARN: Code duplicated, block: B:159:0x0334 A[Catch: Exception -> 0x042e, all -> 0x043a, TryCatch #0 {Exception -> 0x042e, blocks: (B:89:0x0229, B:91:0x022e, B:93:0x0235, B:97:0x0240, B:101:0x024b, B:155:0x0329, B:157:0x032d, B:159:0x0334, B:161:0x033a, B:173:0x0355, B:174:0x035d, B:165:0x0343, B:167:0x0349), top: B:216:0x0229 }] */
        /* JADX WARN: Code duplicated, block: B:165:0x0343 A[Catch: Exception -> 0x042e, all -> 0x043a, TryCatch #0 {Exception -> 0x042e, blocks: (B:89:0x0229, B:91:0x022e, B:93:0x0235, B:97:0x0240, B:101:0x024b, B:155:0x0329, B:157:0x032d, B:159:0x0334, B:161:0x033a, B:173:0x0355, B:174:0x035d, B:165:0x0343, B:167:0x0349), top: B:216:0x0229 }] */
        /* JADX WARN: Code duplicated, block: B:167:0x0349 A[Catch: Exception -> 0x042e, all -> 0x043a, TryCatch #0 {Exception -> 0x042e, blocks: (B:89:0x0229, B:91:0x022e, B:93:0x0235, B:97:0x0240, B:101:0x024b, B:155:0x0329, B:157:0x032d, B:159:0x0334, B:161:0x033a, B:173:0x0355, B:174:0x035d, B:165:0x0343, B:167:0x0349), top: B:216:0x0229 }] */
        /* JADX WARN: Code duplicated, block: B:168:0x034f  */
        /* JADX WARN: Code duplicated, block: B:170:0x0351  */
        /* JADX WARN: Code duplicated, block: B:173:0x0355 A[Catch: Exception -> 0x042e, all -> 0x043a, TryCatch #0 {Exception -> 0x042e, blocks: (B:89:0x0229, B:91:0x022e, B:93:0x0235, B:97:0x0240, B:101:0x024b, B:155:0x0329, B:157:0x032d, B:159:0x0334, B:161:0x033a, B:173:0x0355, B:174:0x035d, B:165:0x0343, B:167:0x0349), top: B:216:0x0229 }] */
        /* JADX WARN: Code duplicated, block: B:174:0x035d A[Catch: Exception -> 0x042e, all -> 0x043a, TRY_LEAVE, TryCatch #0 {Exception -> 0x042e, blocks: (B:89:0x0229, B:91:0x022e, B:93:0x0235, B:97:0x0240, B:101:0x024b, B:155:0x0329, B:157:0x032d, B:159:0x0334, B:161:0x033a, B:173:0x0355, B:174:0x035d, B:165:0x0343, B:167:0x0349), top: B:216:0x0229 }] */
        /* JADX WARN: Code duplicated, block: B:180:0x03c4 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:181:0x03c5  */
        /* JADX WARN: Code duplicated, block: B:243:0x0293 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:247:0x019f A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:257:0x01e1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:261:0x02df A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:34:0x00f3 A[Catch: all -> 0x043a, Exception -> 0x043e, TryCatch #20 {all -> 0x043a, blocks: (B:39:0x014c, B:89:0x0229, B:91:0x022e, B:93:0x0235, B:97:0x0240, B:101:0x024b, B:155:0x0329, B:157:0x032d, B:159:0x0334, B:161:0x033a, B:173:0x0355, B:174:0x035d, B:165:0x0343, B:167:0x0349, B:110:0x0285, B:126:0x02d2, B:129:0x02d9, B:146:0x0301, B:144:0x02f8, B:125:0x02c8, B:109:0x027b, B:48:0x0194, B:60:0x01d2, B:64:0x01db, B:80:0x0203, B:78:0x01fa, B:59:0x01c8, B:47:0x018a, B:24:0x00a9, B:26:0x00b7, B:28:0x00bb, B:32:0x00ce, B:34:0x00f3, B:35:0x00f9), top: B:238:0x00a9 }] */
        /* JADX WARN: Code duplicated, block: B:37:0x0142 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:38:0x0143  */
        /* JADX WARN: Code duplicated, block: B:42:0x0164  */
        /* JADX WARN: Code duplicated, block: B:43:0x016b  */
        /* JADX WARN: Code duplicated, block: B:50:0x019a  */
        /* JADX WARN: Code duplicated, block: B:62:0x01d8  */
        /* JADX WARN: Code duplicated, block: B:63:0x01da  */
        /* JADX WARN: Code duplicated, block: B:79:0x0201  */
        /* JADX WARN: Code duplicated, block: B:91:0x022e A[Catch: Exception -> 0x042e, all -> 0x043a, TryCatch #0 {Exception -> 0x042e, blocks: (B:89:0x0229, B:91:0x022e, B:93:0x0235, B:97:0x0240, B:101:0x024b, B:155:0x0329, B:157:0x032d, B:159:0x0334, B:161:0x033a, B:173:0x0355, B:174:0x035d, B:165:0x0343, B:167:0x0349), top: B:216:0x0229 }] */
        /* JADX WARN: Code duplicated, block: B:94:0x023a  */
        /* JADX WARN: Code duplicated, block: B:97:0x0240 A[Catch: Exception -> 0x042e, all -> 0x043a, TryCatch #0 {Exception -> 0x042e, blocks: (B:89:0x0229, B:91:0x022e, B:93:0x0235, B:97:0x0240, B:101:0x024b, B:155:0x0329, B:157:0x032d, B:159:0x0334, B:161:0x033a, B:173:0x0355, B:174:0x035d, B:165:0x0343, B:167:0x0349), top: B:216:0x0229 }] */
        public final Object invokeSuspend(Object $result) throws Throwable {
            Semaphore $this$withPermit$iv;
            int $i$f$withPermit;
            Object obj;
            int i;
            Object obj2;
            Semaphore $this$withPermit$iv2;
            Continuation $completion;
            String lang;
            String epQuery;
            Object objSafeGet$default;
            int i2;
            Continuation $completion2;
            int i3;
            String lang2;
            String epQuery2;
            String responseText;
            Object obj3;
            String responseText2;
            int i4;
            Object obj4;
            Object obj5;
            DeserializationStrategy deserializationStrategy;
            String value$iv$iv;
            Object objDecodeFromString;
            EncryptedResponse encryptedResponse;
            String encrypted;
            String finalJson;
            String value$iv;
            Object obj6;
            int i5;
            Object obj7;
            String encrypted2;
            DeserializationStrategy deserializationStrategy2;
            String value$iv$iv2;
            Object objDecodeFromString2;
            AnichiEP it;
            Iterable sourceUrls;
            Semaphore $this$withPermit$iv3;
            int i6;
            String lang3;
            Object obj8;
            int i7;
            Object objCoroutineScope;
            Unit unit;
            AnichiEPData data;
            AnichiEpisode episode;
            AnichiEpisode episode2;
            Iterable sourceUrls2;
            EncryptedData data2;
            Semaphore $this$withPermit$iv4;
            int i8;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    Semaphore $this$withPermit$iv5 = this.$semaphore;
                    Object obj9 = this.$item;
                    this.L$0 = $this$withPermit$iv5;
                    this.L$1 = obj9;
                    this.label = 1;
                    if ($this$withPermit$iv5.acquire((Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $this$withPermit$iv = $this$withPermit$iv5;
                    $i$f$withPermit = 0;
                    obj = obj9;
                    i = 0;
                    try {
                        try {
                            $completion = (Continuation) this;
                            lang = (String) obj;
                            try {
                                if (!this.$isMovie$inlined || (this.$dubtype$inlined != null && StringsKt.contains(lang, this.$dubtype$inlined, true))) {
                                    epQuery = "https://api.allanime.day/api?variables={\"showId\":\"" + this.$id$inlined + "\",\"translationType\":\"" + lang + "\",\"episodeString\":\"" + (this.$episode$inlined != null ? this.$episode$inlined.intValue() : 1) + "\"}&extensions={\"persistedQuery\":{\"version\":1,\"sha256Hash\":\"" + this.$ephash$inlined + "\"}}";
                                    Map map = this.$headers$inlined;
                                    String str = this.$privatereferer$inlined;
                                    this.L$0 = $this$withPermit$iv;
                                    this.L$1 = obj;
                                    this.L$2 = SpillingKt.nullOutSpilledVariable($completion);
                                    this.L$3 = lang;
                                    this.L$4 = SpillingKt.nullOutSpilledVariable(epQuery);
                                    this.label = 2;
                                    objSafeGet$default = StreamPlayUtilsKt.safeGet$default(epQuery, map, str, null, null, false, 0, this, 120, null);
                                    if (objSafeGet$default == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    obj2 = obj;
                                    i2 = 0;
                                    $completion2 = $completion;
                                    i3 = 0;
                                    lang2 = lang;
                                    epQuery2 = epQuery;
                                    try {
                                        responseText = ((NiceResponse) objSafeGet$default).getText();
                                        StreamPlayExtractor streamPlayExtractor = StreamPlayExtractor.INSTANCE;
                                        AppUtils appUtils = AppUtils.INSTANCE;
                                        if (responseText != null) {
                                            responseText2 = responseText;
                                            i4 = i2;
                                            obj4 = null;
                                        } else {
                                            try {
                                                Result.Companion companion = Result.Companion;
                                                KType kTypeTypeOf = Reflection.typeOf(EncryptedResponse.class);
                                                MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                                                obj3 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                                                break;
                                            } catch (Throwable th) {
                                                try {
                                                    Result.Companion companion2 = Result.Companion;
                                                    obj3 = Result.constructor-impl(ResultKt.createFailure(th));
                                                } catch (Exception e) {
                                                    responseText2 = responseText;
                                                    i4 = i2;
                                                    obj4 = null;
                                                    encryptedResponse = (EncryptedResponse) obj4;
                                                    if (encryptedResponse != null) {
                                                        encrypted = null;
                                                    } else {
                                                        encrypted = null;
                                                    }
                                                    if (encrypted != null) {
                                                        finalJson = responseText2;
                                                    } else {
                                                        finalJson = responseText2;
                                                    }
                                                    AppUtils appUtils2 = AppUtils.INSTANCE;
                                                    value$iv = finalJson;
                                                    if (value$iv == null) {
                                                        try {
                                                            Result.Companion companion3 = Result.Companion;
                                                            KType kTypeTypeOf2 = Reflection.typeOf(AnichiEP.class);
                                                            MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                                                            obj6 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf2));
                                                            break;
                                                        } catch (Throwable th2) {
                                                            try {
                                                                Result.Companion companion4 = Result.Companion;
                                                                obj6 = Result.constructor-impl(ResultKt.createFailure(th2));
                                                            } catch (Exception e2) {
                                                                i5 = i3;
                                                                obj7 = null;
                                                                it = (AnichiEP) obj7;
                                                                if (it != null) {
                                                                    data = it.getData();
                                                                    if (data != null) {
                                                                        episode = it.getEpisode();
                                                                        if (episode != null) {
                                                                            sourceUrls = episode.getSourceUrls();
                                                                        } else {
                                                                            sourceUrls = null;
                                                                        }
                                                                    } else {
                                                                        episode = it.getEpisode();
                                                                        if (episode != null) {
                                                                            sourceUrls = episode.getSourceUrls();
                                                                        } else {
                                                                            sourceUrls = null;
                                                                        }
                                                                    }
                                                                } else {
                                                                    sourceUrls = null;
                                                                }
                                                                if (sourceUrls == null) {
                                                                    unit = Unit.INSTANCE;
                                                                } else {
                                                                    Iterable $this$safeAmap_u24default$iv = sourceUrls;
                                                                    try {
                                                                        Result.Companion companion5 = Result.Companion;
                                                                        try {
                                                                            C0121xd854210f c0121xd854210f = new C0121xd854210f(7, $this$safeAmap_u24default$iv, null, lang2, this.$subtitleCallback$inlined, this.$callback$inlined, this.$headers$inlined);
                                                                            this.L$0 = $this$withPermit$iv;
                                                                            this.L$1 = obj2;
                                                                            this.L$2 = SpillingKt.nullOutSpilledVariable($completion2);
                                                                            this.L$3 = SpillingKt.nullOutSpilledVariable(lang2);
                                                                            this.L$4 = SpillingKt.nullOutSpilledVariable(epQuery2);
                                                                            this.L$5 = SpillingKt.nullOutSpilledVariable(responseText2);
                                                                            this.L$6 = SpillingKt.nullOutSpilledVariable(this);
                                                                            this.L$7 = SpillingKt.nullOutSpilledVariable($this$safeAmap_u24default$iv);
                                                                            this.L$8 = SpillingKt.nullOutSpilledVariable($this$safeAmap_u24default$iv);
                                                                            this.L$9 = SpillingKt.nullOutSpilledVariable(sourceUrls);
                                                                            this.I$0 = 7;
                                                                            this.label = 3;
                                                                            objCoroutineScope = CoroutineScopeKt.coroutineScope(c0121xd854210f, this);
                                                                            if (objCoroutineScope == coroutine_suspended) {
                                                                                return coroutine_suspended;
                                                                            }
                                                                            $this$withPermit$iv3 = $this$withPermit$iv;
                                                                            lang3 = lang2;
                                                                            obj8 = obj2;
                                                                            i7 = i4;
                                                                            try {
                                                                                Result.constructor-impl((List) objCoroutineScope);
                                                                                $this$withPermit$iv4 = $this$withPermit$iv3;
                                                                                i8 = i7;
                                                                            } catch (Throwable th3) {
                                                                                th = th3;
                                                                                i6 = i5;
                                                                                try {
                                                                                    Result.Companion companion6 = Result.Companion;
                                                                                    Result.constructor-impl(ResultKt.createFailure(th));
                                                                                    $this$withPermit$iv4 = $this$withPermit$iv3;
                                                                                    i8 = i7;
                                                                                } catch (Exception e3) {
                                                                                    e = e3;
                                                                                    obj2 = obj8;
                                                                                    $this$withPermit$iv2 = $this$withPermit$iv3;
                                                                                    Log.INSTANCE.e("safeMap", "Request failed for " + obj2 + ' ' + e);
                                                                                    $this$withPermit$iv = $this$withPermit$iv2;
                                                                                    unit = null;
                                                                                    $this$withPermit$iv.release();
                                                                                    return unit;
                                                                                } catch (Throwable th4) {
                                                                                    th = th4;
                                                                                    $this$withPermit$iv2 = $this$withPermit$iv3;
                                                                                    $this$withPermit$iv2.release();
                                                                                    throw th;
                                                                                }
                                                                            }
                                                                            i = i8;
                                                                            $this$withPermit$iv2 = $this$withPermit$iv4;
                                                                            obj2 = obj8;
                                                                            $this$withPermit$iv = $this$withPermit$iv2;
                                                                            unit = Unit.INSTANCE;
                                                                        } catch (Throwable th5) {
                                                                            th = th5;
                                                                            $this$withPermit$iv3 = $this$withPermit$iv;
                                                                            i6 = i5;
                                                                            lang3 = lang2;
                                                                            obj8 = obj2;
                                                                            i7 = i4;
                                                                            Result.Companion companion7 = Result.Companion;
                                                                            Result.constructor-impl(ResultKt.createFailure(th));
                                                                            $this$withPermit$iv4 = $this$withPermit$iv3;
                                                                            i8 = i7;
                                                                            i = i8;
                                                                            $this$withPermit$iv2 = $this$withPermit$iv4;
                                                                            obj2 = obj8;
                                                                            $this$withPermit$iv = $this$withPermit$iv2;
                                                                            unit = Unit.INSTANCE;
                                                                            $this$withPermit$iv.release();
                                                                            return unit;
                                                                        }
                                                                    } catch (Throwable th6) {
                                                                        th = th6;
                                                                        $this$withPermit$iv3 = $this$withPermit$iv;
                                                                        i6 = i5;
                                                                        lang3 = lang2;
                                                                        obj8 = obj2;
                                                                        i7 = i4;
                                                                    }
                                                                }
                                                                $this$withPermit$iv.release();
                                                                return unit;
                                                            }
                                                        }
                                                        if (Result.exceptionOrNull-impl(obj6) != null) {
                                                            i5 = i3;
                                                            encrypted2 = null;
                                                        } else {
                                                            try {
                                                                Result.Companion companion8 = Result.Companion;
                                                                try {
                                                                    i5 = i3;
                                                                    encrypted2 = null;
                                                                    try {
                                                                        obj6 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(AnichiEP.class), (List) null, 2, (Object) null));
                                                                        break;
                                                                    } catch (Throwable th7) {
                                                                        th = th7;
                                                                        try {
                                                                            Result.Companion companion9 = Result.Companion;
                                                                            obj6 = Result.constructor-impl(ResultKt.createFailure(th));
                                                                        } catch (Exception e4) {
                                                                            obj7 = null;
                                                                        }
                                                                    }
                                                                } catch (Throwable th8) {
                                                                    th = th8;
                                                                    i5 = i3;
                                                                    encrypted2 = null;
                                                                }
                                                            } catch (Throwable th9) {
                                                                th = th9;
                                                                i5 = i3;
                                                                encrypted2 = null;
                                                            }
                                                        }
                                                        if (Result.isFailure-impl(obj6)) {
                                                            obj6 = encrypted2;
                                                        }
                                                        deserializationStrategy2 = (KSerializer) obj6;
                                                        if (deserializationStrategy2 != null) {
                                                            try {
                                                                value$iv$iv2 = value$iv;
                                                                try {
                                                                    objDecodeFromString2 = MainAPIKt.getJson().decodeFromString(deserializationStrategy2, value$iv$iv2);
                                                                } catch (SerializationException e5) {
                                                                    e$iv$iv = e5;
                                                                    ArchComponentExtKt.logError((Throwable) e$iv$iv);
                                                                    ObjectMapper $this$readValue$iv$iv$iv = MainAPIKt.getMapper();
                                                                    String content$iv$iv$iv = value$iv$iv2;
                                                                    objDecodeFromString2 = $this$readValue$iv$iv$iv.readValue(content$iv$iv$iv, new TypeReference<AnichiEP>() { // from class: com.phisher98.StreamPlayExtractor$invokeAnichi$lambda$1$0$$inlined$tryParseJson$2
                                                                    });
                                                                } catch (Throwable th10) {
                                                                    ObjectMapper $this$readValue$iv$iv$iv2 = MainAPIKt.getMapper();
                                                                    String content$iv$iv$iv2 = value$iv$iv2;
                                                                    objDecodeFromString2 = $this$readValue$iv$iv$iv2.readValue(content$iv$iv$iv2, new TypeReference<AnichiEP>() { // from class: com.phisher98.StreamPlayExtractor$invokeAnichi$lambda$1$0$$inlined$tryParseJson$2
                                                                    });
                                                                }
                                                            } catch (SerializationException e6) {
                                                                e$iv$iv = e6;
                                                                value$iv$iv2 = value$iv;
                                                            } catch (Throwable th11) {
                                                                value$iv$iv2 = value$iv;
                                                            }
                                                            obj7 = objDecodeFromString2;
                                                        } else {
                                                            value$iv$iv2 = value$iv;
                                                        }
                                                        ObjectMapper $this$readValue$iv$iv$iv3 = MainAPIKt.getMapper();
                                                        String content$iv$iv$iv3 = value$iv$iv2;
                                                        objDecodeFromString2 = $this$readValue$iv$iv$iv3.readValue(content$iv$iv$iv3, new TypeReference<AnichiEP>() { // from class: com.phisher98.StreamPlayExtractor$invokeAnichi$lambda$1$0$$inlined$tryParseJson$2
                                                        });
                                                        obj7 = objDecodeFromString2;
                                                        break;
                                                    } else {
                                                        i5 = i3;
                                                        obj7 = null;
                                                    }
                                                    it = (AnichiEP) obj7;
                                                    if (it != null) {
                                                        data = it.getData();
                                                        if (data != null) {
                                                            episode = it.getEpisode();
                                                            if (episode != null) {
                                                                sourceUrls = episode.getSourceUrls();
                                                            } else {
                                                                sourceUrls = null;
                                                            }
                                                        } else {
                                                            episode = it.getEpisode();
                                                            if (episode != null) {
                                                                sourceUrls = episode.getSourceUrls();
                                                            } else {
                                                                sourceUrls = null;
                                                            }
                                                        }
                                                    } else {
                                                        sourceUrls = null;
                                                    }
                                                    if (sourceUrls == null) {
                                                        unit = Unit.INSTANCE;
                                                    } else {
                                                        Iterable $this$safeAmap_u24default$iv2 = sourceUrls;
                                                        Result.Companion companion10 = Result.Companion;
                                                        C0121xd854210f c0121xd854210f2 = new C0121xd854210f(7, $this$safeAmap_u24default$iv2, null, lang2, this.$subtitleCallback$inlined, this.$callback$inlined, this.$headers$inlined);
                                                        this.L$0 = $this$withPermit$iv;
                                                        this.L$1 = obj2;
                                                        this.L$2 = SpillingKt.nullOutSpilledVariable($completion2);
                                                        this.L$3 = SpillingKt.nullOutSpilledVariable(lang2);
                                                        this.L$4 = SpillingKt.nullOutSpilledVariable(epQuery2);
                                                        this.L$5 = SpillingKt.nullOutSpilledVariable(responseText2);
                                                        this.L$6 = SpillingKt.nullOutSpilledVariable(this);
                                                        this.L$7 = SpillingKt.nullOutSpilledVariable($this$safeAmap_u24default$iv2);
                                                        this.L$8 = SpillingKt.nullOutSpilledVariable($this$safeAmap_u24default$iv2);
                                                        this.L$9 = SpillingKt.nullOutSpilledVariable(sourceUrls);
                                                        this.I$0 = 7;
                                                        this.label = 3;
                                                        objCoroutineScope = CoroutineScopeKt.coroutineScope(c0121xd854210f2, this);
                                                        if (objCoroutineScope == coroutine_suspended) {
                                                            return coroutine_suspended;
                                                        }
                                                        $this$withPermit$iv3 = $this$withPermit$iv;
                                                        lang3 = lang2;
                                                        obj8 = obj2;
                                                        i7 = i4;
                                                        Result.constructor-impl((List) objCoroutineScope);
                                                        $this$withPermit$iv4 = $this$withPermit$iv3;
                                                        i8 = i7;
                                                        i = i8;
                                                        $this$withPermit$iv2 = $this$withPermit$iv4;
                                                        obj2 = obj8;
                                                        $this$withPermit$iv = $this$withPermit$iv2;
                                                        unit = Unit.INSTANCE;
                                                    }
                                                    $this$withPermit$iv.release();
                                                    return unit;
                                                }
                                            }
                                            if (Result.exceptionOrNull-impl(obj3) == null) {
                                                responseText2 = responseText;
                                                i4 = i2;
                                            } else {
                                                try {
                                                    Result.Companion companion11 = Result.Companion;
                                                    responseText2 = responseText;
                                                    i4 = i2;
                                                    try {
                                                        obj3 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(EncryptedResponse.class), (List) null, 2, (Object) null));
                                                        break;
                                                    } catch (Throwable th12) {
                                                        th = th12;
                                                        try {
                                                            Result.Companion companion12 = Result.Companion;
                                                            obj3 = Result.constructor-impl(ResultKt.createFailure(th));
                                                        } catch (Exception e7) {
                                                            obj4 = null;
                                                        }
                                                    }
                                                } catch (Throwable th13) {
                                                    th = th13;
                                                    responseText2 = responseText;
                                                    i4 = i2;
                                                }
                                            }
                                            if (Result.isFailure-impl(obj3)) {
                                                obj5 = null;
                                            } else {
                                                obj5 = obj3;
                                            }
                                            deserializationStrategy = (KSerializer) obj5;
                                            if (deserializationStrategy != null) {
                                                try {
                                                    value$iv$iv = responseText;
                                                    try {
                                                        objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, value$iv$iv);
                                                    } catch (SerializationException e8) {
                                                        e$iv$iv = e8;
                                                        ArchComponentExtKt.logError((Throwable) e$iv$iv);
                                                        ObjectMapper $this$readValue$iv$iv$iv4 = MainAPIKt.getMapper();
                                                        String content$iv$iv$iv4 = value$iv$iv;
                                                        objDecodeFromString = $this$readValue$iv$iv$iv4.readValue(content$iv$iv$iv4, new TypeReference<EncryptedResponse>() { // from class: com.phisher98.StreamPlayExtractor$invokeAnichi$lambda$1$0$$inlined$tryParseJson$1
                                                        });
                                                    } catch (Throwable th14) {
                                                        ObjectMapper $this$readValue$iv$iv$iv5 = MainAPIKt.getMapper();
                                                        String content$iv$iv$iv5 = value$iv$iv;
                                                        objDecodeFromString = $this$readValue$iv$iv$iv5.readValue(content$iv$iv$iv5, new TypeReference<EncryptedResponse>() { // from class: com.phisher98.StreamPlayExtractor$invokeAnichi$lambda$1$0$$inlined$tryParseJson$1
                                                        });
                                                    }
                                                } catch (SerializationException e9) {
                                                    e$iv$iv = e9;
                                                    value$iv$iv = responseText;
                                                } catch (Throwable th15) {
                                                    value$iv$iv = responseText;
                                                }
                                                obj4 = objDecodeFromString;
                                            } else {
                                                value$iv$iv = responseText;
                                            }
                                            ObjectMapper $this$readValue$iv$iv$iv6 = MainAPIKt.getMapper();
                                            String content$iv$iv$iv6 = value$iv$iv;
                                            objDecodeFromString = $this$readValue$iv$iv$iv6.readValue(content$iv$iv$iv6, new TypeReference<EncryptedResponse>() { // from class: com.phisher98.StreamPlayExtractor$invokeAnichi$lambda$1$0$$inlined$tryParseJson$1
                                            });
                                            obj4 = objDecodeFromString;
                                        }
                                        try {
                                            encryptedResponse = (EncryptedResponse) obj4;
                                            if (encryptedResponse != null || (data2 = encryptedResponse.getData()) == null) {
                                                encrypted = null;
                                            } else {
                                                encrypted = data2.getTobeparsed();
                                            }
                                            if (encrypted != null || (finalJson = StreamPlayUtilsKt.decodeToBeParsed(encrypted)) == null) {
                                                finalJson = responseText2;
                                            }
                                            AppUtils appUtils3 = AppUtils.INSTANCE;
                                            value$iv = finalJson;
                                            if (value$iv == null) {
                                                i5 = i3;
                                                obj7 = null;
                                            } else {
                                                Result.Companion companion13 = Result.Companion;
                                                KType kTypeTypeOf3 = Reflection.typeOf(AnichiEP.class);
                                                MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                                                obj6 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf3));
                                                if (Result.exceptionOrNull-impl(obj6) != null) {
                                                    Result.Companion companion14 = Result.Companion;
                                                    i5 = i3;
                                                    encrypted2 = null;
                                                    obj6 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(AnichiEP.class), (List) null, 2, (Object) null));
                                                } else {
                                                    i5 = i3;
                                                    encrypted2 = null;
                                                }
                                                if (Result.isFailure-impl(obj6)) {
                                                    obj6 = encrypted2;
                                                }
                                                deserializationStrategy2 = (KSerializer) obj6;
                                                if (deserializationStrategy2 != null) {
                                                    value$iv$iv2 = value$iv;
                                                    objDecodeFromString2 = MainAPIKt.getJson().decodeFromString(deserializationStrategy2, value$iv$iv2);
                                                    obj7 = objDecodeFromString2;
                                                } else {
                                                    value$iv$iv2 = value$iv;
                                                }
                                                ObjectMapper $this$readValue$iv$iv$iv7 = MainAPIKt.getMapper();
                                                String content$iv$iv$iv7 = value$iv$iv2;
                                                objDecodeFromString2 = $this$readValue$iv$iv$iv7.readValue(content$iv$iv$iv7, new TypeReference<AnichiEP>() { // from class: com.phisher98.StreamPlayExtractor$invokeAnichi$lambda$1$0$$inlined$tryParseJson$2
                                                });
                                                obj7 = objDecodeFromString2;
                                            }
                                            it = (AnichiEP) obj7;
                                            if (it != null) {
                                                data = it.getData();
                                                if (data != null || (episode2 = data.getEpisode()) == null || (sourceUrls2 = episode2.getSourceUrls()) == null) {
                                                    episode = it.getEpisode();
                                                    if (episode != null) {
                                                        sourceUrls = episode.getSourceUrls();
                                                    } else {
                                                        sourceUrls = null;
                                                    }
                                                } else {
                                                    sourceUrls = sourceUrls2;
                                                }
                                            } else {
                                                sourceUrls = null;
                                            }
                                            if (sourceUrls == null) {
                                                unit = Unit.INSTANCE;
                                            } else {
                                                Iterable $this$safeAmap_u24default$iv3 = sourceUrls;
                                                Result.Companion companion15 = Result.Companion;
                                                C0121xd854210f c0121xd854210f3 = new C0121xd854210f(7, $this$safeAmap_u24default$iv3, null, lang2, this.$subtitleCallback$inlined, this.$callback$inlined, this.$headers$inlined);
                                                this.L$0 = $this$withPermit$iv;
                                                this.L$1 = obj2;
                                                this.L$2 = SpillingKt.nullOutSpilledVariable($completion2);
                                                this.L$3 = SpillingKt.nullOutSpilledVariable(lang2);
                                                this.L$4 = SpillingKt.nullOutSpilledVariable(epQuery2);
                                                this.L$5 = SpillingKt.nullOutSpilledVariable(responseText2);
                                                this.L$6 = SpillingKt.nullOutSpilledVariable(this);
                                                this.L$7 = SpillingKt.nullOutSpilledVariable($this$safeAmap_u24default$iv3);
                                                this.L$8 = SpillingKt.nullOutSpilledVariable($this$safeAmap_u24default$iv3);
                                                this.L$9 = SpillingKt.nullOutSpilledVariable(sourceUrls);
                                                this.I$0 = 7;
                                                this.label = 3;
                                                objCoroutineScope = CoroutineScopeKt.coroutineScope(c0121xd854210f3, this);
                                                if (objCoroutineScope == coroutine_suspended) {
                                                    return coroutine_suspended;
                                                }
                                                $this$withPermit$iv3 = $this$withPermit$iv;
                                                lang3 = lang2;
                                                obj8 = obj2;
                                                i7 = i4;
                                                Result.constructor-impl((List) objCoroutineScope);
                                                $this$withPermit$iv4 = $this$withPermit$iv3;
                                                i8 = i7;
                                                i = i8;
                                                $this$withPermit$iv2 = $this$withPermit$iv4;
                                                obj2 = obj8;
                                            }
                                        } catch (Exception e10) {
                                            e = e10;
                                            $this$withPermit$iv2 = $this$withPermit$iv;
                                            Log.INSTANCE.e("safeMap", "Request failed for " + obj2 + ' ' + e);
                                            $this$withPermit$iv = $this$withPermit$iv2;
                                            unit = null;
                                            $this$withPermit$iv.release();
                                            return unit;
                                        }
                                        break;
                                    } catch (Exception e11) {
                                        e = e11;
                                        $this$withPermit$iv2 = $this$withPermit$iv;
                                    }
                                    $this$withPermit$iv.release();
                                    return unit;
                                }
                                obj2 = obj;
                                $this$withPermit$iv2 = $this$withPermit$iv;
                                $this$withPermit$iv = $this$withPermit$iv2;
                                unit = Unit.INSTANCE;
                            } catch (Exception e12) {
                                e = e12;
                                Log.INSTANCE.e("safeMap", "Request failed for " + obj2 + ' ' + e);
                                $this$withPermit$iv = $this$withPermit$iv2;
                                unit = null;
                            }
                        } catch (Throwable th16) {
                            th = th16;
                            $this$withPermit$iv2 = $this$withPermit$iv;
                            $this$withPermit$iv2.release();
                            throw th;
                        }
                    } catch (Exception e13) {
                        e = e13;
                        obj2 = obj;
                        $this$withPermit$iv2 = $this$withPermit$iv;
                        Log.INSTANCE.e("safeMap", "Request failed for " + obj2 + ' ' + e);
                        $this$withPermit$iv = $this$withPermit$iv2;
                        unit = null;
                        $this$withPermit$iv.release();
                        return unit;
                    }
                    $this$withPermit$iv.release();
                    return unit;
                case 1:
                    Object obj10 = this.L$1;
                    Semaphore $this$withPermit$iv6 = (Semaphore) this.L$0;
                    ResultKt.throwOnFailure($result);
                    $i$f$withPermit = 0;
                    $this$withPermit$iv = $this$withPermit$iv6;
                    obj = obj10;
                    i = 0;
                    $completion = (Continuation) this;
                    lang = (String) obj;
                    if (this.$isMovie$inlined) {
                    }
                    epQuery = "https://api.allanime.day/api?variables={\"showId\":\"" + this.$id$inlined + "\",\"translationType\":\"" + lang + "\",\"episodeString\":\"" + (this.$episode$inlined != null ? this.$episode$inlined.intValue() : 1) + "\"}&extensions={\"persistedQuery\":{\"version\":1,\"sha256Hash\":\"" + this.$ephash$inlined + "\"}}";
                    Map map2 = this.$headers$inlined;
                    String str2 = this.$privatereferer$inlined;
                    this.L$0 = $this$withPermit$iv;
                    this.L$1 = obj;
                    this.L$2 = SpillingKt.nullOutSpilledVariable($completion);
                    this.L$3 = lang;
                    this.L$4 = SpillingKt.nullOutSpilledVariable(epQuery);
                    this.label = 2;
                    objSafeGet$default = StreamPlayUtilsKt.safeGet$default(epQuery, map2, str2, null, null, false, 0, this, 120, null);
                    if (objSafeGet$default == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    obj2 = obj;
                    i2 = 0;
                    $completion2 = $completion;
                    i3 = 0;
                    lang2 = lang;
                    epQuery2 = epQuery;
                    responseText = ((NiceResponse) objSafeGet$default).getText();
                    StreamPlayExtractor streamPlayExtractor2 = StreamPlayExtractor.INSTANCE;
                    AppUtils appUtils4 = AppUtils.INSTANCE;
                    if (responseText != null) {
                        Result.Companion companion16 = Result.Companion;
                        KType kTypeTypeOf4 = Reflection.typeOf(EncryptedResponse.class);
                        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                        obj3 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf4));
                        if (Result.exceptionOrNull-impl(obj3) == null) {
                            Result.Companion companion17 = Result.Companion;
                            responseText2 = responseText;
                            i4 = i2;
                            obj3 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(EncryptedResponse.class), (List) null, 2, (Object) null));
                        } else {
                            responseText2 = responseText;
                            i4 = i2;
                        }
                        if (Result.isFailure-impl(obj3)) {
                            obj5 = null;
                        } else {
                            obj5 = obj3;
                        }
                        deserializationStrategy = (KSerializer) obj5;
                        if (deserializationStrategy != null) {
                            value$iv$iv = responseText;
                            objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, value$iv$iv);
                            obj4 = objDecodeFromString;
                        } else {
                            value$iv$iv = responseText;
                        }
                        ObjectMapper $this$readValue$iv$iv$iv8 = MainAPIKt.getMapper();
                        String content$iv$iv$iv8 = value$iv$iv;
                        objDecodeFromString = $this$readValue$iv$iv$iv8.readValue(content$iv$iv$iv8, new TypeReference<EncryptedResponse>() { // from class: com.phisher98.StreamPlayExtractor$invokeAnichi$lambda$1$0$$inlined$tryParseJson$1
                        });
                        obj4 = objDecodeFromString;
                        break;
                    } else {
                        responseText2 = responseText;
                        i4 = i2;
                        obj4 = null;
                    }
                    encryptedResponse = (EncryptedResponse) obj4;
                    if (encryptedResponse != null) {
                        encrypted = null;
                    } else {
                        encrypted = null;
                    }
                    if (encrypted != null) {
                        finalJson = responseText2;
                    } else {
                        finalJson = responseText2;
                    }
                    AppUtils appUtils5 = AppUtils.INSTANCE;
                    value$iv = finalJson;
                    if (value$iv == null) {
                        Result.Companion companion18 = Result.Companion;
                        KType kTypeTypeOf5 = Reflection.typeOf(AnichiEP.class);
                        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                        obj6 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf5));
                        if (Result.exceptionOrNull-impl(obj6) != null) {
                            Result.Companion companion19 = Result.Companion;
                            i5 = i3;
                            encrypted2 = null;
                            obj6 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(AnichiEP.class), (List) null, 2, (Object) null));
                        } else {
                            i5 = i3;
                            encrypted2 = null;
                        }
                        if (Result.isFailure-impl(obj6)) {
                            obj6 = encrypted2;
                        }
                        deserializationStrategy2 = (KSerializer) obj6;
                        if (deserializationStrategy2 != null) {
                            value$iv$iv2 = value$iv;
                            objDecodeFromString2 = MainAPIKt.getJson().decodeFromString(deserializationStrategy2, value$iv$iv2);
                            obj7 = objDecodeFromString2;
                        } else {
                            value$iv$iv2 = value$iv;
                        }
                        ObjectMapper $this$readValue$iv$iv$iv9 = MainAPIKt.getMapper();
                        String content$iv$iv$iv9 = value$iv$iv2;
                        objDecodeFromString2 = $this$readValue$iv$iv$iv9.readValue(content$iv$iv$iv9, new TypeReference<AnichiEP>() { // from class: com.phisher98.StreamPlayExtractor$invokeAnichi$lambda$1$0$$inlined$tryParseJson$2
                        });
                        obj7 = objDecodeFromString2;
                        break;
                    } else {
                        i5 = i3;
                        obj7 = null;
                    }
                    it = (AnichiEP) obj7;
                    if (it != null) {
                        data = it.getData();
                        if (data != null) {
                            episode = it.getEpisode();
                            if (episode != null) {
                                sourceUrls = episode.getSourceUrls();
                            } else {
                                sourceUrls = null;
                            }
                        } else {
                            episode = it.getEpisode();
                            if (episode != null) {
                                sourceUrls = episode.getSourceUrls();
                            } else {
                                sourceUrls = null;
                            }
                        }
                    } else {
                        sourceUrls = null;
                    }
                    if (sourceUrls == null) {
                        unit = Unit.INSTANCE;
                    } else {
                        Iterable $this$safeAmap_u24default$iv4 = sourceUrls;
                        Result.Companion companion110 = Result.Companion;
                        C0121xd854210f c0121xd854210f4 = new C0121xd854210f(7, $this$safeAmap_u24default$iv4, null, lang2, this.$subtitleCallback$inlined, this.$callback$inlined, this.$headers$inlined);
                        this.L$0 = $this$withPermit$iv;
                        this.L$1 = obj2;
                        this.L$2 = SpillingKt.nullOutSpilledVariable($completion2);
                        this.L$3 = SpillingKt.nullOutSpilledVariable(lang2);
                        this.L$4 = SpillingKt.nullOutSpilledVariable(epQuery2);
                        this.L$5 = SpillingKt.nullOutSpilledVariable(responseText2);
                        this.L$6 = SpillingKt.nullOutSpilledVariable(this);
                        this.L$7 = SpillingKt.nullOutSpilledVariable($this$safeAmap_u24default$iv4);
                        this.L$8 = SpillingKt.nullOutSpilledVariable($this$safeAmap_u24default$iv4);
                        this.L$9 = SpillingKt.nullOutSpilledVariable(sourceUrls);
                        this.I$0 = 7;
                        this.label = 3;
                        objCoroutineScope = CoroutineScopeKt.coroutineScope(c0121xd854210f4, this);
                        if (objCoroutineScope == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        $this$withPermit$iv3 = $this$withPermit$iv;
                        lang3 = lang2;
                        obj8 = obj2;
                        i7 = i4;
                        Result.constructor-impl((List) objCoroutineScope);
                        $this$withPermit$iv4 = $this$withPermit$iv3;
                        i8 = i7;
                        i = i8;
                        $this$withPermit$iv2 = $this$withPermit$iv4;
                        obj2 = obj8;
                        $this$withPermit$iv = $this$withPermit$iv2;
                        unit = Unit.INSTANCE;
                    }
                    $this$withPermit$iv.release();
                    return unit;
                case 2:
                    i2 = 0;
                    String epQuery3 = (String) this.L$4;
                    String lang4 = (String) this.L$3;
                    Continuation $completion3 = (Continuation) this.L$2;
                    obj2 = this.L$1;
                    $this$withPermit$iv2 = (Semaphore) this.L$0;
                    try {
                        try {
                            ResultKt.throwOnFailure($result);
                            $i$f$withPermit = 0;
                            epQuery2 = epQuery3;
                            lang2 = lang4;
                            $completion2 = $completion3;
                            $this$withPermit$iv = $this$withPermit$iv2;
                            objSafeGet$default = $result;
                            i3 = 0;
                            responseText = ((NiceResponse) objSafeGet$default).getText();
                            StreamPlayExtractor streamPlayExtractor3 = StreamPlayExtractor.INSTANCE;
                            AppUtils appUtils6 = AppUtils.INSTANCE;
                            if (responseText != null) {
                                responseText2 = responseText;
                                i4 = i2;
                                obj4 = null;
                            } else {
                                Result.Companion companion111 = Result.Companion;
                                KType kTypeTypeOf6 = Reflection.typeOf(EncryptedResponse.class);
                                MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                                obj3 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf6));
                                if (Result.exceptionOrNull-impl(obj3) == null) {
                                    Result.Companion companion112 = Result.Companion;
                                    responseText2 = responseText;
                                    i4 = i2;
                                    obj3 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(EncryptedResponse.class), (List) null, 2, (Object) null));
                                } else {
                                    responseText2 = responseText;
                                    i4 = i2;
                                }
                                if (Result.isFailure-impl(obj3)) {
                                    obj5 = null;
                                } else {
                                    obj5 = obj3;
                                }
                                deserializationStrategy = (KSerializer) obj5;
                                if (deserializationStrategy != null) {
                                    value$iv$iv = responseText;
                                    objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, value$iv$iv);
                                    obj4 = objDecodeFromString;
                                } else {
                                    value$iv$iv = responseText;
                                }
                                ObjectMapper $this$readValue$iv$iv$iv10 = MainAPIKt.getMapper();
                                String content$iv$iv$iv10 = value$iv$iv;
                                objDecodeFromString = $this$readValue$iv$iv$iv10.readValue(content$iv$iv$iv10, new TypeReference<EncryptedResponse>() { // from class: com.phisher98.StreamPlayExtractor$invokeAnichi$lambda$1$0$$inlined$tryParseJson$1
                                });
                                obj4 = objDecodeFromString;
                            }
                            encryptedResponse = (EncryptedResponse) obj4;
                            if (encryptedResponse != null) {
                                encrypted = null;
                            } else {
                                encrypted = null;
                            }
                            if (encrypted != null) {
                                finalJson = responseText2;
                            } else {
                                finalJson = responseText2;
                            }
                            AppUtils appUtils7 = AppUtils.INSTANCE;
                            value$iv = finalJson;
                            if (value$iv == null) {
                                i5 = i3;
                                obj7 = null;
                            } else {
                                Result.Companion companion113 = Result.Companion;
                                KType kTypeTypeOf7 = Reflection.typeOf(AnichiEP.class);
                                MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                                obj6 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf7));
                                if (Result.exceptionOrNull-impl(obj6) != null) {
                                    Result.Companion companion114 = Result.Companion;
                                    i5 = i3;
                                    encrypted2 = null;
                                    obj6 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(AnichiEP.class), (List) null, 2, (Object) null));
                                } else {
                                    i5 = i3;
                                    encrypted2 = null;
                                }
                                if (Result.isFailure-impl(obj6)) {
                                    obj6 = encrypted2;
                                }
                                deserializationStrategy2 = (KSerializer) obj6;
                                if (deserializationStrategy2 != null) {
                                    value$iv$iv2 = value$iv;
                                    objDecodeFromString2 = MainAPIKt.getJson().decodeFromString(deserializationStrategy2, value$iv$iv2);
                                    obj7 = objDecodeFromString2;
                                } else {
                                    value$iv$iv2 = value$iv;
                                }
                                ObjectMapper $this$readValue$iv$iv$iv11 = MainAPIKt.getMapper();
                                String content$iv$iv$iv11 = value$iv$iv2;
                                objDecodeFromString2 = $this$readValue$iv$iv$iv11.readValue(content$iv$iv$iv11, new TypeReference<AnichiEP>() { // from class: com.phisher98.StreamPlayExtractor$invokeAnichi$lambda$1$0$$inlined$tryParseJson$2
                                });
                                obj7 = objDecodeFromString2;
                            }
                            it = (AnichiEP) obj7;
                            if (it != null) {
                                data = it.getData();
                                if (data != null) {
                                    episode = it.getEpisode();
                                    if (episode != null) {
                                        sourceUrls = episode.getSourceUrls();
                                    } else {
                                        sourceUrls = null;
                                    }
                                } else {
                                    episode = it.getEpisode();
                                    if (episode != null) {
                                        sourceUrls = episode.getSourceUrls();
                                    } else {
                                        sourceUrls = null;
                                    }
                                }
                            } else {
                                sourceUrls = null;
                            }
                            if (sourceUrls == null) {
                                unit = Unit.INSTANCE;
                            } else {
                                Iterable $this$safeAmap_u24default$iv5 = sourceUrls;
                                Result.Companion companion115 = Result.Companion;
                                C0121xd854210f c0121xd854210f5 = new C0121xd854210f(7, $this$safeAmap_u24default$iv5, null, lang2, this.$subtitleCallback$inlined, this.$callback$inlined, this.$headers$inlined);
                                this.L$0 = $this$withPermit$iv;
                                this.L$1 = obj2;
                                this.L$2 = SpillingKt.nullOutSpilledVariable($completion2);
                                this.L$3 = SpillingKt.nullOutSpilledVariable(lang2);
                                this.L$4 = SpillingKt.nullOutSpilledVariable(epQuery2);
                                this.L$5 = SpillingKt.nullOutSpilledVariable(responseText2);
                                this.L$6 = SpillingKt.nullOutSpilledVariable(this);
                                this.L$7 = SpillingKt.nullOutSpilledVariable($this$safeAmap_u24default$iv5);
                                this.L$8 = SpillingKt.nullOutSpilledVariable($this$safeAmap_u24default$iv5);
                                this.L$9 = SpillingKt.nullOutSpilledVariable(sourceUrls);
                                this.I$0 = 7;
                                this.label = 3;
                                objCoroutineScope = CoroutineScopeKt.coroutineScope(c0121xd854210f5, this);
                                if (objCoroutineScope == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                $this$withPermit$iv3 = $this$withPermit$iv;
                                lang3 = lang2;
                                obj8 = obj2;
                                i7 = i4;
                                Result.constructor-impl((List) objCoroutineScope);
                                $this$withPermit$iv4 = $this$withPermit$iv3;
                                i8 = i7;
                                i = i8;
                                $this$withPermit$iv2 = $this$withPermit$iv4;
                                obj2 = obj8;
                                $this$withPermit$iv = $this$withPermit$iv2;
                                unit = Unit.INSTANCE;
                            }
                        } catch (Throwable th17) {
                            th = th17;
                            $this$withPermit$iv2.release();
                            throw th;
                        }
                        break;
                    } catch (Exception e14) {
                        e = e14;
                        Log.INSTANCE.e("safeMap", "Request failed for " + obj2 + ' ' + e);
                        $this$withPermit$iv = $this$withPermit$iv2;
                        unit = null;
                        $this$withPermit$iv.release();
                        return unit;
                    }
                    $this$withPermit$iv.release();
                    return unit;
                case 3:
                    i7 = 0;
                    i6 = 0;
                    int i9 = this.I$0;
                    lang3 = (String) this.L$3;
                    $completion2 = (Continuation) this.L$2;
                    obj8 = this.L$1;
                    $this$withPermit$iv3 = (Semaphore) this.L$0;
                    try {
                        ResultKt.throwOnFailure($result);
                        i5 = 0;
                        objCoroutineScope = $result;
                        Result.constructor-impl((List) objCoroutineScope);
                        $this$withPermit$iv4 = $this$withPermit$iv3;
                        i8 = i7;
                    } catch (Throwable th18) {
                        th = th18;
                        Result.Companion companion20 = Result.Companion;
                        Result.constructor-impl(ResultKt.createFailure(th));
                        $this$withPermit$iv4 = $this$withPermit$iv3;
                        i8 = i7;
                        i = i8;
                        $this$withPermit$iv2 = $this$withPermit$iv4;
                        obj2 = obj8;
                        $this$withPermit$iv = $this$withPermit$iv2;
                        unit = Unit.INSTANCE;
                        $this$withPermit$iv.release();
                        return unit;
                    }
                    i = i8;
                    $this$withPermit$iv2 = $this$withPermit$iv4;
                    obj2 = obj8;
                    $this$withPermit$iv = $this$withPermit$iv2;
                    unit = Unit.INSTANCE;
                    $this$withPermit$iv.release();
                    return unit;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
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
                    CoroutineScope $this$coroutineScope2 = $this$coroutineScope;
                    Collection destination$iv$iv2 = destination$iv$iv;
                    $this$coroutineScope = $this$coroutineScope2;
                    destination$iv$iv2.add(BuildersKt.async$default($this$coroutineScope, Dispatchers.getIO(), (CoroutineStart) null, new C01191(semaphore, item$iv$iv, null, this.$isMovie$inlined, this.$dubtype$inlined, this.$id$inlined, this.$episode$inlined, this.$ephash$inlined, this.$headers$inlined, this.$privatereferer$inlined, this.$subtitleCallback$inlined, this.$callback$inlined), 2, (Object) null));
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
