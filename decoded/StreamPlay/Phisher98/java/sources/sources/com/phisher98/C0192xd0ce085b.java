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
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
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
import okhttp3.RequestBody;

/* JADX INFO: renamed from: com.phisher98.StreamPlayExtractor$invokeMultimovies$$inlined$safeAmap$default$1 */
/* JADX INFO: compiled from: StreamPlayUtils.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StreamPlay/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\b\u00028\u00000\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "com/phisher98/StreamPlayUtilsKt$safeAmap$2$1"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.phisher98.StreamPlayExtractor$invokeMultimovies$$inlined$safeAmap$default$1", f = "StreamPlayExtractor.kt", i = {0, 0}, l = {1898}, m = "invokeSuspend", n = {"$this$coroutineScope", "semaphore"}, nl = {-1}, s = {"L$0", "L$1"}, v = 2)
@SourceDebugExtension({"SMAP\nStreamPlayUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,2265:1\n1739#2:2266\n1814#2,3:2267\n*S KotlinDebug\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1\n*L\n1887#1:2266\n1887#1:2267,3\n*E\n"})
public final class C0192xd0ce085b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Object>>, Object> {
    final /* synthetic */ Function1 $callback$inlined;
    final /* synthetic */ int $concurrency;
    final /* synthetic */ String $multimoviesApi$inlined;
    final /* synthetic */ Function1 $subtitleCallback$inlined;
    final /* synthetic */ Iterable $this_runCatching;
    final /* synthetic */ String $url$inlined;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0192xd0ce085b(int i, Iterable iterable, Continuation continuation, String str, String str2, Function1 function1, Function1 function2) {
        super(2, continuation);
        this.$concurrency = i;
        this.$this_runCatching = iterable;
        this.$multimoviesApi$inlined = str;
        this.$url$inlined = str2;
        this.$subtitleCallback$inlined = function1;
        this.$callback$inlined = function2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> c0192xd0ce085b = new C0192xd0ce085b(this.$concurrency, this.$this_runCatching, continuation, this.$multimoviesApi$inlined, this.$url$inlined, this.$subtitleCallback$inlined, this.$callback$inlined);
        c0192xd0ce085b.L$0 = obj;
        return c0192xd0ce085b;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends Object>> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: renamed from: com.phisher98.StreamPlayExtractor$invokeMultimovies$$inlined$safeAmap$default$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: StreamPlayUtils.kt */
    @Metadata(d1 = {"\u0000\n\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", "B", "Lkotlinx/coroutines/CoroutineScope;", "com/phisher98/StreamPlayUtilsKt$safeAmap$2$1$1$1"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StreamPlayExtractor$invokeMultimovies$$inlined$safeAmap$default$1$1", f = "StreamPlayExtractor.kt", i = {0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {2266, 2272, 2319}, m = "invokeSuspend", n = {"$this$withPermit$iv", "$this$withPermit$iv", "$completion", "postId", "nume", "type", "$this$invokeMultimovies_u24lambda_u242_u240", "$this$withPermit$iv", "$completion", "postId", "nume", "type", "$this$invokeMultimovies_u24lambda_u242_u240", "responseData", "embedUrl", "link", "postResponse"}, nl = {2267, 2283, 2327}, s = {"L$0", "L$0", "L$2", "L$3", "L$4", "L$5", "L$6", "L$0", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10"}, v = 2)
    @SourceDebugExtension({"SMAP\nStreamPlayUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1$1$1\n+ 2 Semaphore.kt\nkotlinx/coroutines/sync/SemaphoreKt\n+ 3 StreamPlayExtractor.kt\ncom/phisher98/StreamPlayExtractor\n+ 4 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 5 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 6 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n*L\n1#1,2265:1\n81#2,3:2266\n85#2,2:2329\n151#3,17:2269\n168#3,6:2309\n174#3,13:2316\n93#4,2:2286\n63#4:2288\n64#4,15:2290\n95#4,2:2307\n1#5:2289\n1#5:2315\n50#6:2305\n43#6:2306\n*S KotlinDebug\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1$1$1\n+ 2 StreamPlayExtractor.kt\ncom/phisher98/StreamPlayExtractor\n*L\n1889#1:2266,3\n1889#1:2329,2\n167#2:2286,2\n167#2:2288\n167#2:2290,15\n167#2:2307,2\n167#2:2289\n167#2:2305\n167#2:2306\n*E\n"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Object>, Object> {
        final /* synthetic */ Function1 $callback$inlined;
        final /* synthetic */ Object $item;
        final /* synthetic */ String $multimoviesApi$inlined;
        final /* synthetic */ Semaphore $semaphore;
        final /* synthetic */ Function1 $subtitleCallback$inlined;
        final /* synthetic */ String $url$inlined;
        Object L$0;
        Object L$1;
        Object L$10;
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
        public AnonymousClass1(Semaphore semaphore, Object obj, Continuation continuation, String str, String str2, Function1 function1, Function1 function2) {
            super(2, continuation);
            this.$semaphore = semaphore;
            this.$item = obj;
            this.$multimoviesApi$inlined = str;
            this.$url$inlined = str2;
            this.$subtitleCallback$inlined = function1;
            this.$callback$inlined = function2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$semaphore, this.$item, continuation, this.$multimoviesApi$inlined, this.$url$inlined, this.$subtitleCallback$inlined, this.$callback$inlined);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Object> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:104:0x0370 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:105:0x0371  */
        /* JADX WARN: Code duplicated, block: B:112:0x039e  */
        /* JADX WARN: Code duplicated, block: B:151:0x021b A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:163:0x00ee A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:180:0x0263 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:28:0x00f8 A[Catch: all -> 0x041b, Exception -> 0x041f, TRY_ENTER, TRY_LEAVE, TryCatch #21 {Exception -> 0x041f, all -> 0x041b, blocks: (B:22:0x00c2, B:28:0x00f8), top: B:184:0x00c2 }] */
        /* JADX WARN: Code duplicated, block: B:34:0x01bd A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:35:0x01be  */
        /* JADX WARN: Code duplicated, block: B:38:0x01d5 A[Catch: all -> 0x03b4, TRY_LEAVE, TryCatch #19 {all -> 0x03b4, blocks: (B:36:0x01c9, B:38:0x01d5), top: B:167:0x01c9 }] */
        /* JADX WARN: Code duplicated, block: B:41:0x01e0  */
        /* JADX WARN: Code duplicated, block: B:42:0x01e6  */
        /* JADX WARN: Code duplicated, block: B:49:0x0212  */
        /* JADX WARN: Code duplicated, block: B:66:0x025c  */
        /* JADX WARN: Code duplicated, block: B:76:0x0278 A[Catch: all -> 0x0292, Exception -> 0x02a0, TRY_LEAVE, TryCatch #22 {Exception -> 0x02a0, all -> 0x0292, blocks: (B:64:0x0256, B:67:0x025d, B:76:0x0278, B:75:0x0272, B:63:0x024c), top: B:182:0x024c }] */
        /* JADX WARN: Code duplicated, block: B:91:0x02bd  */
        /* JADX WARN: Code duplicated, block: B:92:0x02c3 A[Catch: all -> 0x0398, TryCatch #21 {all -> 0x0398, blocks: (B:89:0x02b9, B:92:0x02c3, B:98:0x02f7, B:100:0x0306), top: B:171:0x02b9 }] */
        /* JADX WARN: Code duplicated, block: B:94:0x02ec  */
        /* JADX WARN: Code duplicated, block: B:95:0x02ee  */
        /* JADX WARN: Code duplicated, block: B:97:0x02f1 A[ADDED_TO_REGION, REMOVE] */
        /* JADX WARN: Code duplicated, block: B:98:0x02f7 A[Catch: all -> 0x0398, TryCatch #21 {all -> 0x0398, blocks: (B:89:0x02b9, B:92:0x02c3, B:98:0x02f7, B:100:0x0306), top: B:171:0x02b9 }] */
        public final Object invokeSuspend(Object $result) throws Throwable {
            Semaphore $this$withPermit$iv;
            char c;
            int $i$f$withPermit;
            Object obj;
            int i;
            Unit unit;
            Continuation $completion;
            int i2;
            String postId;
            String nume;
            String type;
            Unit unit2;
            StreamPlayExtractor $this$invokeMultimovies_u24lambda_u242_u240;
            int $i$f$withPermit2;
            int i3;
            Semaphore $this$withPermit$iv2;
            Object obj2;
            int i4;
            Object obj3;
            Semaphore $this$withPermit$iv3;
            String type2;
            Object objPost$default;
            StreamPlayExtractor $this$invokeMultimovies_u24lambda_u242_u241;
            Continuation $completion2;
            String nume2;
            String postId2;
            Semaphore $this$withPermit$iv4;
            NiceResponse postResponse;
            String value$iv;
            Object obj4;
            Unit unit3;
            Object obj5;
            Object objDecodeFromString;
            DeserializationStrategy deserializationStrategy;
            ResponseHash responseData;
            String embedUrl;
            Unit unitRemoveSurrounding;
            Unit unit4;
            String str;
            Function1 function1;
            Function1 function2;
            Semaphore $this$withPermit$iv5;
            Object obj6;
            AnonymousClass1 anonymousClass1 = this;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            try {
                switch (anonymousClass1.label) {
                    case 0:
                        c = 3;
                        ResultKt.throwOnFailure($result);
                        Semaphore $this$withPermit$iv6 = anonymousClass1.$semaphore;
                        Object obj7 = anonymousClass1.$item;
                        anonymousClass1.L$0 = $this$withPermit$iv6;
                        anonymousClass1.L$1 = obj7;
                        anonymousClass1.label = 1;
                        if ($this$withPermit$iv6.acquire((Continuation) anonymousClass1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        $i$f$withPermit = 0;
                        obj = obj7;
                        $this$withPermit$iv = $this$withPermit$iv6;
                        i = 0;
                        try {
                            $completion = (Continuation) anonymousClass1;
                            Triple triple = (Triple) obj;
                            i2 = 0;
                            postId = (String) triple.component1();
                            nume = (String) triple.component2();
                            type = (String) triple.component3();
                            if (StringsKt.contains(nume, "trailer", true)) {
                                $this$invokeMultimovies_u24lambda_u242_u240 = StreamPlayExtractor.INSTANCE;
                                try {
                                    Result.Companion companion = Result.Companion;
                                    i4 = 0;
                                    Requests app = MainActivityKt.getApp();
                                    String str2 = anonymousClass1.$multimoviesApi$inlined + "/wp-admin/admin-ajax.php";
                                    Pair[] pairArr = new Pair[4];
                                    pairArr[0] = TuplesKt.to("action", "doo_player_ajax");
                                    pairArr[1] = TuplesKt.to("post", postId);
                                    pairArr[2] = TuplesKt.to("nume", nume);
                                    pairArr[c] = TuplesKt.to("type", type);
                                    Map mapMapOf = MapsKt.mapOf(pairArr);
                                    Map mapMapOf2 = MapsKt.mapOf(TuplesKt.to("X-Requested-With", "XMLHttpRequest"));
                                    String str3 = anonymousClass1.$url$inlined;
                                    anonymousClass1.L$0 = $this$withPermit$iv;
                                    anonymousClass1.L$1 = obj;
                                    anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable($completion);
                                    anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(postId);
                                    anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(nume);
                                    anonymousClass1.L$5 = SpillingKt.nullOutSpilledVariable(type);
                                    anonymousClass1.L$6 = SpillingKt.nullOutSpilledVariable($this$invokeMultimovies_u24lambda_u242_u240);
                                    anonymousClass1.label = 2;
                                    obj3 = obj;
                                    $this$withPermit$iv3 = $this$withPermit$iv;
                                    type2 = type;
                                    try {
                                        objPost$default = Requests.post$default(app, str2, mapMapOf2, str3, (Map) null, (Map) null, mapMapOf, (List) null, (Object) null, (RequestBody) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, this, 65496, (Object) null);
                                        anonymousClass1 = this;
                                        if (objPost$default == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        $this$invokeMultimovies_u24lambda_u242_u241 = $this$invokeMultimovies_u24lambda_u242_u240;
                                        $completion2 = $completion;
                                        nume2 = nume;
                                        postId2 = postId;
                                        $this$withPermit$iv4 = $this$withPermit$iv3;
                                        obj2 = obj3;
                                        try {
                                            try {
                                                postResponse = (NiceResponse) objPost$default;
                                                try {
                                                    if (postResponse.getCode() == 200) {
                                                        AppUtils appUtils = AppUtils.INSTANCE;
                                                        value$iv = postResponse.getText();
                                                        if (value$iv == null) {
                                                            obj4 = coroutine_suspended;
                                                            objDecodeFromString = null;
                                                            unit3 = null;
                                                        } else {
                                                            try {
                                                                try {
                                                                    Result.Companion companion2 = Result.Companion;
                                                                    KType kTypeTypeOf = Reflection.typeOf(ResponseHash.class);
                                                                    MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                                                                    obj5 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                                                                } catch (Throwable th) {
                                                                    Result.Companion companion3 = Result.Companion;
                                                                    obj5 = Result.constructor-impl(ResultKt.createFailure(th));
                                                                }
                                                                if (Result.exceptionOrNull-impl(obj5) == null) {
                                                                    obj4 = coroutine_suspended;
                                                                    unit3 = null;
                                                                } else {
                                                                    try {
                                                                        Result.Companion companion4 = Result.Companion;
                                                                        obj4 = coroutine_suspended;
                                                                        try {
                                                                            unit3 = null;
                                                                            try {
                                                                                obj5 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(ResponseHash.class), (List) null, 2, (Object) null));
                                                                                break;
                                                                            } catch (Throwable th2) {
                                                                                th = th2;
                                                                                try {
                                                                                    Result.Companion companion5 = Result.Companion;
                                                                                    obj5 = Result.constructor-impl(ResultKt.createFailure(th));
                                                                                } catch (Exception e) {
                                                                                    objDecodeFromString = unit3;
                                                                                } catch (Throwable th3) {
                                                                                    th = th3;
                                                                                    unit = unit3;
                                                                                    $this$withPermit$iv2 = $this$withPermit$iv4;
                                                                                    $i$f$withPermit2 = $i$f$withPermit;
                                                                                    i3 = i;
                                                                                }
                                                                            }
                                                                        } catch (Throwable th4) {
                                                                            th = th4;
                                                                            unit3 = null;
                                                                            Result.Companion companion6 = Result.Companion;
                                                                            obj5 = Result.constructor-impl(ResultKt.createFailure(th));
                                                                            if (Result.isFailure-impl(obj5)) {
                                                                                obj5 = unit3;
                                                                            }
                                                                            deserializationStrategy = (KSerializer) obj5;
                                                                            if (deserializationStrategy != null) {
                                                                                try {
                                                                                    objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, value$iv);
                                                                                } catch (SerializationException e2) {
                                                                                    ArchComponentExtKt.logError(e2);
                                                                                    ObjectMapper $this$readValue$iv$iv$iv = MainAPIKt.getMapper();
                                                                                    objDecodeFromString = $this$readValue$iv$iv$iv.readValue(value$iv, new TypeReference<ResponseHash>() { // from class: com.phisher98.StreamPlayExtractor$invokeMultimovies$lambda$2$0$$inlined$tryParseJson$1
                                                                                    });
                                                                                } catch (Throwable th5) {
                                                                                    ObjectMapper $this$readValue$iv$iv$iv2 = MainAPIKt.getMapper();
                                                                                    objDecodeFromString = $this$readValue$iv$iv$iv2.readValue(value$iv, new TypeReference<ResponseHash>() { // from class: com.phisher98.StreamPlayExtractor$invokeMultimovies$lambda$2$0$$inlined$tryParseJson$1
                                                                                    });
                                                                                }
                                                                                break;
                                                                            } else {
                                                                                ObjectMapper $this$readValue$iv$iv$iv3 = MainAPIKt.getMapper();
                                                                                objDecodeFromString = $this$readValue$iv$iv$iv3.readValue(value$iv, new TypeReference<ResponseHash>() { // from class: com.phisher98.StreamPlayExtractor$invokeMultimovies$lambda$2$0$$inlined$tryParseJson$1
                                                                                });
                                                                            }
                                                                            responseData = (ResponseHash) objDecodeFromString;
                                                                            if (responseData == null) {
                                                                                unit = unit3;
                                                                            } else {
                                                                                embedUrl = responseData.getEmbed_url();
                                                                                unitRemoveSurrounding = StringsKt.removeSurrounding(StringsKt.trim(embedUrl).toString(), "\"");
                                                                                if (StringsKt.startsWith$default(unitRemoveSurrounding, "http", false, 2, unit3)) {
                                                                                    unit4 = unitRemoveSurrounding;
                                                                                } else {
                                                                                    unit4 = unit3;
                                                                                }
                                                                                if (unit4 != null) {
                                                                                    unit = unit3;
                                                                                } else {
                                                                                    str = anonymousClass1.$multimoviesApi$inlined + '/';
                                                                                    function1 = anonymousClass1.$subtitleCallback$inlined;
                                                                                    function2 = anonymousClass1.$callback$inlined;
                                                                                    anonymousClass1.L$0 = $this$withPermit$iv4;
                                                                                    anonymousClass1.L$1 = obj2;
                                                                                    anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable($completion2);
                                                                                    anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(postId2);
                                                                                    anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(nume2);
                                                                                    anonymousClass1.L$5 = SpillingKt.nullOutSpilledVariable(type2);
                                                                                    anonymousClass1.L$6 = SpillingKt.nullOutSpilledVariable($this$invokeMultimovies_u24lambda_u242_u241);
                                                                                    anonymousClass1.L$7 = SpillingKt.nullOutSpilledVariable(responseData);
                                                                                    anonymousClass1.L$8 = SpillingKt.nullOutSpilledVariable(embedUrl);
                                                                                    anonymousClass1.L$9 = SpillingKt.nullOutSpilledVariable(unit4);
                                                                                    anonymousClass1.L$10 = SpillingKt.nullOutSpilledVariable(postResponse);
                                                                                    anonymousClass1.label = 3;
                                                                                    unit = unit3;
                                                                                    $this$withPermit$iv5 = $this$withPermit$iv4;
                                                                                    obj6 = obj4;
                                                                                    try {
                                                                                        if (StreamPlayUtilsKt.loadSourceNameExtractor$default("Multimovies", unit4, str, function1, function2, null, null, anonymousClass1, 96, null) == obj6) {
                                                                                            return obj6;
                                                                                        }
                                                                                        $this$withPermit$iv2 = $this$withPermit$iv5;
                                                                                        $i$f$withPermit2 = $i$f$withPermit;
                                                                                        i3 = i;
                                                                                        Result.constructor-impl(Unit.INSTANCE);
                                                                                        $this$withPermit$iv = $this$withPermit$iv2;
                                                                                        obj = obj2;
                                                                                        unit2 = Unit.INSTANCE;
                                                                                        $this$withPermit$iv.release();
                                                                                        return unit2;
                                                                                    } catch (Throwable th6) {
                                                                                        th = th6;
                                                                                        $this$withPermit$iv2 = $this$withPermit$iv5;
                                                                                        $i$f$withPermit2 = $i$f$withPermit;
                                                                                        i3 = i;
                                                                                    }
                                                                                }
                                                                            }
                                                                            $this$withPermit$iv2 = $this$withPermit$iv4;
                                                                            $i$f$withPermit2 = $i$f$withPermit;
                                                                            i3 = i;
                                                                            Result.constructor-impl(Unit.INSTANCE);
                                                                            $this$withPermit$iv = $this$withPermit$iv2;
                                                                            obj = obj2;
                                                                            unit2 = Unit.INSTANCE;
                                                                            $this$withPermit$iv.release();
                                                                            return unit2;
                                                                        }
                                                                    } catch (Throwable th7) {
                                                                        th = th7;
                                                                        obj4 = coroutine_suspended;
                                                                    }
                                                                }
                                                                if (Result.isFailure-impl(obj5)) {
                                                                    obj5 = unit3;
                                                                }
                                                                deserializationStrategy = (KSerializer) obj5;
                                                                if (deserializationStrategy != null) {
                                                                    objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, value$iv);
                                                                } else {
                                                                    ObjectMapper $this$readValue$iv$iv$iv4 = MainAPIKt.getMapper();
                                                                    objDecodeFromString = $this$readValue$iv$iv$iv4.readValue(value$iv, new TypeReference<ResponseHash>() { // from class: com.phisher98.StreamPlayExtractor$invokeMultimovies$lambda$2$0$$inlined$tryParseJson$1
                                                                    });
                                                                }
                                                            } catch (Exception e3) {
                                                                obj4 = coroutine_suspended;
                                                                unit3 = null;
                                                                objDecodeFromString = unit3;
                                                                responseData = (ResponseHash) objDecodeFromString;
                                                                if (responseData == null) {
                                                                    unit = unit3;
                                                                } else {
                                                                    embedUrl = responseData.getEmbed_url();
                                                                    unitRemoveSurrounding = StringsKt.removeSurrounding(StringsKt.trim(embedUrl).toString(), "\"");
                                                                    if (StringsKt.startsWith$default(unitRemoveSurrounding, "http", false, 2, unit3)) {
                                                                        unit4 = unitRemoveSurrounding;
                                                                    } else {
                                                                        unit4 = unit3;
                                                                    }
                                                                    if (unit4 != null) {
                                                                        str = anonymousClass1.$multimoviesApi$inlined + '/';
                                                                        function1 = anonymousClass1.$subtitleCallback$inlined;
                                                                        function2 = anonymousClass1.$callback$inlined;
                                                                        anonymousClass1.L$0 = $this$withPermit$iv4;
                                                                        anonymousClass1.L$1 = obj2;
                                                                        anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable($completion2);
                                                                        anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(postId2);
                                                                        anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(nume2);
                                                                        anonymousClass1.L$5 = SpillingKt.nullOutSpilledVariable(type2);
                                                                        anonymousClass1.L$6 = SpillingKt.nullOutSpilledVariable($this$invokeMultimovies_u24lambda_u242_u241);
                                                                        anonymousClass1.L$7 = SpillingKt.nullOutSpilledVariable(responseData);
                                                                        anonymousClass1.L$8 = SpillingKt.nullOutSpilledVariable(embedUrl);
                                                                        anonymousClass1.L$9 = SpillingKt.nullOutSpilledVariable(unit4);
                                                                        anonymousClass1.L$10 = SpillingKt.nullOutSpilledVariable(postResponse);
                                                                        anonymousClass1.label = 3;
                                                                        unit = unit3;
                                                                        $this$withPermit$iv5 = $this$withPermit$iv4;
                                                                        obj6 = obj4;
                                                                        if (StreamPlayUtilsKt.loadSourceNameExtractor$default("Multimovies", unit4, str, function1, function2, null, null, anonymousClass1, 96, null) == obj6) {
                                                                            return obj6;
                                                                        }
                                                                        $this$withPermit$iv2 = $this$withPermit$iv5;
                                                                        $i$f$withPermit2 = $i$f$withPermit;
                                                                        i3 = i;
                                                                        Result.constructor-impl(Unit.INSTANCE);
                                                                        $this$withPermit$iv = $this$withPermit$iv2;
                                                                        obj = obj2;
                                                                        unit2 = Unit.INSTANCE;
                                                                        $this$withPermit$iv.release();
                                                                        return unit2;
                                                                    }
                                                                    unit = unit3;
                                                                }
                                                                $this$withPermit$iv2 = $this$withPermit$iv4;
                                                                $i$f$withPermit2 = $i$f$withPermit;
                                                                i3 = i;
                                                                Result.constructor-impl(Unit.INSTANCE);
                                                                $this$withPermit$iv = $this$withPermit$iv2;
                                                                obj = obj2;
                                                                unit2 = Unit.INSTANCE;
                                                                $this$withPermit$iv.release();
                                                                return unit2;
                                                            } catch (Throwable th8) {
                                                                th = th8;
                                                                unit = null;
                                                                $this$withPermit$iv2 = $this$withPermit$iv4;
                                                                $i$f$withPermit2 = $i$f$withPermit;
                                                                i3 = i;
                                                            }
                                                        }
                                                        try {
                                                            responseData = (ResponseHash) objDecodeFromString;
                                                            if (responseData == null) {
                                                                unit = unit3;
                                                            } else {
                                                                embedUrl = responseData.getEmbed_url();
                                                                unitRemoveSurrounding = StringsKt.removeSurrounding(StringsKt.trim(embedUrl).toString(), "\"");
                                                                if (StringsKt.startsWith$default(unitRemoveSurrounding, "http", false, 2, unit3)) {
                                                                    unit4 = unitRemoveSurrounding;
                                                                } else {
                                                                    unit4 = unit3;
                                                                }
                                                                try {
                                                                    if (unit4 != null || StringsKt.contains((CharSequence) unit4, "youtube", true)) {
                                                                        unit = unit3;
                                                                    } else {
                                                                        str = anonymousClass1.$multimoviesApi$inlined + '/';
                                                                        function1 = anonymousClass1.$subtitleCallback$inlined;
                                                                        function2 = anonymousClass1.$callback$inlined;
                                                                        anonymousClass1.L$0 = $this$withPermit$iv4;
                                                                        anonymousClass1.L$1 = obj2;
                                                                        anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable($completion2);
                                                                        anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(postId2);
                                                                        anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(nume2);
                                                                        anonymousClass1.L$5 = SpillingKt.nullOutSpilledVariable(type2);
                                                                        anonymousClass1.L$6 = SpillingKt.nullOutSpilledVariable($this$invokeMultimovies_u24lambda_u242_u241);
                                                                        anonymousClass1.L$7 = SpillingKt.nullOutSpilledVariable(responseData);
                                                                        anonymousClass1.L$8 = SpillingKt.nullOutSpilledVariable(embedUrl);
                                                                        anonymousClass1.L$9 = SpillingKt.nullOutSpilledVariable(unit4);
                                                                        anonymousClass1.L$10 = SpillingKt.nullOutSpilledVariable(postResponse);
                                                                        anonymousClass1.label = 3;
                                                                        unit = unit3;
                                                                        $this$withPermit$iv5 = $this$withPermit$iv4;
                                                                        obj6 = obj4;
                                                                        if (StreamPlayUtilsKt.loadSourceNameExtractor$default("Multimovies", unit4, str, function1, function2, null, null, anonymousClass1, 96, null) == obj6) {
                                                                            return obj6;
                                                                        }
                                                                        $this$withPermit$iv2 = $this$withPermit$iv5;
                                                                        $i$f$withPermit2 = $i$f$withPermit;
                                                                        i3 = i;
                                                                        Result.constructor-impl(Unit.INSTANCE);
                                                                        $this$withPermit$iv = $this$withPermit$iv2;
                                                                        obj = obj2;
                                                                        unit2 = Unit.INSTANCE;
                                                                    }
                                                                    Result.Companion companion7 = Result.Companion;
                                                                    Result.constructor-impl(ResultKt.createFailure(th));
                                                                    $this$withPermit$iv = $this$withPermit$iv2;
                                                                    obj = obj2;
                                                                    unit2 = Unit.INSTANCE;
                                                                } catch (Exception e4) {
                                                                    e = e4;
                                                                    $this$withPermit$iv = $this$withPermit$iv2;
                                                                    obj = obj2;
                                                                    Log.INSTANCE.e("safeMap", "Request failed for " + obj + ' ' + e);
                                                                    unit2 = unit;
                                                                    $this$withPermit$iv.release();
                                                                    return unit2;
                                                                } catch (Throwable th9) {
                                                                    th = th9;
                                                                    $this$withPermit$iv = $this$withPermit$iv2;
                                                                    $this$withPermit$iv.release();
                                                                    throw th;
                                                                }
                                                            }
                                                        } catch (Throwable th10) {
                                                            th = th10;
                                                            unit = unit3;
                                                            $this$withPermit$iv2 = $this$withPermit$iv4;
                                                            $i$f$withPermit2 = $i$f$withPermit;
                                                            i3 = i;
                                                        }
                                                    } else {
                                                        unit = null;
                                                    }
                                                    Result.constructor-impl(Unit.INSTANCE);
                                                } catch (Throwable th11) {
                                                    th = th11;
                                                    Result.Companion companion8 = Result.Companion;
                                                    Result.constructor-impl(ResultKt.createFailure(th));
                                                }
                                                $this$withPermit$iv2 = $this$withPermit$iv4;
                                                $i$f$withPermit2 = $i$f$withPermit;
                                                i3 = i;
                                            } catch (Throwable th12) {
                                                th = th12;
                                                unit = null;
                                            }
                                            unit2 = Unit.INSTANCE;
                                        } catch (Exception e5) {
                                            e = e5;
                                            Log.INSTANCE.e("safeMap", "Request failed for " + obj + ' ' + e);
                                            unit2 = unit;
                                        }
                                        $this$withPermit$iv = $this$withPermit$iv2;
                                        obj = obj2;
                                    } catch (Throwable th13) {
                                        th = th13;
                                        unit = null;
                                        $i$f$withPermit2 = $i$f$withPermit;
                                        i3 = 0;
                                        $this$withPermit$iv2 = $this$withPermit$iv3;
                                        obj2 = obj3;
                                    }
                                } catch (Throwable th14) {
                                    th = th14;
                                    Semaphore semaphore = $this$withPermit$iv;
                                    Object obj8 = obj;
                                    unit = null;
                                    $i$f$withPermit2 = $i$f$withPermit;
                                    i3 = 0;
                                    $this$withPermit$iv2 = semaphore;
                                    obj2 = obj8;
                                }
                                break;
                            } else {
                                try {
                                    unit2 = Unit.INSTANCE;
                                } catch (Exception e6) {
                                    e = e6;
                                    unit = null;
                                    Log.INSTANCE.e("safeMap", "Request failed for " + obj + ' ' + e);
                                    unit2 = unit;
                                }
                            }
                        } catch (Exception e7) {
                            e = e7;
                            unit = null;
                        } catch (Throwable th15) {
                            th = th15;
                            $this$withPermit$iv.release();
                            throw th;
                        }
                        $this$withPermit$iv.release();
                        return unit2;
                    case 1:
                        c = 3;
                        Object obj9 = anonymousClass1.L$1;
                        Semaphore $this$withPermit$iv7 = (Semaphore) anonymousClass1.L$0;
                        ResultKt.throwOnFailure($result);
                        obj = obj9;
                        $this$withPermit$iv = $this$withPermit$iv7;
                        $i$f$withPermit = 0;
                        i = 0;
                        $completion = (Continuation) anonymousClass1;
                        Triple triple2 = (Triple) obj;
                        i2 = 0;
                        postId = (String) triple2.component1();
                        nume = (String) triple2.component2();
                        type = (String) triple2.component3();
                        if (StringsKt.contains(nume, "trailer", true)) {
                            $this$invokeMultimovies_u24lambda_u242_u240 = StreamPlayExtractor.INSTANCE;
                            Result.Companion companion9 = Result.Companion;
                            i4 = 0;
                            Requests app2 = MainActivityKt.getApp();
                            String str4 = anonymousClass1.$multimoviesApi$inlined + "/wp-admin/admin-ajax.php";
                            Pair[] pairArr2 = new Pair[4];
                            pairArr2[0] = TuplesKt.to("action", "doo_player_ajax");
                            pairArr2[1] = TuplesKt.to("post", postId);
                            pairArr2[2] = TuplesKt.to("nume", nume);
                            pairArr2[c] = TuplesKt.to("type", type);
                            Map mapMapOf3 = MapsKt.mapOf(pairArr2);
                            Map mapMapOf4 = MapsKt.mapOf(TuplesKt.to("X-Requested-With", "XMLHttpRequest"));
                            String str5 = anonymousClass1.$url$inlined;
                            anonymousClass1.L$0 = $this$withPermit$iv;
                            anonymousClass1.L$1 = obj;
                            anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable($completion);
                            anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(postId);
                            anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(nume);
                            anonymousClass1.L$5 = SpillingKt.nullOutSpilledVariable(type);
                            anonymousClass1.L$6 = SpillingKt.nullOutSpilledVariable($this$invokeMultimovies_u24lambda_u242_u240);
                            anonymousClass1.label = 2;
                            obj3 = obj;
                            $this$withPermit$iv3 = $this$withPermit$iv;
                            type2 = type;
                            objPost$default = Requests.post$default(app2, str4, mapMapOf4, str5, (Map) null, (Map) null, mapMapOf3, (List) null, (Object) null, (RequestBody) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, this, 65496, (Object) null);
                            anonymousClass1 = this;
                            if (objPost$default == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            $this$invokeMultimovies_u24lambda_u242_u241 = $this$invokeMultimovies_u24lambda_u242_u240;
                            $completion2 = $completion;
                            nume2 = nume;
                            postId2 = postId;
                            $this$withPermit$iv4 = $this$withPermit$iv3;
                            obj2 = obj3;
                            postResponse = (NiceResponse) objPost$default;
                            if (postResponse.getCode() == 200) {
                                AppUtils appUtils2 = AppUtils.INSTANCE;
                                value$iv = postResponse.getText();
                                if (value$iv == null) {
                                    obj4 = coroutine_suspended;
                                    objDecodeFromString = null;
                                    unit3 = null;
                                } else {
                                    Result.Companion companion10 = Result.Companion;
                                    KType kTypeTypeOf2 = Reflection.typeOf(ResponseHash.class);
                                    MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                                    obj5 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf2));
                                    if (Result.exceptionOrNull-impl(obj5) == null) {
                                        Result.Companion companion11 = Result.Companion;
                                        obj4 = coroutine_suspended;
                                        unit3 = null;
                                        obj5 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(ResponseHash.class), (List) null, 2, (Object) null));
                                    } else {
                                        obj4 = coroutine_suspended;
                                        unit3 = null;
                                    }
                                    if (Result.isFailure-impl(obj5)) {
                                        obj5 = unit3;
                                    }
                                    deserializationStrategy = (KSerializer) obj5;
                                    if (deserializationStrategy != null) {
                                        objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, value$iv);
                                    } else {
                                        ObjectMapper $this$readValue$iv$iv$iv5 = MainAPIKt.getMapper();
                                        objDecodeFromString = $this$readValue$iv$iv$iv5.readValue(value$iv, new TypeReference<ResponseHash>() { // from class: com.phisher98.StreamPlayExtractor$invokeMultimovies$lambda$2$0$$inlined$tryParseJson$1
                                        });
                                    }
                                }
                                responseData = (ResponseHash) objDecodeFromString;
                                if (responseData == null) {
                                    unit = unit3;
                                } else {
                                    embedUrl = responseData.getEmbed_url();
                                    unitRemoveSurrounding = StringsKt.removeSurrounding(StringsKt.trim(embedUrl).toString(), "\"");
                                    if (StringsKt.startsWith$default(unitRemoveSurrounding, "http", false, 2, unit3)) {
                                        unit4 = unitRemoveSurrounding;
                                    } else {
                                        unit4 = unit3;
                                    }
                                    if (unit4 != null) {
                                        unit = unit3;
                                    } else {
                                        str = anonymousClass1.$multimoviesApi$inlined + '/';
                                        function1 = anonymousClass1.$subtitleCallback$inlined;
                                        function2 = anonymousClass1.$callback$inlined;
                                        anonymousClass1.L$0 = $this$withPermit$iv4;
                                        anonymousClass1.L$1 = obj2;
                                        anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable($completion2);
                                        anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(postId2);
                                        anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(nume2);
                                        anonymousClass1.L$5 = SpillingKt.nullOutSpilledVariable(type2);
                                        anonymousClass1.L$6 = SpillingKt.nullOutSpilledVariable($this$invokeMultimovies_u24lambda_u242_u241);
                                        anonymousClass1.L$7 = SpillingKt.nullOutSpilledVariable(responseData);
                                        anonymousClass1.L$8 = SpillingKt.nullOutSpilledVariable(embedUrl);
                                        anonymousClass1.L$9 = SpillingKt.nullOutSpilledVariable(unit4);
                                        anonymousClass1.L$10 = SpillingKt.nullOutSpilledVariable(postResponse);
                                        anonymousClass1.label = 3;
                                        unit = unit3;
                                        $this$withPermit$iv5 = $this$withPermit$iv4;
                                        obj6 = obj4;
                                        if (StreamPlayUtilsKt.loadSourceNameExtractor$default("Multimovies", unit4, str, function1, function2, null, null, anonymousClass1, 96, null) == obj6) {
                                            return obj6;
                                        }
                                        $this$withPermit$iv2 = $this$withPermit$iv5;
                                        $i$f$withPermit2 = $i$f$withPermit;
                                        i3 = i;
                                        Result.constructor-impl(Unit.INSTANCE);
                                        $this$withPermit$iv = $this$withPermit$iv2;
                                        obj = obj2;
                                        unit2 = Unit.INSTANCE;
                                    }
                                }
                            } else {
                                unit = null;
                            }
                            $this$withPermit$iv2 = $this$withPermit$iv4;
                            $i$f$withPermit2 = $i$f$withPermit;
                            i3 = i;
                            Result.constructor-impl(Unit.INSTANCE);
                            $this$withPermit$iv = $this$withPermit$iv2;
                            obj = obj2;
                            unit2 = Unit.INSTANCE;
                            break;
                        } else {
                            unit2 = Unit.INSTANCE;
                        }
                        $this$withPermit$iv.release();
                        return unit2;
                    case 2:
                        StreamPlayExtractor $this$invokeMultimovies_u24lambda_u242_u242 = (StreamPlayExtractor) anonymousClass1.L$6;
                        String type3 = (String) anonymousClass1.L$5;
                        nume2 = (String) anonymousClass1.L$4;
                        postId2 = (String) anonymousClass1.L$3;
                        $completion2 = (Continuation) anonymousClass1.L$2;
                        obj2 = anonymousClass1.L$1;
                        Semaphore $this$withPermit$iv8 = (Semaphore) anonymousClass1.L$0;
                        try {
                            ResultKt.throwOnFailure($result);
                            i4 = 0;
                            $i$f$withPermit = 0;
                            i = 0;
                            i2 = 0;
                            type2 = type3;
                            $this$invokeMultimovies_u24lambda_u242_u241 = $this$invokeMultimovies_u24lambda_u242_u242;
                            $this$withPermit$iv4 = $this$withPermit$iv8;
                            objPost$default = $result;
                            postResponse = (NiceResponse) objPost$default;
                            if (postResponse.getCode() == 200) {
                                AppUtils appUtils3 = AppUtils.INSTANCE;
                                value$iv = postResponse.getText();
                                if (value$iv == null) {
                                    obj4 = coroutine_suspended;
                                    objDecodeFromString = null;
                                    unit3 = null;
                                } else {
                                    Result.Companion companion12 = Result.Companion;
                                    KType kTypeTypeOf3 = Reflection.typeOf(ResponseHash.class);
                                    MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                                    obj5 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf3));
                                    if (Result.exceptionOrNull-impl(obj5) == null) {
                                        Result.Companion companion13 = Result.Companion;
                                        obj4 = coroutine_suspended;
                                        unit3 = null;
                                        obj5 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(ResponseHash.class), (List) null, 2, (Object) null));
                                    } else {
                                        obj4 = coroutine_suspended;
                                        unit3 = null;
                                    }
                                    if (Result.isFailure-impl(obj5)) {
                                        obj5 = unit3;
                                    }
                                    deserializationStrategy = (KSerializer) obj5;
                                    if (deserializationStrategy != null) {
                                        objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, value$iv);
                                    } else {
                                        ObjectMapper $this$readValue$iv$iv$iv6 = MainAPIKt.getMapper();
                                        objDecodeFromString = $this$readValue$iv$iv$iv6.readValue(value$iv, new TypeReference<ResponseHash>() { // from class: com.phisher98.StreamPlayExtractor$invokeMultimovies$lambda$2$0$$inlined$tryParseJson$1
                                        });
                                    }
                                }
                                responseData = (ResponseHash) objDecodeFromString;
                                if (responseData == null) {
                                    unit = unit3;
                                } else {
                                    embedUrl = responseData.getEmbed_url();
                                    unitRemoveSurrounding = StringsKt.removeSurrounding(StringsKt.trim(embedUrl).toString(), "\"");
                                    if (StringsKt.startsWith$default(unitRemoveSurrounding, "http", false, 2, unit3)) {
                                        unit4 = unitRemoveSurrounding;
                                    } else {
                                        unit4 = unit3;
                                    }
                                    if (unit4 != null) {
                                        str = anonymousClass1.$multimoviesApi$inlined + '/';
                                        function1 = anonymousClass1.$subtitleCallback$inlined;
                                        function2 = anonymousClass1.$callback$inlined;
                                        anonymousClass1.L$0 = $this$withPermit$iv4;
                                        anonymousClass1.L$1 = obj2;
                                        anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable($completion2);
                                        anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(postId2);
                                        anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(nume2);
                                        anonymousClass1.L$5 = SpillingKt.nullOutSpilledVariable(type2);
                                        anonymousClass1.L$6 = SpillingKt.nullOutSpilledVariable($this$invokeMultimovies_u24lambda_u242_u241);
                                        anonymousClass1.L$7 = SpillingKt.nullOutSpilledVariable(responseData);
                                        anonymousClass1.L$8 = SpillingKt.nullOutSpilledVariable(embedUrl);
                                        anonymousClass1.L$9 = SpillingKt.nullOutSpilledVariable(unit4);
                                        anonymousClass1.L$10 = SpillingKt.nullOutSpilledVariable(postResponse);
                                        anonymousClass1.label = 3;
                                        unit = unit3;
                                        $this$withPermit$iv5 = $this$withPermit$iv4;
                                        obj6 = obj4;
                                        if (StreamPlayUtilsKt.loadSourceNameExtractor$default("Multimovies", unit4, str, function1, function2, null, null, anonymousClass1, 96, null) == obj6) {
                                            return obj6;
                                        }
                                        $this$withPermit$iv2 = $this$withPermit$iv5;
                                        $i$f$withPermit2 = $i$f$withPermit;
                                        i3 = i;
                                        Result.constructor-impl(Unit.INSTANCE);
                                        $this$withPermit$iv = $this$withPermit$iv2;
                                        obj = obj2;
                                        unit2 = Unit.INSTANCE;
                                        $this$withPermit$iv.release();
                                        return unit2;
                                    }
                                    unit = unit3;
                                }
                            } else {
                                unit = null;
                            }
                            $this$withPermit$iv2 = $this$withPermit$iv4;
                            $i$f$withPermit2 = $i$f$withPermit;
                            i3 = i;
                            Result.constructor-impl(Unit.INSTANCE);
                            break;
                        } catch (Throwable th16) {
                            th = th16;
                            $i$f$withPermit2 = 0;
                            unit = null;
                            $this$withPermit$iv2 = $this$withPermit$iv8;
                            i3 = 0;
                            break;
                        }
                        $this$withPermit$iv = $this$withPermit$iv2;
                        obj = obj2;
                        unit2 = Unit.INSTANCE;
                        $this$withPermit$iv.release();
                        return unit2;
                    case 3:
                        $i$f$withPermit2 = 0;
                        i3 = 0;
                        obj2 = anonymousClass1.L$1;
                        $this$withPermit$iv2 = (Semaphore) anonymousClass1.L$0;
                        try {
                            ResultKt.throwOnFailure($result);
                            unit = null;
                            Result.constructor-impl(Unit.INSTANCE);
                            break;
                        } catch (Throwable th17) {
                            th = th17;
                            unit = null;
                            break;
                        }
                        $this$withPermit$iv = $this$withPermit$iv2;
                        obj = obj2;
                        unit2 = Unit.INSTANCE;
                        $this$withPermit$iv.release();
                        return unit2;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } catch (Throwable th18) {
                th = th18;
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
                    destination$iv$iv2.add(BuildersKt.async$default($this$coroutineScope, Dispatchers.getIO(), (CoroutineStart) null, new AnonymousClass1(semaphore, item$iv$iv, null, this.$multimoviesApi$inlined, this.$url$inlined, this.$subtitleCallback$inlined, this.$callback$inlined), 2, (Object) null));
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
