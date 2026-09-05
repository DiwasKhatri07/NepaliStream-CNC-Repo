package com.phisher98;

import com.lagradost.api.Log;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
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
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.sync.Semaphore;
import kotlinx.coroutines.sync.SemaphoreKt;
import okhttp3.Interceptor;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/* JADX INFO: compiled from: StreamPlayUtils.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/StreamPlay/classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\b\u00028\u00000\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "com/phisher98/StreamPlayUtilsKt$safeAmap$2$1"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.phisher98.StreamPlayExtractor$invokeZinkmovies$$inlined$safeAmap$default$1", f = "StreamPlayExtractor.kt", i = {0, 0}, l = {1898}, m = "invokeSuspend", n = {"$this$coroutineScope", "semaphore"}, nl = {-1}, s = {"L$0", "L$1"}, v = 2)
@SourceDebugExtension({"SMAP\nStreamPlayUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,2265:1\n1739#2:2266\n1814#2,3:2267\n*S KotlinDebug\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1\n*L\n1887#1:2266\n1887#1:2267,3\n*E\n"})
public final class StreamPlayExtractor$invokeZinkmovies$$inlined$safeAmap$default$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Object>>, Object> {
    final /* synthetic */ Function1 $callback$inlined;
    final /* synthetic */ int $concurrency;
    final /* synthetic */ Integer $episode$inlined;
    final /* synthetic */ Integer $season$inlined;
    final /* synthetic */ Function1 $subtitleCallback$inlined;
    final /* synthetic */ Iterable $this_runCatching;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StreamPlayExtractor$invokeZinkmovies$$inlined$safeAmap$default$1(int i, Iterable iterable, Continuation continuation, Integer num, Integer num2, Function1 function1, Function1 function2) {
        super(2, continuation);
        this.$concurrency = i;
        this.$this_runCatching = iterable;
        this.$season$inlined = num;
        this.$episode$inlined = num2;
        this.$subtitleCallback$inlined = function1;
        this.$callback$inlined = function2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> streamPlayExtractor$invokeZinkmovies$$inlined$safeAmap$default$1 = new StreamPlayExtractor$invokeZinkmovies$$inlined$safeAmap$default$1(this.$concurrency, this.$this_runCatching, continuation, this.$season$inlined, this.$episode$inlined, this.$subtitleCallback$inlined, this.$callback$inlined);
        streamPlayExtractor$invokeZinkmovies$$inlined$safeAmap$default$1.L$0 = obj;
        return streamPlayExtractor$invokeZinkmovies$$inlined$safeAmap$default$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends Object>> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: renamed from: com.phisher98.StreamPlayExtractor$invokeZinkmovies$$inlined$safeAmap$default$1$1 */
    /* JADX INFO: compiled from: StreamPlayUtils.kt */
    @Metadata(d1 = {"\u0000\n\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", "B", "Lkotlinx/coroutines/CoroutineScope;", "com/phisher98/StreamPlayUtilsKt$safeAmap$2$1$1$1"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StreamPlayExtractor$invokeZinkmovies$$inlined$safeAmap$default$1$1", f = "StreamPlayExtractor.kt", i = {0, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3}, l = {2266, 2269, 2278, 2303}, m = "invokeSuspend", n = {"$this$withPermit$iv", "$this$withPermit$iv", "$completion", "matchUrl", "$this$withPermit$iv", "$completion", "matchUrl", "detailDoc", "$this$safeAmap_u24default$iv", "content", "$completion$iv", "$this$safeAmap_u24lambda_u240$iv", "concurrency$iv", "$this$withPermit$iv", "$completion", "matchUrl", "detailDoc", "$this$safeAmap_u24default$iv", "content", "$completion$iv", "$this$safeAmap_u24lambda_u240$iv", "concurrency$iv"}, nl = {2267, 2270, 2279, 2304}, s = {"L$0", "L$0", "L$2", "L$3", "L$0", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "I$0", "L$0", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "I$0"}, v = 2)
    @SourceDebugExtension({"SMAP\nStreamPlayUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1$1$1\n+ 2 Semaphore.kt\nkotlinx/coroutines/sync/SemaphoreKt\n+ 3 StreamPlayExtractor.kt\ncom/phisher98/StreamPlayExtractor\n+ 4 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt\n+ 5 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 6 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,2265:1\n81#2,3:2266\n85#2,2:2307\n5228#3,5:2269\n5246#3:2281\n5244#3,2:2282\n5250#3:2306\n1880#4,5:2274\n1899#4,2:2279\n1880#4,5:2299\n1899#4,2:2304\n1795#5,10:2284\n2068#5:2294\n2069#5:2297\n1805#5:2298\n1#6:2295\n1#6:2296\n*S KotlinDebug\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1$1$1\n+ 2 StreamPlayExtractor.kt\ncom/phisher98/StreamPlayExtractor\n*L\n1889#1:2266,3\n1889#1:2307,2\n5232#2:2274,5\n5232#2:2279,2\n5246#2:2299,5\n5246#2:2304,2\n5245#2:2284,10\n5245#2:2294\n5245#2:2297\n5245#2:2298\n5245#2:2296\n*E\n"})
    public static final class C02371 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Object>, Object> {
        final /* synthetic */ Function1 $callback$inlined;
        final /* synthetic */ Integer $episode$inlined;
        final /* synthetic */ Object $item;
        final /* synthetic */ Integer $season$inlined;
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
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C02371(Semaphore semaphore, Object obj, Continuation continuation, Integer num, Integer num2, Function1 function1, Function1 function2) {
            super(2, continuation);
            this.$semaphore = semaphore;
            this.$item = obj;
            this.$season$inlined = num;
            this.$episode$inlined = num2;
            this.$subtitleCallback$inlined = function1;
            this.$callback$inlined = function2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C02371(this.$semaphore, this.$item, continuation, this.$season$inlined, this.$episode$inlined, this.$subtitleCallback$inlined, this.$callback$inlined);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Object> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:142:0x0252 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:34:0x013e A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:35:0x013f  */
        /* JADX WARN: Code duplicated, block: B:38:0x0156 A[Catch: all -> 0x02ea, Exception -> 0x02f0, TryCatch #17 {Exception -> 0x02f0, all -> 0x02ea, blocks: (B:36:0x0147, B:38:0x0156, B:39:0x015c, B:41:0x0161, B:43:0x0165, B:65:0x0200, B:66:0x0219, B:68:0x021f, B:73:0x024e, B:75:0x0257), top: B:135:0x0147 }] */
        /* JADX WARN: Code duplicated, block: B:39:0x015c A[Catch: all -> 0x02ea, Exception -> 0x02f0, TryCatch #17 {Exception -> 0x02f0, all -> 0x02ea, blocks: (B:36:0x0147, B:38:0x0156, B:39:0x015c, B:41:0x0161, B:43:0x0165, B:65:0x0200, B:66:0x0219, B:68:0x021f, B:73:0x024e, B:75:0x0257), top: B:135:0x0147 }] */
        /* JADX WARN: Code duplicated, block: B:41:0x0161 A[Catch: all -> 0x02ea, Exception -> 0x02f0, TryCatch #17 {Exception -> 0x02f0, all -> 0x02ea, blocks: (B:36:0x0147, B:38:0x0156, B:39:0x015c, B:41:0x0161, B:43:0x0165, B:65:0x0200, B:66:0x0219, B:68:0x021f, B:73:0x024e, B:75:0x0257), top: B:135:0x0147 }] */
        /* JADX WARN: Code duplicated, block: B:68:0x021f A[Catch: all -> 0x02ea, Exception -> 0x02f0, TryCatch #17 {Exception -> 0x02f0, all -> 0x02ea, blocks: (B:36:0x0147, B:38:0x0156, B:39:0x015c, B:41:0x0161, B:43:0x0165, B:65:0x0200, B:66:0x0219, B:68:0x021f, B:73:0x024e, B:75:0x0257), top: B:135:0x0147 }] */
        /* JADX WARN: Code duplicated, block: B:70:0x0249  */
        /* JADX WARN: Code duplicated, block: B:71:0x024a  */
        /* JADX WARN: Code duplicated, block: B:73:0x024e A[Catch: all -> 0x02ea, Exception -> 0x02f0, TryCatch #17 {Exception -> 0x02f0, all -> 0x02ea, blocks: (B:36:0x0147, B:38:0x0156, B:39:0x015c, B:41:0x0161, B:43:0x0165, B:65:0x0200, B:66:0x0219, B:68:0x021f, B:73:0x024e, B:75:0x0257), top: B:135:0x0147 }] */
        /* JADX WARN: Code duplicated, block: B:81:0x02bc A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:82:0x02bd  */
        /* JADX WARN: Not initialized variable reg: 14, insn: 0x01fb: MOVE (r7 I:??[OBJECT, ARRAY]) = (r14 I:??[OBJECT, ARRAY]), block:B:63:0x01fb */
        /* JADX WARN: Not initialized variable reg: 15, insn: 0x01f7: MOVE (r8 I:??[OBJECT, ARRAY]) = (r15 I:??[OBJECT, ARRAY] A[D('$this$withPermit$iv' kotlinx.coroutines.sync.Semaphore)]), block:B:61:0x01f7 */
        /* JADX WARN: Not initialized variable reg: 15, insn: 0x01fc: MOVE (r8 I:??[OBJECT, ARRAY]) = (r15 I:??[OBJECT, ARRAY] A[D('$this$withPermit$iv' kotlinx.coroutines.sync.Semaphore)]), block:B:63:0x01fb */
        public final Object invokeSuspend(Object $result) throws Throwable {
            Semaphore $this$withPermit$iv;
            Semaphore $this$withPermit$iv2;
            Object obj;
            Object obj2;
            Semaphore $this$withPermit$iv3;
            Semaphore $this$withPermit$iv4;
            Semaphore $this$withPermit$iv5;
            Object obj3;
            int $i$f$withPermit;
            Continuation $completion;
            String matchUrl;
            Object obj4;
            Semaphore $this$withPermit$iv6;
            Object obj5;
            C02371 c02371;
            Continuation $completion2;
            Object obj6;
            String matchUrl2;
            Document detailDoc;
            Element content;
            Iterable $this$mapNotNull$iv;
            int $i$f$mapNotNull;
            Collection destination$iv$iv;
            int $i$f$withPermit2;
            Object objCoroutineScope;
            String p0;
            int $i$f$withPermit3;
            Object objCoroutineScope2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int $i$f$withPermit4 = this.label;
            Unit unit = null;
            try {
                try {
                    switch ($i$f$withPermit4) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            Semaphore $this$withPermit$iv7 = this.$semaphore;
                            Object obj7 = this.$item;
                            this.L$0 = $this$withPermit$iv7;
                            this.L$1 = obj7;
                            this.label = 1;
                            if ($this$withPermit$iv7.acquire((Continuation) this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            $this$withPermit$iv5 = $this$withPermit$iv7;
                            obj3 = obj7;
                            $i$f$withPermit = 0;
                            try {
                                $completion = (Continuation) this;
                                matchUrl = (String) obj3;
                                Requests app = MainActivityKt.getApp();
                                this.L$0 = $this$withPermit$iv5;
                                this.L$1 = obj3;
                                this.L$2 = SpillingKt.nullOutSpilledVariable($completion);
                                this.L$3 = SpillingKt.nullOutSpilledVariable(matchUrl);
                                this.label = 2;
                                obj4 = obj3;
                                $this$withPermit$iv6 = $this$withPermit$iv5;
                                try {
                                    obj5 = Requests.get$default(app, matchUrl, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, this, 4094, (Object) null);
                                    c02371 = this;
                                    if (obj5 == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    $this$withPermit$iv4 = $this$withPermit$iv6;
                                    $completion2 = $completion;
                                    obj6 = obj4;
                                    matchUrl2 = matchUrl;
                                    try {
                                        detailDoc = ((NiceResponse) obj5).getDocument();
                                        content = detailDoc.selectFirst("div.wp-content");
                                        if (content == null) {
                                            unit = Unit.INSTANCE;
                                        } else if (c02371.$season$inlined != null || c02371.$episode$inlined == null) {
                                            $this$mapNotNull$iv = content.select("div.movie-button-container a.movie-simple-button");
                                            $i$f$mapNotNull = 0;
                                            destination$iv$iv = new ArrayList();
                                            for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
                                                Element it = (Element) element$iv$iv$iv;
                                                Iterable $this$mapNotNull$iv2 = $this$mapNotNull$iv;
                                                int $i$f$mapNotNull2 = $i$f$mapNotNull;
                                                p0 = it.attr("href");
                                                if (StringsKt.isBlank(p0)) {
                                                    p0 = null;
                                                }
                                                if (p0 != null) {
                                                    destination$iv$iv.add(p0);
                                                }
                                                $this$mapNotNull$iv = $this$mapNotNull$iv2;
                                                $i$f$mapNotNull = $i$f$mapNotNull2;
                                            }
                                            Iterable $this$safeAmap_u24default$iv = (List) destination$iv$iv;
                                            try {
                                                Result.Companion companion = Result.Companion;
                                                try {
                                                    C0240x4a5f1dca c0240x4a5f1dca = new C0240x4a5f1dca(7, $this$safeAmap_u24default$iv, null, c02371.$subtitleCallback$inlined, c02371.$callback$inlined);
                                                    c02371.L$0 = $this$withPermit$iv4;
                                                    c02371.L$1 = obj6;
                                                    c02371.L$2 = SpillingKt.nullOutSpilledVariable($completion2);
                                                    c02371.L$3 = SpillingKt.nullOutSpilledVariable(matchUrl2);
                                                    c02371.L$4 = SpillingKt.nullOutSpilledVariable(detailDoc);
                                                    c02371.L$5 = SpillingKt.nullOutSpilledVariable($this$safeAmap_u24default$iv);
                                                    c02371.L$6 = SpillingKt.nullOutSpilledVariable(content);
                                                    c02371.L$7 = SpillingKt.nullOutSpilledVariable(this);
                                                    c02371.L$8 = SpillingKt.nullOutSpilledVariable($this$safeAmap_u24default$iv);
                                                    c02371.I$0 = 7;
                                                    c02371.label = 4;
                                                    objCoroutineScope = CoroutineScopeKt.coroutineScope(c0240x4a5f1dca, c02371);
                                                    if (objCoroutineScope == coroutine_suspended) {
                                                        return coroutine_suspended;
                                                    }
                                                    Result.constructor-impl((List) objCoroutineScope);
                                                    obj2 = obj6;
                                                    $this$withPermit$iv2 = $this$withPermit$iv4;
                                                    $i$f$withPermit4 = $i$f$withPermit;
                                                    try {
                                                        $this$withPermit$iv4 = $this$withPermit$iv2;
                                                        unit = Unit.INSTANCE;
                                                    } catch (Exception e) {
                                                        e = e;
                                                        Log.INSTANCE.e("safeMap", "Request failed for " + obj2 + ' ' + e);
                                                        $this$withPermit$iv4 = $this$withPermit$iv2;
                                                    }
                                                } catch (Throwable th) {
                                                    th = th;
                                                    $i$f$withPermit2 = $i$f$withPermit;
                                                    Result.Companion companion2 = Result.Companion;
                                                    Result.constructor-impl(ResultKt.createFailure(th));
                                                    $i$f$withPermit = $i$f$withPermit2;
                                                }
                                            } catch (Throwable th2) {
                                                th = th2;
                                                $i$f$withPermit2 = $i$f$withPermit;
                                                Result.Companion companion3 = Result.Companion;
                                                Result.constructor-impl(ResultKt.createFailure(th));
                                                $i$f$withPermit = $i$f$withPermit2;
                                            }
                                        } else {
                                            Iterable $this$safeAmap_u24default$iv2 = StreamPlayExtractor.INSTANCE.extractSeasonLinks(content, c02371.$season$inlined.intValue());
                                            try {
                                                Result.Companion companion4 = Result.Companion;
                                                try {
                                                    C0239x4a5f1dc9 c0239x4a5f1dc9 = new C0239x4a5f1dc9(7, $this$safeAmap_u24default$iv2, null, c02371.$subtitleCallback$inlined, c02371.$callback$inlined, c02371.$episode$inlined);
                                                    c02371.L$0 = $this$withPermit$iv4;
                                                    c02371.L$1 = obj6;
                                                    c02371.L$2 = SpillingKt.nullOutSpilledVariable($completion2);
                                                    c02371.L$3 = SpillingKt.nullOutSpilledVariable(matchUrl2);
                                                    c02371.L$4 = SpillingKt.nullOutSpilledVariable(detailDoc);
                                                    c02371.L$5 = SpillingKt.nullOutSpilledVariable($this$safeAmap_u24default$iv2);
                                                    c02371.L$6 = SpillingKt.nullOutSpilledVariable(content);
                                                    c02371.L$7 = SpillingKt.nullOutSpilledVariable(this);
                                                    c02371.L$8 = SpillingKt.nullOutSpilledVariable($this$safeAmap_u24default$iv2);
                                                    c02371.I$0 = 7;
                                                    c02371.label = 3;
                                                    objCoroutineScope2 = CoroutineScopeKt.coroutineScope(c0239x4a5f1dc9, c02371);
                                                    if (objCoroutineScope2 == coroutine_suspended) {
                                                        return coroutine_suspended;
                                                    }
                                                    Result.constructor-impl((List) objCoroutineScope2);
                                                    obj2 = obj6;
                                                    $this$withPermit$iv2 = $this$withPermit$iv4;
                                                    $i$f$withPermit4 = $i$f$withPermit;
                                                    $this$withPermit$iv4 = $this$withPermit$iv2;
                                                    unit = Unit.INSTANCE;
                                                } catch (Throwable th3) {
                                                    th = th3;
                                                    $i$f$withPermit3 = $i$f$withPermit;
                                                    Result.Companion companion5 = Result.Companion;
                                                    Result.constructor-impl(ResultKt.createFailure(th));
                                                    $i$f$withPermit = $i$f$withPermit3;
                                                }
                                            } catch (Throwable th4) {
                                                th = th4;
                                                $i$f$withPermit3 = $i$f$withPermit;
                                                Result.Companion companion6 = Result.Companion;
                                                Result.constructor-impl(ResultKt.createFailure(th));
                                                $i$f$withPermit = $i$f$withPermit3;
                                            }
                                        }
                                        break;
                                    } catch (Exception e2) {
                                        e = e2;
                                        obj2 = obj6;
                                        $this$withPermit$iv2 = $this$withPermit$iv4;
                                        $i$f$withPermit4 = $i$f$withPermit;
                                        Log.INSTANCE.e("safeMap", "Request failed for " + obj2 + ' ' + e);
                                        $this$withPermit$iv4 = $this$withPermit$iv2;
                                        $this$withPermit$iv4.release();
                                        return unit;
                                    } catch (Throwable th5) {
                                        th = th5;
                                        $this$withPermit$iv2 = $this$withPermit$iv4;
                                        $this$withPermit$iv2.release();
                                        throw th;
                                    }
                                    $this$withPermit$iv4.release();
                                    return unit;
                                } catch (Exception e3) {
                                    e = e3;
                                    $this$withPermit$iv2 = $this$withPermit$iv6;
                                    $i$f$withPermit4 = $i$f$withPermit;
                                    obj2 = obj4;
                                    Log.INSTANCE.e("safeMap", "Request failed for " + obj2 + ' ' + e);
                                    $this$withPermit$iv4 = $this$withPermit$iv2;
                                    $this$withPermit$iv4.release();
                                    return unit;
                                } catch (Throwable th6) {
                                    th = th6;
                                    $this$withPermit$iv2 = $this$withPermit$iv6;
                                    $this$withPermit$iv2.release();
                                    throw th;
                                }
                            } catch (Exception e4) {
                                e = e4;
                                Object obj8 = obj3;
                                $this$withPermit$iv2 = $this$withPermit$iv5;
                                $i$f$withPermit4 = $i$f$withPermit;
                                obj2 = obj8;
                            } catch (Throwable th7) {
                                th = th7;
                                $this$withPermit$iv2 = $this$withPermit$iv5;
                            }
                            break;
                        case 1:
                            Object obj9 = this.L$1;
                            Semaphore $this$withPermit$iv8 = (Semaphore) this.L$0;
                            ResultKt.throwOnFailure($result);
                            $i$f$withPermit = 0;
                            obj3 = obj9;
                            $this$withPermit$iv5 = $this$withPermit$iv8;
                            $completion = (Continuation) this;
                            matchUrl = (String) obj3;
                            Requests app2 = MainActivityKt.getApp();
                            this.L$0 = $this$withPermit$iv5;
                            this.L$1 = obj3;
                            this.L$2 = SpillingKt.nullOutSpilledVariable($completion);
                            this.L$3 = SpillingKt.nullOutSpilledVariable(matchUrl);
                            this.label = 2;
                            obj4 = obj3;
                            $this$withPermit$iv6 = $this$withPermit$iv5;
                            obj5 = Requests.get$default(app2, matchUrl, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, this, 4094, (Object) null);
                            c02371 = this;
                            if (obj5 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            $this$withPermit$iv4 = $this$withPermit$iv6;
                            $completion2 = $completion;
                            obj6 = obj4;
                            matchUrl2 = matchUrl;
                            detailDoc = ((NiceResponse) obj5).getDocument();
                            content = detailDoc.selectFirst("div.wp-content");
                            if (content == null) {
                                if (c02371.$season$inlined != null) {
                                }
                                $this$mapNotNull$iv = content.select("div.movie-button-container a.movie-simple-button");
                                $i$f$mapNotNull = 0;
                                destination$iv$iv = new ArrayList();
                                while (r16.hasNext()) {
                                    Element it2 = (Element) element$iv$iv$iv;
                                    Iterable $this$mapNotNull$iv3 = $this$mapNotNull$iv;
                                    int $i$f$mapNotNull3 = $i$f$mapNotNull;
                                    p0 = it2.attr("href");
                                    if (StringsKt.isBlank(p0)) {
                                        p0 = null;
                                    }
                                    if (p0 != null) {
                                        destination$iv$iv.add(p0);
                                    }
                                    $this$mapNotNull$iv = $this$mapNotNull$iv3;
                                    $i$f$mapNotNull = $i$f$mapNotNull3;
                                }
                                Iterable $this$safeAmap_u24default$iv3 = (List) destination$iv$iv;
                                Result.Companion companion7 = Result.Companion;
                                C0240x4a5f1dca c0240x4a5f1dca2 = new C0240x4a5f1dca(7, $this$safeAmap_u24default$iv3, null, c02371.$subtitleCallback$inlined, c02371.$callback$inlined);
                                c02371.L$0 = $this$withPermit$iv4;
                                c02371.L$1 = obj6;
                                c02371.L$2 = SpillingKt.nullOutSpilledVariable($completion2);
                                c02371.L$3 = SpillingKt.nullOutSpilledVariable(matchUrl2);
                                c02371.L$4 = SpillingKt.nullOutSpilledVariable(detailDoc);
                                c02371.L$5 = SpillingKt.nullOutSpilledVariable($this$safeAmap_u24default$iv3);
                                c02371.L$6 = SpillingKt.nullOutSpilledVariable(content);
                                c02371.L$7 = SpillingKt.nullOutSpilledVariable(this);
                                c02371.L$8 = SpillingKt.nullOutSpilledVariable($this$safeAmap_u24default$iv3);
                                c02371.I$0 = 7;
                                c02371.label = 4;
                                objCoroutineScope = CoroutineScopeKt.coroutineScope(c0240x4a5f1dca2, c02371);
                                if (objCoroutineScope == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                Result.constructor-impl((List) objCoroutineScope);
                                obj2 = obj6;
                                $this$withPermit$iv2 = $this$withPermit$iv4;
                                $i$f$withPermit4 = $i$f$withPermit;
                                $this$withPermit$iv4 = $this$withPermit$iv2;
                                unit = Unit.INSTANCE;
                                break;
                            } else {
                                unit = Unit.INSTANCE;
                            }
                            $this$withPermit$iv4.release();
                            return unit;
                        case 2:
                            $i$f$withPermit4 = 0;
                            String matchUrl3 = (String) this.L$3;
                            Continuation $completion3 = (Continuation) this.L$2;
                            obj2 = this.L$1;
                            $this$withPermit$iv2 = (Semaphore) this.L$0;
                            try {
                                ResultKt.throwOnFailure($result);
                                $i$f$withPermit = 0;
                                $completion2 = $completion3;
                                obj6 = obj2;
                                $this$withPermit$iv4 = $this$withPermit$iv2;
                                obj5 = $result;
                                c02371 = this;
                                matchUrl2 = matchUrl3;
                                detailDoc = ((NiceResponse) obj5).getDocument();
                                content = detailDoc.selectFirst("div.wp-content");
                                if (content == null) {
                                    if (c02371.$season$inlined != null) {
                                    }
                                    $this$mapNotNull$iv = content.select("div.movie-button-container a.movie-simple-button");
                                    $i$f$mapNotNull = 0;
                                    destination$iv$iv = new ArrayList();
                                    while (r16.hasNext()) {
                                        Element it3 = (Element) element$iv$iv$iv;
                                        Iterable $this$mapNotNull$iv4 = $this$mapNotNull$iv;
                                        int $i$f$mapNotNull4 = $i$f$mapNotNull;
                                        p0 = it3.attr("href");
                                        if (StringsKt.isBlank(p0)) {
                                            p0 = null;
                                        }
                                        if (p0 != null) {
                                            destination$iv$iv.add(p0);
                                        }
                                        $this$mapNotNull$iv = $this$mapNotNull$iv4;
                                        $i$f$mapNotNull = $i$f$mapNotNull4;
                                    }
                                    Iterable $this$safeAmap_u24default$iv4 = (List) destination$iv$iv;
                                    Result.Companion companion8 = Result.Companion;
                                    C0240x4a5f1dca c0240x4a5f1dca3 = new C0240x4a5f1dca(7, $this$safeAmap_u24default$iv4, null, c02371.$subtitleCallback$inlined, c02371.$callback$inlined);
                                    c02371.L$0 = $this$withPermit$iv4;
                                    c02371.L$1 = obj6;
                                    c02371.L$2 = SpillingKt.nullOutSpilledVariable($completion2);
                                    c02371.L$3 = SpillingKt.nullOutSpilledVariable(matchUrl2);
                                    c02371.L$4 = SpillingKt.nullOutSpilledVariable(detailDoc);
                                    c02371.L$5 = SpillingKt.nullOutSpilledVariable($this$safeAmap_u24default$iv4);
                                    c02371.L$6 = SpillingKt.nullOutSpilledVariable(content);
                                    c02371.L$7 = SpillingKt.nullOutSpilledVariable(this);
                                    c02371.L$8 = SpillingKt.nullOutSpilledVariable($this$safeAmap_u24default$iv4);
                                    c02371.I$0 = 7;
                                    c02371.label = 4;
                                    objCoroutineScope = CoroutineScopeKt.coroutineScope(c0240x4a5f1dca3, c02371);
                                    if (objCoroutineScope == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    Result.constructor-impl((List) objCoroutineScope);
                                    obj2 = obj6;
                                    $this$withPermit$iv2 = $this$withPermit$iv4;
                                    $i$f$withPermit4 = $i$f$withPermit;
                                    $this$withPermit$iv4 = $this$withPermit$iv2;
                                    unit = Unit.INSTANCE;
                                } else {
                                    unit = Unit.INSTANCE;
                                }
                                break;
                            } catch (Exception e5) {
                                e = e5;
                                Log.INSTANCE.e("safeMap", "Request failed for " + obj2 + ' ' + e);
                                $this$withPermit$iv4 = $this$withPermit$iv2;
                                $this$withPermit$iv4.release();
                                return unit;
                            } catch (Throwable th8) {
                                th = th8;
                                $this$withPermit$iv2.release();
                                throw th;
                            }
                            $this$withPermit$iv4.release();
                            return unit;
                        case 3:
                            $i$f$withPermit3 = 0;
                            int i = this.I$0;
                            obj6 = this.L$1;
                            $this$withPermit$iv4 = (Semaphore) this.L$0;
                            try {
                                ResultKt.throwOnFailure($result);
                                $i$f$withPermit = 0;
                                objCoroutineScope2 = $result;
                                Result.constructor-impl((List) objCoroutineScope2);
                                break;
                            } catch (Throwable th9) {
                                th = th9;
                                Result.Companion companion9 = Result.Companion;
                                Result.constructor-impl(ResultKt.createFailure(th));
                                $i$f$withPermit = $i$f$withPermit3;
                            }
                            obj2 = obj6;
                            $this$withPermit$iv2 = $this$withPermit$iv4;
                            $i$f$withPermit4 = $i$f$withPermit;
                            $this$withPermit$iv4 = $this$withPermit$iv2;
                            unit = Unit.INSTANCE;
                            $this$withPermit$iv4.release();
                            return unit;
                        case 4:
                            $i$f$withPermit2 = 0;
                            int i2 = this.I$0;
                            obj6 = this.L$1;
                            $this$withPermit$iv4 = (Semaphore) this.L$0;
                            try {
                                ResultKt.throwOnFailure($result);
                                $i$f$withPermit = 0;
                                objCoroutineScope = $result;
                                Result.constructor-impl((List) objCoroutineScope);
                                break;
                            } catch (Throwable th10) {
                                th = th10;
                                Result.Companion companion10 = Result.Companion;
                                Result.constructor-impl(ResultKt.createFailure(th));
                                $i$f$withPermit = $i$f$withPermit2;
                            }
                            obj2 = obj6;
                            $this$withPermit$iv2 = $this$withPermit$iv4;
                            $i$f$withPermit4 = $i$f$withPermit;
                            $this$withPermit$iv4 = $this$withPermit$iv2;
                            unit = Unit.INSTANCE;
                            $this$withPermit$iv4.release();
                            return unit;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } catch (Throwable th11) {
                    th = th11;
                }
            } catch (Exception e6) {
                e = e6;
                obj2 = obj;
                $this$withPermit$iv2 = $this$withPermit$iv3;
            } catch (Throwable th12) {
                th = th12;
                $this$withPermit$iv2 = $this$withPermit$iv;
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
                    destination$iv$iv2.add(BuildersKt.async$default($this$coroutineScope, Dispatchers.getIO(), (CoroutineStart) null, new C02371(semaphore, item$iv$iv, null, this.$season$inlined, this.$episode$inlined, this.$subtitleCallback$inlined, this.$callback$inlined), 2, (Object) null));
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
