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
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.sync.Semaphore;
import kotlinx.coroutines.sync.SemaphoreKt;
import okhttp3.Interceptor;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/* JADX INFO: compiled from: StreamPlayUtils.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StreamPlay/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\b\u00028\u00000\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "com/phisher98/StreamPlayUtilsKt$safeAmap$2$1"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.phisher98.StreamPlayExtractor$invokeModflix$$inlined$safeAmap$default$1", f = "StreamPlayExtractor.kt", i = {0, 0}, l = {1898}, m = "invokeSuspend", n = {"$this$coroutineScope", "semaphore"}, nl = {-1}, s = {"L$0", "L$1"}, v = 2)
@SourceDebugExtension({"SMAP\nStreamPlayUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,2265:1\n1739#2:2266\n1814#2,3:2267\n*S KotlinDebug\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1\n*L\n1887#1:2266\n1887#1:2267,3\n*E\n"})
public final class StreamPlayExtractor$invokeModflix$$inlined$safeAmap$default$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Unit>>, Object> {
    final /* synthetic */ String $aTag$inlined;
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
    public StreamPlayExtractor$invokeModflix$$inlined$safeAmap$default$1(int i, Iterable iterable, Continuation continuation, String str, Integer num, Integer num2, Function1 function1, Function1 function2) {
        super(2, continuation);
        this.$concurrency = i;
        this.$this_runCatching = iterable;
        this.$aTag$inlined = str;
        this.$season$inlined = num;
        this.$episode$inlined = num2;
        this.$subtitleCallback$inlined = function1;
        this.$callback$inlined = function2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> streamPlayExtractor$invokeModflix$$inlined$safeAmap$default$1 = new StreamPlayExtractor$invokeModflix$$inlined$safeAmap$default$1(this.$concurrency, this.$this_runCatching, continuation, this.$aTag$inlined, this.$season$inlined, this.$episode$inlined, this.$subtitleCallback$inlined, this.$callback$inlined);
        streamPlayExtractor$invokeModflix$$inlined$safeAmap$default$1.L$0 = obj;
        return streamPlayExtractor$invokeModflix$$inlined$safeAmap$default$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends Unit>> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: renamed from: com.phisher98.StreamPlayExtractor$invokeModflix$$inlined$safeAmap$default$1$1 */
    /* JADX INFO: compiled from: StreamPlayUtils.kt */
    @Metadata(d1 = {"\u0000\n\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", "B", "Lkotlinx/coroutines/CoroutineScope;", "com/phisher98/StreamPlayUtilsKt$safeAmap$2$1$1$1"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StreamPlayExtractor$invokeModflix$$inlined$safeAmap$default$1$1", f = "StreamPlayExtractor.kt", i = {0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3}, l = {2266, 2278, 2279, 2280}, m = "invokeSuspend", n = {"$this$withPermit$iv", "$this$withPermit$iv", "$completion", "it", "selector", "link", "$this$withPermit$iv", "$completion", "it", "selector", "source", "link", "$this$withPermit$iv", "$completion", "it", "selector", "source", "bypassedLink", "link"}, nl = {2267, 2279, 2280, 2282}, s = {"L$0", "L$0", "L$2", "L$3", "L$4", "L$5", "L$0", "L$2", "L$3", "L$4", "L$5", "L$6", "L$0", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7"}, v = 2)
    @SourceDebugExtension({"SMAP\nStreamPlayUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1$1$1\n+ 2 Semaphore.kt\nkotlinx/coroutines/sync/SemaphoreKt\n+ 3 StreamPlayExtractor.kt\ncom/phisher98/StreamPlayExtractor\n*L\n1#1,2265:1\n81#2,3:2266\n85#2,2:2283\n2403#3,2:2269\n2402#3,12:2271\n*S KotlinDebug\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1$1$1\n*L\n1889#1:2266,3\n1889#1:2283,2\n*E\n"})
    public static final class C01791 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $aTag$inlined;
        final /* synthetic */ Function1 $callback$inlined;
        final /* synthetic */ Integer $episode$inlined;
        final /* synthetic */ Object $item;
        final /* synthetic */ Integer $season$inlined;
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
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C01791(Semaphore semaphore, Object obj, Continuation continuation, String str, Integer num, Integer num2, Function1 function1, Function1 function2) {
            super(2, continuation);
            this.$semaphore = semaphore;
            this.$item = obj;
            this.$aTag$inlined = str;
            this.$season$inlined = num;
            this.$episode$inlined = num2;
            this.$subtitleCallback$inlined = function1;
            this.$callback$inlined = function2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C01791(this.$semaphore, this.$item, continuation, this.$aTag$inlined, this.$season$inlined, this.$episode$inlined, this.$subtitleCallback$inlined, this.$callback$inlined);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:114:0x00e9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:41:0x0125  */
        /* JADX WARN: Code duplicated, block: B:44:0x012d  */
        /* JADX WARN: Code duplicated, block: B:46:0x0130 A[Catch: all -> 0x02cc, Exception -> 0x02d4, TRY_ENTER, TryCatch #14 {Exception -> 0x02d4, all -> 0x02cc, blocks: (B:27:0x00d2, B:42:0x0127, B:47:0x0149, B:52:0x0157, B:46:0x0130), top: B:112:0x00d2 }] */
        /* JADX WARN: Code duplicated, block: B:49:0x0153  */
        /* JADX WARN: Code duplicated, block: B:50:0x0154  */
        /* JADX WARN: Code duplicated, block: B:52:0x0157 A[Catch: all -> 0x02cc, Exception -> 0x02d4, TRY_LEAVE, TryCatch #14 {Exception -> 0x02d4, all -> 0x02cc, blocks: (B:27:0x00d2, B:42:0x0127, B:47:0x0149, B:52:0x0157, B:46:0x0130), top: B:112:0x00d2 }] */
        /* JADX WARN: Code duplicated, block: B:57:0x01ad A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:58:0x01ae  */
        /* JADX WARN: Code duplicated, block: B:61:0x01c9 A[Catch: all -> 0x029f, Exception -> 0x02a4, TryCatch #10 {Exception -> 0x02a4, all -> 0x029f, blocks: (B:59:0x01bd, B:61:0x01c9, B:64:0x01d1, B:83:0x0296), top: B:119:0x01bd }] */
        /* JADX WARN: Code duplicated, block: B:72:0x0259 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:73:0x025a  */
        /* JADX WARN: Code duplicated, block: B:89:0x02a9  */
        /* JADX WARN: Not initialized variable reg: 24, insn: 0x02c5: MOVE (r11 I:??[OBJECT, ARRAY]) = (r24 I:??[OBJECT, ARRAY]), block:B:96:0x02c3 */
        /* JADX WARN: Not initialized variable reg: 25, insn: 0x02bd: MOVE (r12 I:??[OBJECT, ARRAY]) = (r25 I:??[OBJECT, ARRAY] A[D('$this$withPermit$iv' kotlinx.coroutines.sync.Semaphore)]), block:B:94:0x02bd */
        /* JADX WARN: Not initialized variable reg: 25, insn: 0x02c7: MOVE (r12 I:??[OBJECT, ARRAY]) = (r25 I:??[OBJECT, ARRAY] A[D('$this$withPermit$iv' kotlinx.coroutines.sync.Semaphore)]), block:B:96:0x02c3 */
        /* JADX WARN: Not initialized variable reg: 27, insn: 0x02bf: MOVE (r1 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r27 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('$i$f$withPermit' int)]), block:B:94:0x02bd */
        /* JADX WARN: Not initialized variable reg: 27, insn: 0x02c9: MOVE (r1 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r27 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('$i$f$withPermit' int)]), block:B:96:0x02c3 */
        public final Object invokeSuspend(Object $result) throws Throwable {
            Object obj;
            Semaphore $this$withPermit$iv;
            Object obj2;
            Semaphore $this$withPermit$iv2;
            Object obj3;
            Object obj4;
            Semaphore $this$withPermit$iv3;
            Semaphore $this$withPermit$iv4;
            Continuation $completion;
            Element it;
            Element elementNextElementSibling;
            Elements elementsSelect;
            String strAttr;
            String link;
            String selector;
            Semaphore $this$withPermit$iv5;
            Object obj5;
            Semaphore $this$withPermit$iv6;
            Object obj6;
            Semaphore $this$withPermit$iv7;
            String link2;
            String selector2;
            Semaphore semaphore;
            String str;
            Object obj7;
            String link3;
            String link4;
            Element it2;
            Continuation $completion2;
            int i;
            String selector3;
            Element elementSelectFirst;
            String source;
            Object objBypassHrefli;
            String source2;
            Continuation $completion3;
            Object obj8;
            String str2;
            int i2;
            Semaphore $this$withPermit$iv8;
            String link5;
            String selector4;
            Element it3;
            Semaphore $this$withPermit$iv9;
            Object objLoadSourceNameExtractor$default;
            String str3;
            Semaphore $this$withPermit$iv10;
            Object obj9;
            C01791 c01791 = this;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            String str4 = "href";
            boolean z = true;
            try {
                try {
                    switch (c01791.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            Semaphore $this$withPermit$iv11 = c01791.$semaphore;
                            obj4 = c01791.$item;
                            c01791.L$0 = $this$withPermit$iv11;
                            c01791.L$1 = obj4;
                            c01791.label = 1;
                            if ($this$withPermit$iv11.acquire((Continuation) c01791) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            $this$withPermit$iv3 = $this$withPermit$iv11;
                            $this$withPermit$iv4 = null;
                            try {
                                $completion = (Continuation) c01791;
                                it = (Element) obj4;
                                elementNextElementSibling = it.nextElementSibling();
                                if (elementNextElementSibling != null) {
                                    try {
                                        elementsSelect = elementNextElementSibling.select("a:contains(" + c01791.$aTag$inlined + ')');
                                        if (elementsSelect != null || (strAttr = elementsSelect.attr("href")) == null || (link = StringsKt.substringAfter$default(strAttr, "=", (String) null, 2, (Object) null)) == null) {
                                            link = "";
                                        }
                                        if (c01791.$season$inlined == null) {
                                            selector = "p a.maxbutton";
                                        } else {
                                            selector = "h3 a:matches(Episode " + c01791.$episode$inlined + ')';
                                        }
                                        if (link.length() > 0) {
                                            z = false;
                                        }
                                        try {
                                            if (z) {
                                                Requests app = MainActivityKt.getApp();
                                                c01791.L$0 = $this$withPermit$iv3;
                                                c01791.L$1 = obj4;
                                                c01791.L$2 = SpillingKt.nullOutSpilledVariable($completion);
                                                c01791.L$3 = SpillingKt.nullOutSpilledVariable(it);
                                                c01791.L$4 = selector;
                                                c01791.L$5 = SpillingKt.nullOutSpilledVariable(link);
                                                c01791.label = 2;
                                                obj6 = obj4;
                                                $this$withPermit$iv7 = $this$withPermit$iv3;
                                                link2 = link;
                                                selector2 = selector;
                                                obj = null;
                                                semaphore = $this$withPermit$iv4;
                                                str = "href";
                                                obj7 = Requests.get$default(app, link2, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, this, 4094, (Object) null);
                                                c01791 = this;
                                                if (obj7 == coroutine_suspended) {
                                                    return coroutine_suspended;
                                                }
                                                link3 = link2;
                                                link4 = null;
                                                it2 = it;
                                                $completion2 = $completion;
                                                i = 0;
                                                obj2 = obj6;
                                                $this$withPermit$iv = $this$withPermit$iv7;
                                                selector3 = selector2;
                                                try {
                                                    elementSelectFirst = ((NiceResponse) obj7).getDocument().selectFirst(selector3);
                                                    if (elementSelectFirst != null || (source = elementSelectFirst.attr(str)) == null) {
                                                        obj3 = Unit.INSTANCE;
                                                        $this$withPermit$iv2 = $this$withPermit$iv;
                                                    } else {
                                                        c01791.L$0 = $this$withPermit$iv;
                                                        c01791.L$1 = obj2;
                                                        c01791.L$2 = SpillingKt.nullOutSpilledVariable($completion2);
                                                        c01791.L$3 = SpillingKt.nullOutSpilledVariable(it2);
                                                        c01791.L$4 = SpillingKt.nullOutSpilledVariable(selector3);
                                                        c01791.L$5 = SpillingKt.nullOutSpilledVariable(source);
                                                        c01791.L$6 = SpillingKt.nullOutSpilledVariable(link3);
                                                        c01791.label = 3;
                                                        objBypassHrefli = StreamPlayUtilsKt.bypassHrefli(source, c01791);
                                                        if (objBypassHrefli == coroutine_suspended) {
                                                            return coroutine_suspended;
                                                        }
                                                        source2 = source;
                                                        $completion3 = $completion2;
                                                        obj8 = obj2;
                                                        str2 = link4;
                                                        i2 = i;
                                                        $this$withPermit$iv8 = $this$withPermit$iv;
                                                        link5 = link3;
                                                        selector4 = selector3;
                                                        it3 = it2;
                                                        try {
                                                            String bypassedLink = String.valueOf(objBypassHrefli);
                                                            Function1 function1 = c01791.$subtitleCallback$inlined;
                                                            Function1 function2 = c01791.$callback$inlined;
                                                            c01791.L$0 = $this$withPermit$iv8;
                                                            c01791.L$1 = obj8;
                                                            c01791.L$2 = SpillingKt.nullOutSpilledVariable($completion3);
                                                            c01791.L$3 = SpillingKt.nullOutSpilledVariable(it3);
                                                            c01791.L$4 = SpillingKt.nullOutSpilledVariable(selector4);
                                                            c01791.L$5 = SpillingKt.nullOutSpilledVariable(source2);
                                                            c01791.L$6 = SpillingKt.nullOutSpilledVariable(bypassedLink);
                                                            c01791.L$7 = SpillingKt.nullOutSpilledVariable(link5);
                                                            c01791.label = 4;
                                                            Object obj10 = obj8;
                                                            $this$withPermit$iv9 = $this$withPermit$iv8;
                                                            try {
                                                                objLoadSourceNameExtractor$default = StreamPlayUtilsKt.loadSourceNameExtractor$default("Moviesmod", bypassedLink, "", function1, function2, null, null, c01791, 96, null);
                                                                if (objLoadSourceNameExtractor$default == coroutine_suspended) {
                                                                    return coroutine_suspended;
                                                                }
                                                                str3 = str2;
                                                                $this$withPermit$iv10 = $this$withPermit$iv9;
                                                                obj9 = objLoadSourceNameExtractor$default;
                                                                obj3 = obj9;
                                                                $this$withPermit$iv2 = $this$withPermit$iv10;
                                                            } catch (Exception e) {
                                                                e = e;
                                                                str4 = str2;
                                                                $this$withPermit$iv = $this$withPermit$iv9;
                                                                obj2 = obj10;
                                                                Log.INSTANCE.e("safeMap", "Request failed for " + obj2 + ' ' + e);
                                                                $this$withPermit$iv2 = $this$withPermit$iv;
                                                                obj3 = obj;
                                                            } catch (Throwable th) {
                                                                th = th;
                                                                $this$withPermit$iv = $this$withPermit$iv9;
                                                                $this$withPermit$iv.release();
                                                                throw th;
                                                            }
                                                        } catch (Exception e2) {
                                                            e = e2;
                                                            str4 = str2;
                                                            $this$withPermit$iv = $this$withPermit$iv8;
                                                            obj2 = obj8;
                                                        } catch (Throwable th2) {
                                                            th = th2;
                                                            $this$withPermit$iv = $this$withPermit$iv8;
                                                        }
                                                    }
                                                } catch (Exception e3) {
                                                    e = e3;
                                                    str4 = link4;
                                                    Log.INSTANCE.e("safeMap", "Request failed for " + obj2 + ' ' + e);
                                                    $this$withPermit$iv2 = $this$withPermit$iv;
                                                    obj3 = obj;
                                                    $this$withPermit$iv2.release();
                                                    return obj3;
                                                } catch (Throwable th3) {
                                                    th = th3;
                                                    $this$withPermit$iv.release();
                                                    throw th;
                                                }
                                            } else {
                                                Semaphore $this$withPermit$iv12 = $this$withPermit$iv3;
                                                obj3 = Unit.INSTANCE;
                                                $this$withPermit$iv2 = $this$withPermit$iv12;
                                            }
                                        } catch (Exception e4) {
                                            e = e4;
                                            str4 = null;
                                            obj2 = obj5;
                                            $this$withPermit$iv = $this$withPermit$iv6;
                                            Log.INSTANCE.e("safeMap", "Request failed for " + obj2 + ' ' + e);
                                            $this$withPermit$iv2 = $this$withPermit$iv;
                                            obj3 = obj;
                                            $this$withPermit$iv2.release();
                                            return obj3;
                                        } catch (Throwable th4) {
                                            th = th4;
                                            $this$withPermit$iv = $this$withPermit$iv5;
                                            $this$withPermit$iv.release();
                                            throw th;
                                        }
                                    } catch (Exception e5) {
                                        e = e5;
                                        obj = null;
                                        obj2 = obj4;
                                        $this$withPermit$iv = $this$withPermit$iv3;
                                        str4 = null;
                                        Log.INSTANCE.e("safeMap", "Request failed for " + obj2 + ' ' + e);
                                        $this$withPermit$iv2 = $this$withPermit$iv;
                                        obj3 = obj;
                                        $this$withPermit$iv2.release();
                                        return obj3;
                                    } catch (Throwable th5) {
                                        th = th5;
                                        $this$withPermit$iv = $this$withPermit$iv3;
                                        $this$withPermit$iv.release();
                                        throw th;
                                    }
                                } else {
                                    link = "";
                                    if (c01791.$season$inlined == null) {
                                        selector = "p a.maxbutton";
                                    } else {
                                        selector = "h3 a:matches(Episode " + c01791.$episode$inlined + ')';
                                    }
                                    if (link.length() > 0) {
                                        z = false;
                                    }
                                    if (z) {
                                        Requests app2 = MainActivityKt.getApp();
                                        c01791.L$0 = $this$withPermit$iv3;
                                        c01791.L$1 = obj4;
                                        c01791.L$2 = SpillingKt.nullOutSpilledVariable($completion);
                                        c01791.L$3 = SpillingKt.nullOutSpilledVariable(it);
                                        c01791.L$4 = selector;
                                        c01791.L$5 = SpillingKt.nullOutSpilledVariable(link);
                                        c01791.label = 2;
                                        obj6 = obj4;
                                        $this$withPermit$iv7 = $this$withPermit$iv3;
                                        link2 = link;
                                        selector2 = selector;
                                        obj = null;
                                        semaphore = $this$withPermit$iv4;
                                        str = "href";
                                        obj7 = Requests.get$default(app2, link2, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, this, 4094, (Object) null);
                                        c01791 = this;
                                        if (obj7 == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        link3 = link2;
                                        link4 = null;
                                        it2 = it;
                                        $completion2 = $completion;
                                        i = 0;
                                        obj2 = obj6;
                                        $this$withPermit$iv = $this$withPermit$iv7;
                                        selector3 = selector2;
                                        elementSelectFirst = ((NiceResponse) obj7).getDocument().selectFirst(selector3);
                                        if (elementSelectFirst != null) {
                                        }
                                        obj3 = Unit.INSTANCE;
                                        $this$withPermit$iv2 = $this$withPermit$iv;
                                    } else {
                                        Semaphore $this$withPermit$iv13 = $this$withPermit$iv3;
                                        obj3 = Unit.INSTANCE;
                                        $this$withPermit$iv2 = $this$withPermit$iv13;
                                    }
                                }
                            } catch (Exception e6) {
                                e = e6;
                                obj = null;
                                str4 = null;
                                obj2 = obj4;
                                $this$withPermit$iv = $this$withPermit$iv3;
                            } catch (Throwable th6) {
                                th = th6;
                                $this$withPermit$iv = $this$withPermit$iv3;
                            }
                            $this$withPermit$iv2.release();
                            return obj3;
                        case 1:
                            $this$withPermit$iv4 = null;
                            obj4 = c01791.L$1;
                            $this$withPermit$iv3 = (Semaphore) c01791.L$0;
                            ResultKt.throwOnFailure($result);
                            $completion = (Continuation) c01791;
                            it = (Element) obj4;
                            elementNextElementSibling = it.nextElementSibling();
                            if (elementNextElementSibling != null) {
                                elementsSelect = elementNextElementSibling.select("a:contains(" + c01791.$aTag$inlined + ')');
                                if (elementsSelect != null) {
                                    link = "";
                                } else {
                                    link = "";
                                }
                                if (c01791.$season$inlined == null) {
                                    selector = "p a.maxbutton";
                                } else {
                                    selector = "h3 a:matches(Episode " + c01791.$episode$inlined + ')';
                                }
                                if (link.length() > 0) {
                                    z = false;
                                }
                                if (z) {
                                    Requests app3 = MainActivityKt.getApp();
                                    c01791.L$0 = $this$withPermit$iv3;
                                    c01791.L$1 = obj4;
                                    c01791.L$2 = SpillingKt.nullOutSpilledVariable($completion);
                                    c01791.L$3 = SpillingKt.nullOutSpilledVariable(it);
                                    c01791.L$4 = selector;
                                    c01791.L$5 = SpillingKt.nullOutSpilledVariable(link);
                                    c01791.label = 2;
                                    obj6 = obj4;
                                    $this$withPermit$iv7 = $this$withPermit$iv3;
                                    link2 = link;
                                    selector2 = selector;
                                    obj = null;
                                    semaphore = $this$withPermit$iv4;
                                    str = "href";
                                    obj7 = Requests.get$default(app3, link2, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, this, 4094, (Object) null);
                                    c01791 = this;
                                    if (obj7 == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    link3 = link2;
                                    link4 = null;
                                    it2 = it;
                                    $completion2 = $completion;
                                    i = 0;
                                    obj2 = obj6;
                                    $this$withPermit$iv = $this$withPermit$iv7;
                                    selector3 = selector2;
                                    elementSelectFirst = ((NiceResponse) obj7).getDocument().selectFirst(selector3);
                                    if (elementSelectFirst != null) {
                                    }
                                    obj3 = Unit.INSTANCE;
                                    $this$withPermit$iv2 = $this$withPermit$iv;
                                } else {
                                    Semaphore $this$withPermit$iv14 = $this$withPermit$iv3;
                                    obj3 = Unit.INSTANCE;
                                    $this$withPermit$iv2 = $this$withPermit$iv14;
                                }
                            } else {
                                link = "";
                                if (c01791.$season$inlined == null) {
                                    selector = "p a.maxbutton";
                                } else {
                                    selector = "h3 a:matches(Episode " + c01791.$episode$inlined + ')';
                                }
                                if (link.length() > 0) {
                                    z = false;
                                }
                                if (z) {
                                    Requests app4 = MainActivityKt.getApp();
                                    c01791.L$0 = $this$withPermit$iv3;
                                    c01791.L$1 = obj4;
                                    c01791.L$2 = SpillingKt.nullOutSpilledVariable($completion);
                                    c01791.L$3 = SpillingKt.nullOutSpilledVariable(it);
                                    c01791.L$4 = selector;
                                    c01791.L$5 = SpillingKt.nullOutSpilledVariable(link);
                                    c01791.label = 2;
                                    obj6 = obj4;
                                    $this$withPermit$iv7 = $this$withPermit$iv3;
                                    link2 = link;
                                    selector2 = selector;
                                    obj = null;
                                    semaphore = $this$withPermit$iv4;
                                    str = "href";
                                    obj7 = Requests.get$default(app4, link2, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, this, 4094, (Object) null);
                                    c01791 = this;
                                    if (obj7 == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    link3 = link2;
                                    link4 = null;
                                    it2 = it;
                                    $completion2 = $completion;
                                    i = 0;
                                    obj2 = obj6;
                                    $this$withPermit$iv = $this$withPermit$iv7;
                                    selector3 = selector2;
                                    elementSelectFirst = ((NiceResponse) obj7).getDocument().selectFirst(selector3);
                                    if (elementSelectFirst != null) {
                                    }
                                    obj3 = Unit.INSTANCE;
                                    $this$withPermit$iv2 = $this$withPermit$iv;
                                } else {
                                    Semaphore $this$withPermit$iv15 = $this$withPermit$iv3;
                                    obj3 = Unit.INSTANCE;
                                    $this$withPermit$iv2 = $this$withPermit$iv15;
                                }
                            }
                            $this$withPermit$iv2.release();
                            return obj3;
                        case 2:
                            link4 = null;
                            i = 0;
                            link3 = (String) c01791.L$5;
                            selector3 = (String) c01791.L$4;
                            it2 = (Element) c01791.L$3;
                            $completion2 = (Continuation) c01791.L$2;
                            obj2 = c01791.L$1;
                            $this$withPermit$iv = (Semaphore) c01791.L$0;
                            try {
                                ResultKt.throwOnFailure($result);
                                semaphore = null;
                                str = "href";
                                obj = null;
                                obj7 = $result;
                                elementSelectFirst = ((NiceResponse) obj7).getDocument().selectFirst(selector3);
                                if (elementSelectFirst != null) {
                                }
                                obj3 = Unit.INSTANCE;
                                $this$withPermit$iv2 = $this$withPermit$iv;
                            } catch (Exception e7) {
                                e = e7;
                                str4 = null;
                                obj = null;
                                Log.INSTANCE.e("safeMap", "Request failed for " + obj2 + ' ' + e);
                                $this$withPermit$iv2 = $this$withPermit$iv;
                                obj3 = obj;
                                $this$withPermit$iv2.release();
                                return obj3;
                            }
                            $this$withPermit$iv2.release();
                            return obj3;
                        case 3:
                            String link6 = (String) c01791.L$6;
                            String source3 = (String) c01791.L$5;
                            String selector5 = (String) c01791.L$4;
                            Element it4 = (Element) c01791.L$3;
                            Continuation $completion4 = (Continuation) c01791.L$2;
                            Object obj11 = c01791.L$1;
                            Semaphore $this$withPermit$iv16 = (Semaphore) c01791.L$0;
                            ResultKt.throwOnFailure($result);
                            semaphore = null;
                            obj = null;
                            source2 = source3;
                            $completion3 = $completion4;
                            obj8 = obj11;
                            str2 = null;
                            i2 = 0;
                            $this$withPermit$iv8 = $this$withPermit$iv16;
                            objBypassHrefli = $result;
                            link5 = link6;
                            selector4 = selector5;
                            it3 = it4;
                            String bypassedLink2 = String.valueOf(objBypassHrefli);
                            Function1 function3 = c01791.$subtitleCallback$inlined;
                            Function1 function4 = c01791.$callback$inlined;
                            c01791.L$0 = $this$withPermit$iv8;
                            c01791.L$1 = obj8;
                            c01791.L$2 = SpillingKt.nullOutSpilledVariable($completion3);
                            c01791.L$3 = SpillingKt.nullOutSpilledVariable(it3);
                            c01791.L$4 = SpillingKt.nullOutSpilledVariable(selector4);
                            c01791.L$5 = SpillingKt.nullOutSpilledVariable(source2);
                            c01791.L$6 = SpillingKt.nullOutSpilledVariable(bypassedLink2);
                            c01791.L$7 = SpillingKt.nullOutSpilledVariable(link5);
                            c01791.label = 4;
                            Object obj12 = obj8;
                            $this$withPermit$iv9 = $this$withPermit$iv8;
                            objLoadSourceNameExtractor$default = StreamPlayUtilsKt.loadSourceNameExtractor$default("Moviesmod", bypassedLink2, "", function3, function4, null, null, c01791, 96, null);
                            if (objLoadSourceNameExtractor$default == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            str3 = str2;
                            $this$withPermit$iv10 = $this$withPermit$iv9;
                            obj9 = objLoadSourceNameExtractor$default;
                            obj3 = obj9;
                            $this$withPermit$iv2 = $this$withPermit$iv10;
                            $this$withPermit$iv2.release();
                            return obj3;
                        case 4:
                            str3 = null;
                            Object obj13 = c01791.L$1;
                            $this$withPermit$iv10 = (Semaphore) c01791.L$0;
                            ResultKt.throwOnFailure($result);
                            semaphore = null;
                            obj9 = $result;
                            obj3 = obj9;
                            $this$withPermit$iv2 = $this$withPermit$iv10;
                            $this$withPermit$iv2.release();
                            return obj3;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } catch (Exception e8) {
                    e = e8;
                    obj = null;
                }
            } catch (Throwable th7) {
                th = th7;
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
                    destination$iv$iv2.add(BuildersKt.async$default($this$coroutineScope, Dispatchers.getIO(), (CoroutineStart) null, new C01791(semaphore, item$iv$iv, null, this.$aTag$inlined, this.$season$inlined, this.$episode$inlined, this.$subtitleCallback$inlined, this.$callback$inlined), 2, (Object) null));
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
