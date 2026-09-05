package com.phisher98;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fleeksoft.ksoup.Ksoup;
import com.lagradost.api.Log;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.extractors.helper.AesHelper;
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

/* JADX INFO: compiled from: StreamPlayUtils.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StreamPlay/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\b\u00028\u00000\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "com/phisher98/StreamPlayUtilsKt$safeAmap$2$1"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.phisher98.StreamPlayExtractor$invokeWpmovies$$inlined$safeAmap$default$1", f = "StreamPlayExtractor.kt", i = {0, 0}, l = {1898}, m = "invokeSuspend", n = {"$this$coroutineScope", "semaphore"}, nl = {-1}, s = {"L$0", "L$1"}, v = 2)
@SourceDebugExtension({"SMAP\nStreamPlayUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,2265:1\n1739#2:2266\n1814#2,3:2267\n*S KotlinDebug\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1\n*L\n1887#1:2266\n1887#1:2267,3\n*E\n"})
public final class StreamPlayExtractor$invokeWpmovies$$inlined$safeAmap$default$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Unit>>, Object> {
    final /* synthetic */ Function1 $callback$inlined;
    final /* synthetic */ int $concurrency;
    final /* synthetic */ boolean $encrypt$inlined;
    final /* synthetic */ boolean $fixIframe$inlined;
    final /* synthetic */ boolean $hasCloudflare$inlined;
    final /* synthetic */ Interceptor $interceptor$inlined;
    final /* synthetic */ String $name$inlined;
    final /* synthetic */ String $referer$inlined;
    final /* synthetic */ Function1 $subtitleCallback$inlined;
    final /* synthetic */ Iterable $this_runCatching;
    final /* synthetic */ String $url$inlined;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StreamPlayExtractor$invokeWpmovies$$inlined$safeAmap$default$1(int i, Iterable iterable, Continuation continuation, String str, String str2, boolean z, Interceptor interceptor, String str3, Function1 function1, Function1 function2, boolean z2, boolean z3) {
        super(2, continuation);
        this.$concurrency = i;
        this.$this_runCatching = iterable;
        this.$referer$inlined = str;
        this.$url$inlined = str2;
        this.$hasCloudflare$inlined = z;
        this.$interceptor$inlined = interceptor;
        this.$name$inlined = str3;
        this.$subtitleCallback$inlined = function1;
        this.$callback$inlined = function2;
        this.$encrypt$inlined = z2;
        this.$fixIframe$inlined = z3;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> streamPlayExtractor$invokeWpmovies$$inlined$safeAmap$default$1 = new StreamPlayExtractor$invokeWpmovies$$inlined$safeAmap$default$1(this.$concurrency, this.$this_runCatching, continuation, this.$referer$inlined, this.$url$inlined, this.$hasCloudflare$inlined, this.$interceptor$inlined, this.$name$inlined, this.$subtitleCallback$inlined, this.$callback$inlined, this.$encrypt$inlined, this.$fixIframe$inlined);
        streamPlayExtractor$invokeWpmovies$$inlined$safeAmap$default$1.L$0 = obj;
        return streamPlayExtractor$invokeWpmovies$$inlined$safeAmap$default$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends Unit>> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: renamed from: com.phisher98.StreamPlayExtractor$invokeWpmovies$$inlined$safeAmap$default$1$1 */
    /* JADX INFO: compiled from: StreamPlayUtils.kt */
    @Metadata(d1 = {"\u0000\n\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", "B", "Lkotlinx/coroutines/CoroutineScope;", "com/phisher98/StreamPlayUtilsKt$safeAmap$2$1$1$1"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StreamPlayExtractor$invokeWpmovies$$inlined$safeAmap$default$1$1", f = "StreamPlayExtractor.kt", i = {0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3}, l = {2266, 2269, 2336, 2349}, m = "invokeSuspend", n = {"$this$withPermit$iv", "$this$withPermit$iv", "$completion", "id", "nume", "type", "$this$withPermit$iv", "$completion", "id", "nume", "type", "it", "json", "key", "meta", "$this$withPermit$iv", "$completion", "id", "nume", "type", "source", "json"}, nl = {2267, 2284, 2340, 2359}, s = {"L$0", "L$0", "L$2", "L$3", "L$4", "L$5", "L$0", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$0", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7"}, v = 2)
    @SourceDebugExtension({"SMAP\nStreamPlayUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1$1$1\n+ 2 Semaphore.kt\nkotlinx/coroutines/sync/SemaphoreKt\n+ 3 StreamPlayExtractor.kt\ncom/phisher98/StreamPlayExtractor\n+ 4 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 5 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 6 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n*L\n1#1,2265:1\n81#2,3:2266\n85#2,2:2360\n232#3,16:2269\n248#3,4:2308\n252#3,25:2335\n93#4,2:2285\n63#4:2287\n64#4,15:2289\n95#4,2:2306\n93#4,2:2312\n63#4:2314\n64#4,15:2316\n95#4,2:2333\n1#5:2288\n1#5:2315\n50#6:2304\n43#6:2305\n50#6:2331\n43#6:2332\n*S KotlinDebug\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1$1$1\n+ 2 StreamPlayExtractor.kt\ncom/phisher98/StreamPlayExtractor\n*L\n1889#1:2266,3\n1889#1:2360,2\n247#2:2285,2\n247#2:2287\n247#2:2289,15\n247#2:2306,2\n251#2:2312,2\n251#2:2314\n251#2:2316,15\n251#2:2333,2\n247#2:2288\n251#2:2315\n247#2:2304\n247#2:2305\n251#2:2331\n251#2:2332\n*E\n"})
    public static final class C02311 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1 $callback$inlined;
        final /* synthetic */ boolean $encrypt$inlined;
        final /* synthetic */ boolean $fixIframe$inlined;
        final /* synthetic */ boolean $hasCloudflare$inlined;
        final /* synthetic */ Interceptor $interceptor$inlined;
        final /* synthetic */ Object $item;
        final /* synthetic */ String $name$inlined;
        final /* synthetic */ String $referer$inlined;
        final /* synthetic */ Semaphore $semaphore;
        final /* synthetic */ Function1 $subtitleCallback$inlined;
        final /* synthetic */ String $url$inlined;
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
        public C02311(Semaphore semaphore, Object obj, Continuation continuation, String str, String str2, boolean z, Interceptor interceptor, String str3, Function1 function1, Function1 function2, boolean z2, boolean z3) {
            super(2, continuation);
            this.$semaphore = semaphore;
            this.$item = obj;
            this.$referer$inlined = str;
            this.$url$inlined = str2;
            this.$hasCloudflare$inlined = z;
            this.$interceptor$inlined = interceptor;
            this.$name$inlined = str3;
            this.$subtitleCallback$inlined = function1;
            this.$callback$inlined = function2;
            this.$encrypt$inlined = z2;
            this.$fixIframe$inlined = z3;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C02311(this.$semaphore, this.$item, continuation, this.$referer$inlined, this.$url$inlined, this.$hasCloudflare$inlined, this.$interceptor$inlined, this.$name$inlined, this.$subtitleCallback$inlined, this.$callback$inlined, this.$encrypt$inlined, this.$fixIframe$inlined);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:101:0x02e6 A[Catch: Exception -> 0x046d, all -> 0x0553, TRY_ENTER, TRY_LEAVE, TryCatch #1 {Exception -> 0x046d, blocks: (B:101:0x02e6, B:147:0x03ad, B:149:0x03b1, B:171:0x0468, B:152:0x03bd, B:154:0x03c4, B:155:0x03c9, B:178:0x0481), top: B:231:0x02e4 }] */
        /* JADX WARN: Code duplicated, block: B:104:0x02f1  */
        /* JADX WARN: Code duplicated, block: B:105:0x02f4  */
        /* JADX WARN: Code duplicated, block: B:112:0x0320  */
        /* JADX WARN: Code duplicated, block: B:128:0x036d  */
        /* JADX WARN: Code duplicated, block: B:138:0x0389 A[Catch: Exception -> 0x03a2, all -> 0x0553, TRY_LEAVE, TryCatch #12 {Exception -> 0x03a2, blocks: (B:126:0x0367, B:129:0x036e, B:138:0x0389, B:137:0x0383, B:125:0x035d), top: B:242:0x035d }] */
        /* JADX WARN: Code duplicated, block: B:149:0x03b1 A[Catch: Exception -> 0x046d, all -> 0x0553, TryCatch #1 {Exception -> 0x046d, blocks: (B:101:0x02e6, B:147:0x03ad, B:149:0x03b1, B:171:0x0468, B:152:0x03bd, B:154:0x03c4, B:155:0x03c9, B:178:0x0481), top: B:231:0x02e4 }] */
        /* JADX WARN: Code duplicated, block: B:170:0x0464 A[ADDED_TO_REGION, REMOVE] */
        /* JADX WARN: Code duplicated, block: B:175:0x0476  */
        /* JADX WARN: Code duplicated, block: B:178:0x0481 A[Catch: Exception -> 0x046d, all -> 0x0553, TRY_ENTER, TRY_LEAVE, TryCatch #1 {Exception -> 0x046d, blocks: (B:101:0x02e6, B:147:0x03ad, B:149:0x03b1, B:171:0x0468, B:152:0x03bd, B:154:0x03c4, B:155:0x03c9, B:178:0x0481), top: B:231:0x02e4 }] */
        /* JADX WARN: Code duplicated, block: B:180:0x049a A[Catch: all -> 0x0553, Exception -> 0x0558, TRY_ENTER, TryCatch #22 {Exception -> 0x0558, blocks: (B:185:0x04ae, B:189:0x04bf, B:50:0x020b, B:97:0x02db, B:99:0x02df, B:176:0x047d, B:180:0x049a), top: B:249:0x020b }] */
        /* JADX WARN: Code duplicated, block: B:183:0x04a2  */
        /* JADX WARN: Code duplicated, block: B:185:0x04ae A[Catch: all -> 0x0553, Exception -> 0x0558, TRY_LEAVE, TryCatch #22 {Exception -> 0x0558, blocks: (B:185:0x04ae, B:189:0x04bf, B:50:0x020b, B:97:0x02db, B:99:0x02df, B:176:0x047d, B:180:0x049a), top: B:249:0x020b }] */
        /* JADX WARN: Code duplicated, block: B:189:0x04bf A[Catch: all -> 0x0553, Exception -> 0x0558, TRY_ENTER, TRY_LEAVE, TryCatch #22 {Exception -> 0x0558, blocks: (B:185:0x04ae, B:189:0x04bf, B:50:0x020b, B:97:0x02db, B:99:0x02df, B:176:0x047d, B:180:0x049a), top: B:249:0x020b }] */
        /* JADX WARN: Code duplicated, block: B:195:0x0520 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:196:0x0521  */
        /* JADX WARN: Code duplicated, block: B:200:0x0536 A[Catch: Exception -> 0x053c, all -> 0x0553, TRY_LEAVE, TryCatch #30 {all -> 0x0553, blocks: (B:185:0x04ae, B:187:0x04b8, B:189:0x04bf, B:191:0x0506, B:193:0x051a, B:200:0x0536, B:50:0x020b, B:97:0x02db, B:99:0x02df, B:101:0x02e6, B:147:0x03ad, B:149:0x03b1, B:171:0x0468, B:152:0x03bd, B:154:0x03c4, B:155:0x03c9, B:110:0x031a, B:126:0x0367, B:129:0x036e, B:138:0x0389, B:137:0x0383, B:125:0x035d, B:109:0x0310, B:176:0x047d, B:178:0x0481, B:180:0x049a, B:59:0x0249, B:76:0x0293, B:79:0x029a, B:88:0x02b5, B:87:0x02af, B:75:0x0289, B:58:0x023f), top: B:249:0x020b }] */
        /* JADX WARN: Code duplicated, block: B:206:0x0542  */
        /* JADX WARN: Code duplicated, block: B:245:0x0258 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:264:0x0328 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:270:0x02a0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:276:0x0374 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:280:0x0184 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:41:0x0198  */
        /* JADX WARN: Code duplicated, block: B:48:0x01ff A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:49:0x0200  */
        /* JADX WARN: Code duplicated, block: B:53:0x021b  */
        /* JADX WARN: Code duplicated, block: B:54:0x0222  */
        /* JADX WARN: Code duplicated, block: B:61:0x024f  */
        /* JADX WARN: Code duplicated, block: B:78:0x0299  */
        /* JADX WARN: Code duplicated, block: B:88:0x02b5 A[Catch: Exception -> 0x02d0, all -> 0x0553, TRY_LEAVE, TryCatch #15 {Exception -> 0x02d0, blocks: (B:76:0x0293, B:79:0x029a, B:88:0x02b5, B:87:0x02af, B:75:0x0289), top: B:247:0x0289 }] */
        /* JADX WARN: Code duplicated, block: B:99:0x02df A[Catch: all -> 0x0553, Exception -> 0x0558, TRY_LEAVE, TryCatch #22 {Exception -> 0x0558, blocks: (B:185:0x04ae, B:189:0x04bf, B:50:0x020b, B:97:0x02db, B:99:0x02df, B:176:0x047d, B:180:0x049a), top: B:249:0x020b }] */
        public final Object invokeSuspend(Object $result) throws Throwable {
            Semaphore $this$withPermit$iv;
            char c;
            char c2;
            Object obj;
            int $i$f$withPermit;
            Semaphore $this$withPermit$iv2;
            int i;
            Object obj2;
            int $i$f$withPermit2;
            int $i$f$withPermit3;
            Object obj3;
            Continuation $completion;
            int i2;
            String id;
            String nume;
            String type;
            Interceptor interceptor;
            Semaphore $this$withPermit$iv3;
            Object obj4;
            Object objPost$default;
            Continuation $completion2;
            String type2;
            String id2;
            String nume2;
            NiceResponse json;
            String value$iv;
            Object obj5;
            Object obj6;
            String id3;
            Object obj7;
            String id4;
            DeserializationStrategy deserializationStrategy;
            Object objDecodeFromString;
            ResponseHash it;
            Continuation $completion3;
            Object obj8;
            int i3;
            String source;
            String value$iv2;
            Object obj9;
            Object objDecodeFromString2;
            DeserializationStrategy deserializationStrategy2;
            ZShowEmbed zShowEmbed;
            Object obj10;
            String meta;
            Object objCryptoAESHandler$default;
            Object obj11;
            Semaphore $this$withPermit$iv4;
            String id5;
            NiceResponse json2;
            Object obj12;
            Object objLoadDisplaySourceNameExtractor$default;
            Object obj13;
            String str;
            String strInvokeWpmovies$fixBloat;
            C02311 c02311 = this;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            try {
                switch (c02311.label) {
                    case 0:
                        c = 0;
                        c2 = 2;
                        ResultKt.throwOnFailure($result);
                        Semaphore $this$withPermit$iv5 = c02311.$semaphore;
                        obj = c02311.$item;
                        c02311.L$0 = $this$withPermit$iv5;
                        c02311.L$1 = obj;
                        c02311.label = 1;
                        if ($this$withPermit$iv5.acquire((Continuation) c02311) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        $i$f$withPermit = 0;
                        $this$withPermit$iv2 = $this$withPermit$iv5;
                        i = 0;
                        try {
                            $completion = (Continuation) c02311;
                            Triple triple = (Triple) obj;
                            i2 = 0;
                            id = (String) triple.component1();
                            nume = (String) triple.component2();
                            type = (String) triple.component3();
                            Requests app = MainActivityKt.getApp();
                            String str2 = c02311.$referer$inlined + "/wp-admin/admin-ajax.php";
                            Pair[] pairArr = new Pair[4];
                            pairArr[c] = TuplesKt.to("action", "doo_player_ajax");
                            pairArr[1] = TuplesKt.to("post", id);
                            pairArr[c2] = TuplesKt.to("nume", nume);
                            pairArr[3] = TuplesKt.to("type", type);
                            Map mapMapOf = MapsKt.mapOf(pairArr);
                            Pair[] pairArr2 = new Pair[2];
                            pairArr2[c] = TuplesKt.to("Accept", "*/*");
                            pairArr2[1] = TuplesKt.to("X-Requested-With", "XMLHttpRequest");
                            Map mapMapOf2 = MapsKt.mapOf(pairArr2);
                            String str3 = c02311.$url$inlined;
                            if (c02311.$hasCloudflare$inlined) {
                                try {
                                    interceptor = c02311.$interceptor$inlined;
                                } catch (Exception e) {
                                    e = e;
                                    obj3 = obj;
                                    $this$withPermit$iv = $this$withPermit$iv2;
                                    $i$f$withPermit2 = $i$f$withPermit;
                                    $i$f$withPermit3 = 0;
                                    obj2 = null;
                                    Log.INSTANCE.e("safeMap", "Request failed for " + obj3 + ' ' + e);
                                    obj10 = obj2;
                                    $this$withPermit$iv.release();
                                    return obj10;
                                } catch (Throwable th) {
                                    th = th;
                                    $this$withPermit$iv = $this$withPermit$iv2;
                                    $this$withPermit$iv.release();
                                    throw th;
                                }
                            } else {
                                interceptor = null;
                            }
                            c02311.L$0 = $this$withPermit$iv2;
                            c02311.L$1 = obj;
                            c02311.L$2 = SpillingKt.nullOutSpilledVariable($completion);
                            c02311.L$3 = SpillingKt.nullOutSpilledVariable(id);
                            c02311.L$4 = SpillingKt.nullOutSpilledVariable(nume);
                            c02311.L$5 = SpillingKt.nullOutSpilledVariable(type);
                            c02311.label = 2;
                            $this$withPermit$iv3 = $this$withPermit$iv2;
                            obj4 = obj;
                            obj2 = null;
                            try {
                                objPost$default = Requests.post$default(app, str2, mapMapOf2, str3, (Map) null, (Map) null, mapMapOf, (List) null, (Object) null, (RequestBody) null, false, 0, (TimeUnit) null, 0L, interceptor, false, (ResponseParser) null, this, 57304, (Object) null);
                                c02311 = this;
                                if (objPost$default == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                $completion2 = $completion;
                                obj3 = obj4;
                                type2 = type;
                                id2 = id;
                                $this$withPermit$iv = $this$withPermit$iv3;
                                nume2 = nume;
                                try {
                                    try {
                                        json = (NiceResponse) objPost$default;
                                        AppUtils appUtils = AppUtils.INSTANCE;
                                        value$iv = json.getText();
                                        if (value$iv != null) {
                                            obj6 = coroutine_suspended;
                                            id3 = id2;
                                            obj7 = null;
                                        } else {
                                            try {
                                                Result.Companion companion = Result.Companion;
                                                KType kTypeTypeOf = Reflection.typeOf(ResponseHash.class);
                                                MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                                                obj5 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                                                break;
                                            } catch (Throwable th2) {
                                                try {
                                                    Result.Companion companion2 = Result.Companion;
                                                    obj5 = Result.constructor-impl(ResultKt.createFailure(th2));
                                                } catch (Exception e2) {
                                                    obj6 = coroutine_suspended;
                                                    id3 = id2;
                                                    obj7 = null;
                                                    it = (ResponseHash) obj7;
                                                    if (it != null) {
                                                        try {
                                                            if (c02311.$encrypt$inlined) {
                                                                AppUtils appUtils2 = AppUtils.INSTANCE;
                                                                value$iv2 = it.getEmbed_url();
                                                                if (value$iv2 == null) {
                                                                    objDecodeFromString2 = null;
                                                                } else {
                                                                    try {
                                                                        Result.Companion companion3 = Result.Companion;
                                                                        KType kTypeTypeOf2 = Reflection.typeOf(ZShowEmbed.class);
                                                                        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                                                                        obj9 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf2));
                                                                        break;
                                                                    } catch (Throwable th3) {
                                                                        try {
                                                                            Result.Companion companion4 = Result.Companion;
                                                                            obj9 = Result.constructor-impl(ResultKt.createFailure(th3));
                                                                        } catch (Exception e3) {
                                                                            objDecodeFromString2 = null;
                                                                            zShowEmbed = (ZShowEmbed) objDecodeFromString2;
                                                                            if (zShowEmbed != null) {
                                                                            }
                                                                            obj10 = Unit.INSTANCE;
                                                                            $this$withPermit$iv.release();
                                                                            return obj10;
                                                                        }
                                                                    }
                                                                    if (Result.exceptionOrNull-impl(obj9) != null) {
                                                                        try {
                                                                            Result.Companion companion5 = Result.Companion;
                                                                            try {
                                                                                try {
                                                                                    obj9 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(ZShowEmbed.class), (List) null, 2, (Object) null));
                                                                                    break;
                                                                                } catch (Throwable th4) {
                                                                                    th = th4;
                                                                                    try {
                                                                                        Result.Companion companion6 = Result.Companion;
                                                                                        obj9 = Result.constructor-impl(ResultKt.createFailure(th));
                                                                                    } catch (Exception e4) {
                                                                                        objDecodeFromString2 = null;
                                                                                    }
                                                                                }
                                                                            } catch (Throwable th5) {
                                                                                th = th5;
                                                                            }
                                                                        } catch (Throwable th6) {
                                                                            th = th6;
                                                                        }
                                                                    }
                                                                    if (Result.isFailure-impl(obj9)) {
                                                                        obj9 = null;
                                                                    }
                                                                    deserializationStrategy2 = (KSerializer) obj9;
                                                                    if (deserializationStrategy2 != null) {
                                                                        try {
                                                                            objDecodeFromString2 = MainAPIKt.getJson().decodeFromString(deserializationStrategy2, value$iv2);
                                                                        } catch (SerializationException e5) {
                                                                            ArchComponentExtKt.logError(e5);
                                                                            ObjectMapper $this$readValue$iv$iv$iv = MainAPIKt.getMapper();
                                                                            objDecodeFromString2 = $this$readValue$iv$iv$iv.readValue(value$iv2, new TypeReference<ZShowEmbed>() { // from class: com.phisher98.StreamPlayExtractor$invokeWpmovies$lambda$1$0$$inlined$tryParseJson$1
                                                                            });
                                                                        } catch (Throwable th7) {
                                                                            ObjectMapper $this$readValue$iv$iv$iv2 = MainAPIKt.getMapper();
                                                                            objDecodeFromString2 = $this$readValue$iv$iv$iv2.readValue(value$iv2, new TypeReference<ZShowEmbed>() { // from class: com.phisher98.StreamPlayExtractor$invokeWpmovies$lambda$1$0$$inlined$tryParseJson$1
                                                                            });
                                                                        }
                                                                    } else {
                                                                        ObjectMapper $this$readValue$iv$iv$iv3 = MainAPIKt.getMapper();
                                                                        objDecodeFromString2 = $this$readValue$iv$iv$iv3.readValue(value$iv2, new TypeReference<ZShowEmbed>() { // from class: com.phisher98.StreamPlayExtractor$invokeWpmovies$lambda$1$0$$inlined$tryParseJson$1
                                                                        });
                                                                    }
                                                                }
                                                                zShowEmbed = (ZShowEmbed) objDecodeFromString2;
                                                                if (zShowEmbed != null) {
                                                                }
                                                                obj10 = Unit.INSTANCE;
                                                                break;
                                                            } else {
                                                                $completion3 = $completion2;
                                                                obj8 = obj6;
                                                                i3 = 2;
                                                                if (c02311.$fixIframe$inlined) {
                                                                    source = Ksoup.parse$default(Ksoup.INSTANCE, it.getEmbed_url(), (String) null, 2, (Object) null).select("IFRAME").attr("SRC");
                                                                } else {
                                                                    source = it.getEmbed_url();
                                                                }
                                                                if (source == null) {
                                                                    obj2 = null;
                                                                    $i$f$withPermit2 = $i$f$withPermit;
                                                                    $i$f$withPermit3 = i;
                                                                    try {
                                                                        obj10 = Unit.INSTANCE;
                                                                    } catch (Exception e6) {
                                                                        e = e6;
                                                                        Log.INSTANCE.e("safeMap", "Request failed for " + obj3 + ' ' + e);
                                                                        obj10 = obj2;
                                                                    }
                                                                } else {
                                                                    try {
                                                                        try {
                                                                            if (StringsKt.contains$default(source, "youtube", false, i3, (Object) null)) {
                                                                                obj10 = Unit.INSTANCE;
                                                                            } else {
                                                                                String str4 = c02311.$name$inlined;
                                                                                String str5 = c02311.$name$inlined;
                                                                                String str6 = c02311.$referer$inlined + '/';
                                                                                Function1 function1 = c02311.$subtitleCallback$inlined;
                                                                                Function1 function2 = c02311.$callback$inlined;
                                                                                c02311.L$0 = $this$withPermit$iv;
                                                                                c02311.L$1 = obj3;
                                                                                c02311.L$2 = SpillingKt.nullOutSpilledVariable($completion3);
                                                                                c02311.L$3 = SpillingKt.nullOutSpilledVariable(id3);
                                                                                c02311.L$4 = SpillingKt.nullOutSpilledVariable(nume2);
                                                                                c02311.L$5 = SpillingKt.nullOutSpilledVariable(type2);
                                                                                c02311.L$6 = SpillingKt.nullOutSpilledVariable(source);
                                                                                c02311.L$7 = SpillingKt.nullOutSpilledVariable(json);
                                                                                try {
                                                                                    c02311.L$8 = null;
                                                                                    c02311.L$9 = null;
                                                                                    c02311.label = 4;
                                                                                    obj12 = obj8;
                                                                                    objLoadDisplaySourceNameExtractor$default = StreamPlayUtilsKt.loadDisplaySourceNameExtractor$default(str4, str5, source, str6, function1, function2, null, this, 64, null);
                                                                                    if (objLoadDisplaySourceNameExtractor$default == obj12) {
                                                                                        return obj12;
                                                                                    }
                                                                                    obj13 = objLoadDisplaySourceNameExtractor$default;
                                                                                    $i$f$withPermit3 = i;
                                                                                    obj10 = obj13;
                                                                                } catch (Exception e7) {
                                                                                    e = e7;
                                                                                    obj2 = null;
                                                                                    $i$f$withPermit2 = $i$f$withPermit;
                                                                                    $i$f$withPermit3 = i;
                                                                                    Log.INSTANCE.e("safeMap", "Request failed for " + obj3 + ' ' + e);
                                                                                    obj10 = obj2;
                                                                                }
                                                                            }
                                                                        } catch (Exception e8) {
                                                                            e = e8;
                                                                        }
                                                                    } catch (Exception e9) {
                                                                        e = e9;
                                                                        obj2 = null;
                                                                    }
                                                                }
                                                            }
                                                        } catch (Exception e10) {
                                                            e = e10;
                                                            $i$f$withPermit2 = $i$f$withPermit;
                                                            $i$f$withPermit3 = i;
                                                            obj2 = null;
                                                            Log.INSTANCE.e("safeMap", "Request failed for " + obj3 + ' ' + e);
                                                            obj10 = obj2;
                                                            $this$withPermit$iv.release();
                                                            return obj10;
                                                        }
                                                    } else {
                                                        obj2 = null;
                                                        $i$f$withPermit2 = $i$f$withPermit;
                                                        $i$f$withPermit3 = i;
                                                        obj10 = Unit.INSTANCE;
                                                    }
                                                    $this$withPermit$iv.release();
                                                    return obj10;
                                                }
                                            }
                                            if (Result.exceptionOrNull-impl(obj5) == null) {
                                                obj6 = coroutine_suspended;
                                                id3 = id2;
                                                id4 = null;
                                            } else {
                                                try {
                                                    Result.Companion companion7 = Result.Companion;
                                                    obj6 = coroutine_suspended;
                                                    try {
                                                        id3 = id2;
                                                        id4 = null;
                                                        try {
                                                            obj5 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(ResponseHash.class), (List) null, 2, (Object) null));
                                                            break;
                                                        } catch (Throwable th8) {
                                                            th = th8;
                                                            try {
                                                                Result.Companion companion8 = Result.Companion;
                                                                obj5 = Result.constructor-impl(ResultKt.createFailure(th));
                                                            } catch (Exception e11) {
                                                                obj7 = null;
                                                            }
                                                        }
                                                    } catch (Throwable th9) {
                                                        th = th9;
                                                        id3 = id2;
                                                        id4 = null;
                                                        Result.Companion companion9 = Result.Companion;
                                                        obj5 = Result.constructor-impl(ResultKt.createFailure(th));
                                                        if (Result.isFailure-impl(obj5)) {
                                                            obj5 = id4;
                                                        }
                                                        deserializationStrategy = (KSerializer) obj5;
                                                        if (deserializationStrategy != null) {
                                                            try {
                                                                objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, value$iv);
                                                            } catch (SerializationException e12) {
                                                                ArchComponentExtKt.logError(e12);
                                                                ObjectMapper $this$readValue$iv$iv$iv4 = MainAPIKt.getMapper();
                                                                objDecodeFromString = $this$readValue$iv$iv$iv4.readValue(value$iv, new TypeReference<ResponseHash>() { // from class: com.phisher98.StreamPlayExtractor$invokeWpmovies$lambda$1$$inlined$tryParseJson$1
                                                                });
                                                            } catch (Throwable th10) {
                                                                ObjectMapper $this$readValue$iv$iv$iv5 = MainAPIKt.getMapper();
                                                                objDecodeFromString = $this$readValue$iv$iv$iv5.readValue(value$iv, new TypeReference<ResponseHash>() { // from class: com.phisher98.StreamPlayExtractor$invokeWpmovies$lambda$1$$inlined$tryParseJson$1
                                                                });
                                                            }
                                                            break;
                                                        } else {
                                                            ObjectMapper $this$readValue$iv$iv$iv6 = MainAPIKt.getMapper();
                                                            objDecodeFromString = $this$readValue$iv$iv$iv6.readValue(value$iv, new TypeReference<ResponseHash>() { // from class: com.phisher98.StreamPlayExtractor$invokeWpmovies$lambda$1$$inlined$tryParseJson$1
                                                            });
                                                        }
                                                        obj7 = objDecodeFromString;
                                                        it = (ResponseHash) obj7;
                                                        if (it != null) {
                                                            obj2 = null;
                                                            $i$f$withPermit2 = $i$f$withPermit;
                                                            $i$f$withPermit3 = i;
                                                            obj10 = Unit.INSTANCE;
                                                        } else if (c02311.$encrypt$inlined) {
                                                            AppUtils appUtils3 = AppUtils.INSTANCE;
                                                            value$iv2 = it.getEmbed_url();
                                                            if (value$iv2 == null) {
                                                                objDecodeFromString2 = null;
                                                            } else {
                                                                Result.Companion companion10 = Result.Companion;
                                                                KType kTypeTypeOf3 = Reflection.typeOf(ZShowEmbed.class);
                                                                MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                                                                obj9 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf3));
                                                                if (Result.exceptionOrNull-impl(obj9) != null) {
                                                                    Result.Companion companion11 = Result.Companion;
                                                                    obj9 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(ZShowEmbed.class), (List) null, 2, (Object) null));
                                                                    break;
                                                                }
                                                                if (Result.isFailure-impl(obj9)) {
                                                                    obj9 = null;
                                                                }
                                                                deserializationStrategy2 = (KSerializer) obj9;
                                                                if (deserializationStrategy2 != null) {
                                                                    objDecodeFromString2 = MainAPIKt.getJson().decodeFromString(deserializationStrategy2, value$iv2);
                                                                } else {
                                                                    ObjectMapper $this$readValue$iv$iv$iv7 = MainAPIKt.getMapper();
                                                                    objDecodeFromString2 = $this$readValue$iv$iv$iv7.readValue(value$iv2, new TypeReference<ZShowEmbed>() { // from class: com.phisher98.StreamPlayExtractor$invokeWpmovies$lambda$1$0$$inlined$tryParseJson$1
                                                                    });
                                                                }
                                                            }
                                                            zShowEmbed = (ZShowEmbed) objDecodeFromString2;
                                                            if (zShowEmbed != null) {
                                                            }
                                                            obj10 = Unit.INSTANCE;
                                                            break;
                                                        } else {
                                                            $completion3 = $completion2;
                                                            obj8 = obj6;
                                                            i3 = 2;
                                                            if (c02311.$fixIframe$inlined) {
                                                                source = Ksoup.parse$default(Ksoup.INSTANCE, it.getEmbed_url(), (String) null, 2, (Object) null).select("IFRAME").attr("SRC");
                                                            } else {
                                                                source = it.getEmbed_url();
                                                            }
                                                            if (source == null) {
                                                                obj2 = null;
                                                                $i$f$withPermit2 = $i$f$withPermit;
                                                                $i$f$withPermit3 = i;
                                                                obj10 = Unit.INSTANCE;
                                                            } else if (StringsKt.contains$default(source, "youtube", false, i3, (Object) null)) {
                                                                String str7 = c02311.$name$inlined;
                                                                String str8 = c02311.$name$inlined;
                                                                String str9 = c02311.$referer$inlined + '/';
                                                                Function1 function3 = c02311.$subtitleCallback$inlined;
                                                                Function1 function4 = c02311.$callback$inlined;
                                                                c02311.L$0 = $this$withPermit$iv;
                                                                c02311.L$1 = obj3;
                                                                c02311.L$2 = SpillingKt.nullOutSpilledVariable($completion3);
                                                                c02311.L$3 = SpillingKt.nullOutSpilledVariable(id3);
                                                                c02311.L$4 = SpillingKt.nullOutSpilledVariable(nume2);
                                                                c02311.L$5 = SpillingKt.nullOutSpilledVariable(type2);
                                                                c02311.L$6 = SpillingKt.nullOutSpilledVariable(source);
                                                                c02311.L$7 = SpillingKt.nullOutSpilledVariable(json);
                                                                c02311.L$8 = null;
                                                                c02311.L$9 = null;
                                                                c02311.label = 4;
                                                                obj12 = obj8;
                                                                objLoadDisplaySourceNameExtractor$default = StreamPlayUtilsKt.loadDisplaySourceNameExtractor$default(str7, str8, source, str9, function3, function4, null, this, 64, null);
                                                                if (objLoadDisplaySourceNameExtractor$default == obj12) {
                                                                    return obj12;
                                                                }
                                                                obj13 = objLoadDisplaySourceNameExtractor$default;
                                                                $i$f$withPermit3 = i;
                                                                obj10 = obj13;
                                                            } else {
                                                                obj10 = Unit.INSTANCE;
                                                            }
                                                        }
                                                        $this$withPermit$iv.release();
                                                        return obj10;
                                                    }
                                                } catch (Throwable th11) {
                                                    th = th11;
                                                    obj6 = coroutine_suspended;
                                                }
                                            }
                                            if (Result.isFailure-impl(obj5)) {
                                                obj5 = id4;
                                            }
                                            deserializationStrategy = (KSerializer) obj5;
                                            if (deserializationStrategy != null) {
                                                objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, value$iv);
                                            } else {
                                                ObjectMapper $this$readValue$iv$iv$iv8 = MainAPIKt.getMapper();
                                                objDecodeFromString = $this$readValue$iv$iv$iv8.readValue(value$iv, new TypeReference<ResponseHash>() { // from class: com.phisher98.StreamPlayExtractor$invokeWpmovies$lambda$1$$inlined$tryParseJson$1
                                                });
                                            }
                                            obj7 = objDecodeFromString;
                                        }
                                        it = (ResponseHash) obj7;
                                        if (it != null) {
                                            obj2 = null;
                                            $i$f$withPermit2 = $i$f$withPermit;
                                            $i$f$withPermit3 = i;
                                            obj10 = Unit.INSTANCE;
                                        } else if (c02311.$encrypt$inlined) {
                                            AppUtils appUtils4 = AppUtils.INSTANCE;
                                            value$iv2 = it.getEmbed_url();
                                            if (value$iv2 == null) {
                                                objDecodeFromString2 = null;
                                            } else {
                                                Result.Companion companion12 = Result.Companion;
                                                KType kTypeTypeOf4 = Reflection.typeOf(ZShowEmbed.class);
                                                MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                                                obj9 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf4));
                                                if (Result.exceptionOrNull-impl(obj9) != null) {
                                                    Result.Companion companion13 = Result.Companion;
                                                    obj9 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(ZShowEmbed.class), (List) null, 2, (Object) null));
                                                    break;
                                                }
                                                if (Result.isFailure-impl(obj9)) {
                                                    obj9 = null;
                                                }
                                                deserializationStrategy2 = (KSerializer) obj9;
                                                if (deserializationStrategy2 != null) {
                                                    objDecodeFromString2 = MainAPIKt.getJson().decodeFromString(deserializationStrategy2, value$iv2);
                                                } else {
                                                    ObjectMapper $this$readValue$iv$iv$iv9 = MainAPIKt.getMapper();
                                                    objDecodeFromString2 = $this$readValue$iv$iv$iv9.readValue(value$iv2, new TypeReference<ZShowEmbed>() { // from class: com.phisher98.StreamPlayExtractor$invokeWpmovies$lambda$1$0$$inlined$tryParseJson$1
                                                    });
                                                }
                                            }
                                            zShowEmbed = (ZShowEmbed) objDecodeFromString2;
                                            if (zShowEmbed != null || (meta = zShowEmbed.getMeta()) == null) {
                                                obj10 = Unit.INSTANCE;
                                            } else {
                                                String key = it.getKey();
                                                if (key == null) {
                                                    obj10 = Unit.INSTANCE;
                                                } else {
                                                    String key2 = StreamPlayUtilsKt.generateWpKey(key, meta);
                                                    AesHelper aesHelper = AesHelper.INSTANCE;
                                                    String meta2 = it.getEmbed_url();
                                                    byte[] bArrEncodeToByteArray = StringsKt.encodeToByteArray(key2);
                                                    c02311.L$0 = $this$withPermit$iv;
                                                    c02311.L$1 = obj3;
                                                    c02311.L$2 = SpillingKt.nullOutSpilledVariable($completion2);
                                                    c02311.L$3 = SpillingKt.nullOutSpilledVariable(id3);
                                                    c02311.L$4 = SpillingKt.nullOutSpilledVariable(nume2);
                                                    c02311.L$5 = SpillingKt.nullOutSpilledVariable(type2);
                                                    c02311.L$6 = SpillingKt.nullOutSpilledVariable(it);
                                                    c02311.L$7 = SpillingKt.nullOutSpilledVariable(json);
                                                    c02311.L$8 = SpillingKt.nullOutSpilledVariable(key2);
                                                    c02311.L$9 = SpillingKt.nullOutSpilledVariable(meta);
                                                    c02311.label = 3;
                                                    $completion3 = $completion2;
                                                    obj8 = obj6;
                                                    i3 = 2;
                                                    objCryptoAESHandler$default = AesHelper.cryptoAESHandler$default(aesHelper, meta2, bArrEncodeToByteArray, false, false, c02311, 8, (Object) null);
                                                    if (objCryptoAESHandler$default == obj8) {
                                                        return obj8;
                                                    }
                                                    obj11 = obj3;
                                                    $this$withPermit$iv4 = $this$withPermit$iv;
                                                    id5 = id3;
                                                    $i$f$withPermit2 = $i$f$withPermit;
                                                    $i$f$withPermit3 = i;
                                                    json2 = json;
                                                    try {
                                                        str = (String) objCryptoAESHandler$default;
                                                        if (str != null || (strInvokeWpmovies$fixBloat = StreamPlayExtractor.invokeWpmovies$fixBloat(str)) == null) {
                                                            obj10 = Unit.INSTANCE;
                                                            $this$withPermit$iv = $this$withPermit$iv4;
                                                        } else {
                                                            $i$f$withPermit = $i$f$withPermit2;
                                                            i = $i$f$withPermit3;
                                                            id3 = id5;
                                                            obj3 = obj11;
                                                            json = json2;
                                                            source = strInvokeWpmovies$fixBloat;
                                                            $this$withPermit$iv = $this$withPermit$iv4;
                                                            if (source == null) {
                                                                obj2 = null;
                                                                $i$f$withPermit2 = $i$f$withPermit;
                                                                $i$f$withPermit3 = i;
                                                                obj10 = Unit.INSTANCE;
                                                            } else if (StringsKt.contains$default(source, "youtube", false, i3, (Object) null)) {
                                                                String str10 = c02311.$name$inlined;
                                                                String str11 = c02311.$name$inlined;
                                                                String str12 = c02311.$referer$inlined + '/';
                                                                Function1 function5 = c02311.$subtitleCallback$inlined;
                                                                Function1 function6 = c02311.$callback$inlined;
                                                                c02311.L$0 = $this$withPermit$iv;
                                                                c02311.L$1 = obj3;
                                                                c02311.L$2 = SpillingKt.nullOutSpilledVariable($completion3);
                                                                c02311.L$3 = SpillingKt.nullOutSpilledVariable(id3);
                                                                c02311.L$4 = SpillingKt.nullOutSpilledVariable(nume2);
                                                                c02311.L$5 = SpillingKt.nullOutSpilledVariable(type2);
                                                                c02311.L$6 = SpillingKt.nullOutSpilledVariable(source);
                                                                c02311.L$7 = SpillingKt.nullOutSpilledVariable(json);
                                                                c02311.L$8 = null;
                                                                c02311.L$9 = null;
                                                                c02311.label = 4;
                                                                obj12 = obj8;
                                                                objLoadDisplaySourceNameExtractor$default = StreamPlayUtilsKt.loadDisplaySourceNameExtractor$default(str10, str11, source, str12, function5, function6, null, this, 64, null);
                                                                if (objLoadDisplaySourceNameExtractor$default == obj12) {
                                                                    return obj12;
                                                                }
                                                                obj13 = objLoadDisplaySourceNameExtractor$default;
                                                                $i$f$withPermit3 = i;
                                                                obj10 = obj13;
                                                            } else {
                                                                obj10 = Unit.INSTANCE;
                                                            }
                                                        }
                                                    } catch (Exception e13) {
                                                        e = e13;
                                                        $this$withPermit$iv = $this$withPermit$iv4;
                                                        obj3 = obj11;
                                                        obj2 = null;
                                                        Log.INSTANCE.e("safeMap", "Request failed for " + obj3 + ' ' + e);
                                                        obj10 = obj2;
                                                        $this$withPermit$iv.release();
                                                        return obj10;
                                                    } catch (Throwable th12) {
                                                        th = th12;
                                                        $this$withPermit$iv = $this$withPermit$iv4;
                                                        $this$withPermit$iv.release();
                                                        throw th;
                                                    }
                                                }
                                            }
                                            break;
                                        } else {
                                            $completion3 = $completion2;
                                            obj8 = obj6;
                                            i3 = 2;
                                            if (c02311.$fixIframe$inlined) {
                                                source = Ksoup.parse$default(Ksoup.INSTANCE, it.getEmbed_url(), (String) null, 2, (Object) null).select("IFRAME").attr("SRC");
                                            } else {
                                                source = it.getEmbed_url();
                                            }
                                            if (source == null) {
                                                obj2 = null;
                                                $i$f$withPermit2 = $i$f$withPermit;
                                                $i$f$withPermit3 = i;
                                                obj10 = Unit.INSTANCE;
                                            } else if (StringsKt.contains$default(source, "youtube", false, i3, (Object) null)) {
                                                String str13 = c02311.$name$inlined;
                                                String str14 = c02311.$name$inlined;
                                                String str15 = c02311.$referer$inlined + '/';
                                                Function1 function7 = c02311.$subtitleCallback$inlined;
                                                Function1 function8 = c02311.$callback$inlined;
                                                c02311.L$0 = $this$withPermit$iv;
                                                c02311.L$1 = obj3;
                                                c02311.L$2 = SpillingKt.nullOutSpilledVariable($completion3);
                                                c02311.L$3 = SpillingKt.nullOutSpilledVariable(id3);
                                                c02311.L$4 = SpillingKt.nullOutSpilledVariable(nume2);
                                                c02311.L$5 = SpillingKt.nullOutSpilledVariable(type2);
                                                c02311.L$6 = SpillingKt.nullOutSpilledVariable(source);
                                                c02311.L$7 = SpillingKt.nullOutSpilledVariable(json);
                                                c02311.L$8 = null;
                                                c02311.L$9 = null;
                                                c02311.label = 4;
                                                obj12 = obj8;
                                                objLoadDisplaySourceNameExtractor$default = StreamPlayUtilsKt.loadDisplaySourceNameExtractor$default(str13, str14, source, str15, function7, function8, null, this, 64, null);
                                                if (objLoadDisplaySourceNameExtractor$default == obj12) {
                                                    return obj12;
                                                }
                                                obj13 = objLoadDisplaySourceNameExtractor$default;
                                                $i$f$withPermit3 = i;
                                                obj10 = obj13;
                                            } else {
                                                obj10 = Unit.INSTANCE;
                                            }
                                        }
                                        break;
                                    } catch (Exception e14) {
                                        e = e14;
                                        obj2 = null;
                                        $i$f$withPermit2 = $i$f$withPermit;
                                        $i$f$withPermit3 = i;
                                        Log.INSTANCE.e("safeMap", "Request failed for " + obj3 + ' ' + e);
                                        obj10 = obj2;
                                        $this$withPermit$iv.release();
                                        return obj10;
                                    }
                                    $this$withPermit$iv.release();
                                    return obj10;
                                } catch (Throwable th13) {
                                    th = th13;
                                    $this$withPermit$iv.release();
                                    throw th;
                                }
                            } catch (Exception e15) {
                                e = e15;
                                obj2 = null;
                                $i$f$withPermit2 = $i$f$withPermit;
                                $i$f$withPermit3 = 0;
                                obj3 = obj4;
                                $this$withPermit$iv = $this$withPermit$iv3;
                                Log.INSTANCE.e("safeMap", "Request failed for " + obj3 + ' ' + e);
                                obj10 = obj2;
                                $this$withPermit$iv.release();
                                return obj10;
                            } catch (Throwable th14) {
                                th = th14;
                                $this$withPermit$iv = $this$withPermit$iv3;
                                $this$withPermit$iv.release();
                                throw th;
                            }
                        } catch (Exception e16) {
                            e = e16;
                            obj2 = null;
                            $i$f$withPermit2 = $i$f$withPermit;
                            $i$f$withPermit3 = 0;
                            obj3 = obj;
                            $this$withPermit$iv = $this$withPermit$iv2;
                        } catch (Throwable th15) {
                            th = th15;
                            $this$withPermit$iv = $this$withPermit$iv2;
                        }
                        break;
                        break;
                    case 1:
                        c = 0;
                        c2 = 2;
                        obj = c02311.L$1;
                        $this$withPermit$iv2 = (Semaphore) c02311.L$0;
                        ResultKt.throwOnFailure($result);
                        $i$f$withPermit = 0;
                        i = 0;
                        $completion = (Continuation) c02311;
                        Triple triple2 = (Triple) obj;
                        i2 = 0;
                        id = (String) triple2.component1();
                        nume = (String) triple2.component2();
                        type = (String) triple2.component3();
                        Requests app2 = MainActivityKt.getApp();
                        String str16 = c02311.$referer$inlined + "/wp-admin/admin-ajax.php";
                        Pair[] pairArr3 = new Pair[4];
                        pairArr3[c] = TuplesKt.to("action", "doo_player_ajax");
                        pairArr3[1] = TuplesKt.to("post", id);
                        pairArr3[c2] = TuplesKt.to("nume", nume);
                        pairArr3[3] = TuplesKt.to("type", type);
                        Map mapMapOf3 = MapsKt.mapOf(pairArr3);
                        Pair[] pairArr4 = new Pair[2];
                        pairArr4[c] = TuplesKt.to("Accept", "*/*");
                        pairArr4[1] = TuplesKt.to("X-Requested-With", "XMLHttpRequest");
                        Map mapMapOf4 = MapsKt.mapOf(pairArr4);
                        String str17 = c02311.$url$inlined;
                        if (c02311.$hasCloudflare$inlined) {
                            interceptor = c02311.$interceptor$inlined;
                            break;
                        } else {
                            interceptor = null;
                        }
                        c02311.L$0 = $this$withPermit$iv2;
                        c02311.L$1 = obj;
                        c02311.L$2 = SpillingKt.nullOutSpilledVariable($completion);
                        c02311.L$3 = SpillingKt.nullOutSpilledVariable(id);
                        c02311.L$4 = SpillingKt.nullOutSpilledVariable(nume);
                        c02311.L$5 = SpillingKt.nullOutSpilledVariable(type);
                        c02311.label = 2;
                        $this$withPermit$iv3 = $this$withPermit$iv2;
                        obj4 = obj;
                        obj2 = null;
                        objPost$default = Requests.post$default(app2, str16, mapMapOf4, str17, (Map) null, (Map) null, mapMapOf3, (List) null, (Object) null, (RequestBody) null, false, 0, (TimeUnit) null, 0L, interceptor, false, (ResponseParser) null, this, 57304, (Object) null);
                        c02311 = this;
                        if (objPost$default == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        $completion2 = $completion;
                        obj3 = obj4;
                        type2 = type;
                        id2 = id;
                        $this$withPermit$iv = $this$withPermit$iv3;
                        nume2 = nume;
                        json = (NiceResponse) objPost$default;
                        AppUtils appUtils5 = AppUtils.INSTANCE;
                        value$iv = json.getText();
                        if (value$iv != null) {
                            Result.Companion companion14 = Result.Companion;
                            KType kTypeTypeOf5 = Reflection.typeOf(ResponseHash.class);
                            MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                            obj5 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf5));
                            if (Result.exceptionOrNull-impl(obj5) == null) {
                                Result.Companion companion15 = Result.Companion;
                                obj6 = coroutine_suspended;
                                id3 = id2;
                                id4 = null;
                                obj5 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(ResponseHash.class), (List) null, 2, (Object) null));
                            } else {
                                obj6 = coroutine_suspended;
                                id3 = id2;
                                id4 = null;
                            }
                            if (Result.isFailure-impl(obj5)) {
                                obj5 = id4;
                            }
                            deserializationStrategy = (KSerializer) obj5;
                            if (deserializationStrategy != null) {
                                objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, value$iv);
                            } else {
                                ObjectMapper $this$readValue$iv$iv$iv10 = MainAPIKt.getMapper();
                                objDecodeFromString = $this$readValue$iv$iv$iv10.readValue(value$iv, new TypeReference<ResponseHash>() { // from class: com.phisher98.StreamPlayExtractor$invokeWpmovies$lambda$1$$inlined$tryParseJson$1
                                });
                            }
                            obj7 = objDecodeFromString;
                            break;
                        } else {
                            obj6 = coroutine_suspended;
                            id3 = id2;
                            obj7 = null;
                        }
                        it = (ResponseHash) obj7;
                        if (it != null) {
                            obj2 = null;
                            $i$f$withPermit2 = $i$f$withPermit;
                            $i$f$withPermit3 = i;
                            obj10 = Unit.INSTANCE;
                        } else if (c02311.$encrypt$inlined) {
                            AppUtils appUtils6 = AppUtils.INSTANCE;
                            value$iv2 = it.getEmbed_url();
                            if (value$iv2 == null) {
                                objDecodeFromString2 = null;
                            } else {
                                Result.Companion companion16 = Result.Companion;
                                KType kTypeTypeOf6 = Reflection.typeOf(ZShowEmbed.class);
                                MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                                obj9 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf6));
                                if (Result.exceptionOrNull-impl(obj9) != null) {
                                    Result.Companion companion17 = Result.Companion;
                                    obj9 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(ZShowEmbed.class), (List) null, 2, (Object) null));
                                    break;
                                }
                                if (Result.isFailure-impl(obj9)) {
                                    obj9 = null;
                                }
                                deserializationStrategy2 = (KSerializer) obj9;
                                if (deserializationStrategy2 != null) {
                                    objDecodeFromString2 = MainAPIKt.getJson().decodeFromString(deserializationStrategy2, value$iv2);
                                } else {
                                    ObjectMapper $this$readValue$iv$iv$iv11 = MainAPIKt.getMapper();
                                    objDecodeFromString2 = $this$readValue$iv$iv$iv11.readValue(value$iv2, new TypeReference<ZShowEmbed>() { // from class: com.phisher98.StreamPlayExtractor$invokeWpmovies$lambda$1$0$$inlined$tryParseJson$1
                                    });
                                }
                            }
                            zShowEmbed = (ZShowEmbed) objDecodeFromString2;
                            if (zShowEmbed != null) {
                            }
                            obj10 = Unit.INSTANCE;
                            break;
                        } else {
                            $completion3 = $completion2;
                            obj8 = obj6;
                            i3 = 2;
                            if (c02311.$fixIframe$inlined) {
                                source = Ksoup.parse$default(Ksoup.INSTANCE, it.getEmbed_url(), (String) null, 2, (Object) null).select("IFRAME").attr("SRC");
                            } else {
                                source = it.getEmbed_url();
                            }
                            if (source == null) {
                                obj2 = null;
                                $i$f$withPermit2 = $i$f$withPermit;
                                $i$f$withPermit3 = i;
                                obj10 = Unit.INSTANCE;
                            } else if (StringsKt.contains$default(source, "youtube", false, i3, (Object) null)) {
                                String str18 = c02311.$name$inlined;
                                String str19 = c02311.$name$inlined;
                                String str110 = c02311.$referer$inlined + '/';
                                Function1 function9 = c02311.$subtitleCallback$inlined;
                                Function1 function10 = c02311.$callback$inlined;
                                c02311.L$0 = $this$withPermit$iv;
                                c02311.L$1 = obj3;
                                c02311.L$2 = SpillingKt.nullOutSpilledVariable($completion3);
                                c02311.L$3 = SpillingKt.nullOutSpilledVariable(id3);
                                c02311.L$4 = SpillingKt.nullOutSpilledVariable(nume2);
                                c02311.L$5 = SpillingKt.nullOutSpilledVariable(type2);
                                c02311.L$6 = SpillingKt.nullOutSpilledVariable(source);
                                c02311.L$7 = SpillingKt.nullOutSpilledVariable(json);
                                c02311.L$8 = null;
                                c02311.L$9 = null;
                                c02311.label = 4;
                                obj12 = obj8;
                                objLoadDisplaySourceNameExtractor$default = StreamPlayUtilsKt.loadDisplaySourceNameExtractor$default(str18, str19, source, str110, function9, function10, null, this, 64, null);
                                if (objLoadDisplaySourceNameExtractor$default == obj12) {
                                    return obj12;
                                }
                                obj13 = objLoadDisplaySourceNameExtractor$default;
                                $i$f$withPermit3 = i;
                                obj10 = obj13;
                            } else {
                                obj10 = Unit.INSTANCE;
                            }
                        }
                        $this$withPermit$iv.release();
                        return obj10;
                    case 2:
                        String type3 = (String) c02311.L$5;
                        String nume3 = (String) c02311.L$4;
                        id2 = (String) c02311.L$3;
                        $completion2 = (Continuation) c02311.L$2;
                        obj3 = c02311.L$1;
                        $this$withPermit$iv = (Semaphore) c02311.L$0;
                        try {
                            ResultKt.throwOnFailure($result);
                            objPost$default = $result;
                            i2 = 0;
                            $i$f$withPermit = 0;
                            i = 0;
                            type2 = type3;
                            nume2 = nume3;
                            json = (NiceResponse) objPost$default;
                            AppUtils appUtils7 = AppUtils.INSTANCE;
                            value$iv = json.getText();
                            if (value$iv != null) {
                                obj6 = coroutine_suspended;
                                id3 = id2;
                                obj7 = null;
                            } else {
                                Result.Companion companion18 = Result.Companion;
                                KType kTypeTypeOf7 = Reflection.typeOf(ResponseHash.class);
                                MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                                obj5 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf7));
                                if (Result.exceptionOrNull-impl(obj5) == null) {
                                    Result.Companion companion19 = Result.Companion;
                                    obj6 = coroutine_suspended;
                                    id3 = id2;
                                    id4 = null;
                                    obj5 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(ResponseHash.class), (List) null, 2, (Object) null));
                                } else {
                                    obj6 = coroutine_suspended;
                                    id3 = id2;
                                    id4 = null;
                                }
                                if (Result.isFailure-impl(obj5)) {
                                    obj5 = id4;
                                }
                                deserializationStrategy = (KSerializer) obj5;
                                if (deserializationStrategy != null) {
                                    objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, value$iv);
                                } else {
                                    ObjectMapper $this$readValue$iv$iv$iv12 = MainAPIKt.getMapper();
                                    objDecodeFromString = $this$readValue$iv$iv$iv12.readValue(value$iv, new TypeReference<ResponseHash>() { // from class: com.phisher98.StreamPlayExtractor$invokeWpmovies$lambda$1$$inlined$tryParseJson$1
                                    });
                                }
                                obj7 = objDecodeFromString;
                            }
                            it = (ResponseHash) obj7;
                            if (it != null) {
                                obj2 = null;
                                $i$f$withPermit2 = $i$f$withPermit;
                                $i$f$withPermit3 = i;
                                obj10 = Unit.INSTANCE;
                            } else if (c02311.$encrypt$inlined) {
                                AppUtils appUtils8 = AppUtils.INSTANCE;
                                value$iv2 = it.getEmbed_url();
                                if (value$iv2 == null) {
                                    objDecodeFromString2 = null;
                                } else {
                                    Result.Companion companion110 = Result.Companion;
                                    KType kTypeTypeOf8 = Reflection.typeOf(ZShowEmbed.class);
                                    MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                                    obj9 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf8));
                                    if (Result.exceptionOrNull-impl(obj9) != null) {
                                        Result.Companion companion111 = Result.Companion;
                                        obj9 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(ZShowEmbed.class), (List) null, 2, (Object) null));
                                        break;
                                    }
                                    if (Result.isFailure-impl(obj9)) {
                                        obj9 = null;
                                    }
                                    deserializationStrategy2 = (KSerializer) obj9;
                                    if (deserializationStrategy2 != null) {
                                        objDecodeFromString2 = MainAPIKt.getJson().decodeFromString(deserializationStrategy2, value$iv2);
                                    } else {
                                        ObjectMapper $this$readValue$iv$iv$iv13 = MainAPIKt.getMapper();
                                        objDecodeFromString2 = $this$readValue$iv$iv$iv13.readValue(value$iv2, new TypeReference<ZShowEmbed>() { // from class: com.phisher98.StreamPlayExtractor$invokeWpmovies$lambda$1$0$$inlined$tryParseJson$1
                                        });
                                    }
                                }
                                zShowEmbed = (ZShowEmbed) objDecodeFromString2;
                                if (zShowEmbed != null) {
                                }
                                obj10 = Unit.INSTANCE;
                                break;
                            } else {
                                $completion3 = $completion2;
                                obj8 = obj6;
                                i3 = 2;
                                if (c02311.$fixIframe$inlined) {
                                    source = Ksoup.parse$default(Ksoup.INSTANCE, it.getEmbed_url(), (String) null, 2, (Object) null).select("IFRAME").attr("SRC");
                                } else {
                                    source = it.getEmbed_url();
                                }
                                if (source == null) {
                                    obj2 = null;
                                    $i$f$withPermit2 = $i$f$withPermit;
                                    $i$f$withPermit3 = i;
                                    obj10 = Unit.INSTANCE;
                                } else if (StringsKt.contains$default(source, "youtube", false, i3, (Object) null)) {
                                    String str111 = c02311.$name$inlined;
                                    String str112 = c02311.$name$inlined;
                                    String str113 = c02311.$referer$inlined + '/';
                                    Function1 function11 = c02311.$subtitleCallback$inlined;
                                    Function1 function12 = c02311.$callback$inlined;
                                    c02311.L$0 = $this$withPermit$iv;
                                    c02311.L$1 = obj3;
                                    c02311.L$2 = SpillingKt.nullOutSpilledVariable($completion3);
                                    c02311.L$3 = SpillingKt.nullOutSpilledVariable(id3);
                                    c02311.L$4 = SpillingKt.nullOutSpilledVariable(nume2);
                                    c02311.L$5 = SpillingKt.nullOutSpilledVariable(type2);
                                    c02311.L$6 = SpillingKt.nullOutSpilledVariable(source);
                                    c02311.L$7 = SpillingKt.nullOutSpilledVariable(json);
                                    c02311.L$8 = null;
                                    c02311.L$9 = null;
                                    c02311.label = 4;
                                    obj12 = obj8;
                                    objLoadDisplaySourceNameExtractor$default = StreamPlayUtilsKt.loadDisplaySourceNameExtractor$default(str111, str112, source, str113, function11, function12, null, this, 64, null);
                                    if (objLoadDisplaySourceNameExtractor$default == obj12) {
                                        return obj12;
                                    }
                                    obj13 = objLoadDisplaySourceNameExtractor$default;
                                    $i$f$withPermit3 = i;
                                    obj10 = obj13;
                                } else {
                                    obj10 = Unit.INSTANCE;
                                }
                            }
                            break;
                        } catch (Exception e17) {
                            e = e17;
                            $i$f$withPermit2 = 0;
                            $i$f$withPermit3 = 0;
                            obj2 = null;
                            Log.INSTANCE.e("safeMap", "Request failed for " + obj3 + ' ' + e);
                            obj10 = obj2;
                            $this$withPermit$iv.release();
                            return obj10;
                        } catch (Throwable th16) {
                            th = th16;
                            $this$withPermit$iv.release();
                            throw th;
                        }
                        $this$withPermit$iv.release();
                        return obj10;
                    case 3:
                        json2 = (NiceResponse) c02311.L$7;
                        type2 = (String) c02311.L$5;
                        nume2 = (String) c02311.L$4;
                        id5 = (String) c02311.L$3;
                        Continuation $completion4 = (Continuation) c02311.L$2;
                        obj11 = c02311.L$1;
                        $this$withPermit$iv4 = (Semaphore) c02311.L$0;
                        try {
                            ResultKt.throwOnFailure($result);
                            i2 = 0;
                            $completion3 = $completion4;
                            i3 = 2;
                            objCryptoAESHandler$default = $result;
                            obj8 = coroutine_suspended;
                            $i$f$withPermit2 = 0;
                            $i$f$withPermit3 = 0;
                            str = (String) objCryptoAESHandler$default;
                            if (str != null) {
                            }
                            obj10 = Unit.INSTANCE;
                            $this$withPermit$iv = $this$withPermit$iv4;
                            break;
                        } catch (Exception e18) {
                            e = e18;
                            $i$f$withPermit2 = 0;
                            $this$withPermit$iv = $this$withPermit$iv4;
                            $i$f$withPermit3 = 0;
                            obj3 = obj11;
                            obj2 = null;
                            Log.INSTANCE.e("safeMap", "Request failed for " + obj3 + ' ' + e);
                            obj10 = obj2;
                            $this$withPermit$iv.release();
                            return obj10;
                        } catch (Throwable th17) {
                            th = th17;
                            $this$withPermit$iv = $this$withPermit$iv4;
                            $this$withPermit$iv.release();
                            throw th;
                        }
                        $this$withPermit$iv.release();
                        return obj10;
                    case 4:
                        $i$f$withPermit2 = 0;
                        $i$f$withPermit3 = 0;
                        obj3 = c02311.L$1;
                        $this$withPermit$iv = (Semaphore) c02311.L$0;
                        try {
                            ResultKt.throwOnFailure($result);
                            obj13 = $result;
                            obj10 = obj13;
                        } catch (Exception e19) {
                            e = e19;
                            obj2 = null;
                            Log.INSTANCE.e("safeMap", "Request failed for " + obj3 + ' ' + e);
                            obj10 = obj2;
                        }
                        $this$withPermit$iv.release();
                        return obj10;
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
                    CoroutineScope $this$coroutineScope2 = $this$coroutineScope;
                    Collection destination$iv$iv2 = destination$iv$iv;
                    $this$coroutineScope = $this$coroutineScope2;
                    destination$iv$iv2.add(BuildersKt.async$default($this$coroutineScope, Dispatchers.getIO(), (CoroutineStart) null, new C02311(semaphore, item$iv$iv, null, this.$referer$inlined, this.$url$inlined, this.$hasCloudflare$inlined, this.$interceptor$inlined, this.$name$inlined, this.$subtitleCallback$inlined, this.$callback$inlined, this.$encrypt$inlined, this.$fixIframe$inlined), 2, (Object) null));
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
