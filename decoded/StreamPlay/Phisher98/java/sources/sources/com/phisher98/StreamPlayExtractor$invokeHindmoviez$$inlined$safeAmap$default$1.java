package com.phisher98;

import com.lagradost.api.Log;
import com.lagradost.nicehttp.NiceResponse;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.sync.Semaphore;
import kotlinx.coroutines.sync.SemaphoreKt;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/* JADX INFO: compiled from: StreamPlayUtils.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StreamPlay/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\b\u00028\u00000\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "com/phisher98/StreamPlayUtilsKt$safeAmap$2$1"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.phisher98.StreamPlayExtractor$invokeHindmoviez$$inlined$safeAmap$default$1", f = "StreamPlayExtractor.kt", i = {0, 0}, l = {1898}, m = "invokeSuspend", n = {"$this$coroutineScope", "semaphore"}, nl = {-1}, s = {"L$0", "L$1"}, v = 2)
@SourceDebugExtension({"SMAP\nStreamPlayUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,2265:1\n1739#2:2266\n1814#2,3:2267\n*S KotlinDebug\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1\n*L\n1887#1:2266\n1887#1:2267,3\n*E\n"})
public final class StreamPlayExtractor$invokeHindmoviez$$inlined$safeAmap$default$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Result<? extends List<? extends Unit>>>>, Object> {
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
    public StreamPlayExtractor$invokeHindmoviez$$inlined$safeAmap$default$1(int i, Iterable iterable, Continuation continuation, Integer num, Function1 function1, Function1 function2, Integer num2) {
        super(2, continuation);
        this.$concurrency = i;
        this.$this_runCatching = iterable;
        this.$episode$inlined = num;
        this.$subtitleCallback$inlined = function1;
        this.$callback$inlined = function2;
        this.$season$inlined = num2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> streamPlayExtractor$invokeHindmoviez$$inlined$safeAmap$default$1 = new StreamPlayExtractor$invokeHindmoviez$$inlined$safeAmap$default$1(this.$concurrency, this.$this_runCatching, continuation, this.$episode$inlined, this.$subtitleCallback$inlined, this.$callback$inlined, this.$season$inlined);
        streamPlayExtractor$invokeHindmoviez$$inlined$safeAmap$default$1.L$0 = obj;
        return streamPlayExtractor$invokeHindmoviez$$inlined$safeAmap$default$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends Result<? extends List<? extends Unit>>>> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: renamed from: com.phisher98.StreamPlayExtractor$invokeHindmoviez$$inlined$safeAmap$default$1$1 */
    /* JADX INFO: compiled from: StreamPlayUtils.kt */
    @Metadata(d1 = {"\u0000\n\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", "B", "Lkotlinx/coroutines/CoroutineScope;", "com/phisher98/StreamPlayUtilsKt$safeAmap$2$1$1$1"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StreamPlayExtractor$invokeHindmoviez$$inlined$safeAmap$default$1$1", f = "StreamPlayExtractor.kt", i = {0, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3}, l = {2266, 2269, 2279, 2287}, m = "invokeSuspend", n = {"$this$withPermit$iv", "$this$withPermit$iv", "$completion", "entry", "$this$withPermit$iv", "$completion", "entry", "pageDoc", "buttons", "$this$safeAmap_u24default$iv", "$completion$iv", "$this$safeAmap_u24lambda_u240$iv", "concurrency$iv", "$this$withPermit$iv", "$completion", "entry", "pageDoc", "buttons", "$this$safeAmap_u24default$iv", "$completion$iv", "$this$safeAmap_u24lambda_u240$iv", "concurrency$iv"}, nl = {2267, 2270, 2280, 2288}, s = {"L$0", "L$0", "L$2", "L$3", "L$0", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "I$0", "L$0", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "I$0"}, v = 2)
    @SourceDebugExtension({"SMAP\nStreamPlayUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1$1$1\n+ 2 Semaphore.kt\nkotlinx/coroutines/sync/SemaphoreKt\n+ 3 StreamPlayExtractor.kt\ncom/phisher98/StreamPlayExtractor\n+ 4 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt\n*L\n1#1,2265:1\n81#2,3:2266\n85#2,2:2291\n4589#3,6:2269\n4613#3:2282\n4640#3:2290\n1880#4,5:2275\n1899#4,2:2280\n1880#4,5:2283\n1899#4,2:2288\n*S KotlinDebug\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1$1$1\n+ 2 StreamPlayExtractor.kt\ncom/phisher98/StreamPlayExtractor\n*L\n1889#1:2266,3\n1889#1:2291,2\n4594#2:2275,5\n4594#2:2280,2\n4613#2:2283,5\n4613#2:2288,2\n*E\n"})
    public static final class C01621 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends List<? extends Unit>>>, Object> {
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
        public C01621(Semaphore semaphore, Object obj, Continuation continuation, Integer num, Function1 function1, Function1 function2, Integer num2) {
            super(2, continuation);
            this.$semaphore = semaphore;
            this.$item = obj;
            this.$episode$inlined = num;
            this.$subtitleCallback$inlined = function1;
            this.$callback$inlined = function2;
            this.$season$inlined = num2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C01621(this.$semaphore, this.$item, continuation, this.$episode$inlined, this.$subtitleCallback$inlined, this.$callback$inlined, this.$season$inlined);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends List<? extends Unit>>> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:31:0x0105 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:32:0x0106  */
        /* JADX WARN: Code duplicated, block: B:35:0x0121 A[Catch: all -> 0x0263, Exception -> 0x0268, TRY_LEAVE, TryCatch #17 {Exception -> 0x0268, all -> 0x0263, blocks: (B:33:0x010f, B:35:0x0121), top: B:113:0x010f }] */
        /* JADX WARN: Code duplicated, block: B:43:0x0183 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:44:0x0184  */
        /* JADX WARN: Code duplicated, block: B:59:0x01c0  */
        /* JADX WARN: Code duplicated, block: B:66:0x022a A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:67:0x022b  */
        /* JADX WARN: Not initialized variable reg: 14, insn: 0x01bc: MOVE (r5 I:??[OBJECT, ARRAY]) = (r14 I:??[OBJECT, ARRAY]), block:B:58:0x01bc */
        /* JADX WARN: Not initialized variable reg: 15, insn: 0x01b8: MOVE (r6 I:??[OBJECT, ARRAY]) = (r15 I:??[OBJECT, ARRAY] A[D('$this$withPermit$iv' kotlinx.coroutines.sync.Semaphore)]), block:B:56:0x01b8 */
        /* JADX WARN: Not initialized variable reg: 15, insn: 0x01bd: MOVE (r6 I:??[OBJECT, ARRAY]) = (r15 I:??[OBJECT, ARRAY] A[D('$this$withPermit$iv' kotlinx.coroutines.sync.Semaphore)]), block:B:58:0x01bc */
        public final Object invokeSuspend(Object $result) throws Throwable {
            Semaphore $this$withPermit$iv;
            Semaphore $this$withPermit$iv2;
            Object obj;
            Object obj2;
            Semaphore $this$withPermit$iv3;
            Result result;
            Semaphore $this$withPermit$iv4;
            int $i$f$withPermit;
            Object obj3;
            Continuation $completion;
            Element entry;
            Object objSafeGet$default;
            int $i$f$withPermit2;
            Object obj4;
            Element entry2;
            Semaphore $this$withPermit$iv5;
            Continuation $completion2;
            Document pageDoc;
            Iterable iterableSelect;
            Object objCoroutineScope;
            Object objCoroutineScope2;
            Object obj5;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            try {
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        Semaphore $this$withPermit$iv6 = this.$semaphore;
                        Object obj6 = this.$item;
                        this.L$0 = $this$withPermit$iv6;
                        this.L$1 = obj6;
                        this.label = 1;
                        if ($this$withPermit$iv6.acquire((Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        $this$withPermit$iv4 = $this$withPermit$iv6;
                        $i$f$withPermit = 0;
                        obj3 = obj6;
                        try {
                            $completion = (Continuation) this;
                            entry = (Element) obj3;
                            String strAttr = entry.attr("href");
                            Long lBoxLong = Boxing.boxLong(5000L);
                            this.L$0 = $this$withPermit$iv4;
                            this.L$1 = obj3;
                            this.L$2 = SpillingKt.nullOutSpilledVariable($completion);
                            this.L$3 = SpillingKt.nullOutSpilledVariable(entry);
                            this.label = 2;
                            objSafeGet$default = StreamPlayUtilsKt.safeGet$default(strAttr, null, null, lBoxLong, null, false, 0, this, 118, null);
                            if (objSafeGet$default == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            $i$f$withPermit2 = $i$f$withPermit;
                            obj4 = obj3;
                            entry2 = entry;
                            $this$withPermit$iv5 = $this$withPermit$iv4;
                            $completion2 = $completion;
                            try {
                                pageDoc = ((NiceResponse) objSafeGet$default).getDocument();
                                iterableSelect = pageDoc.select("a.maxbutton");
                                if (this.$episode$inlined == null) {
                                    Iterable $this$safeAmap_u24default$iv = iterableSelect;
                                    try {
                                        Result.Companion companion = Result.Companion;
                                        try {
                                            C0164x3343ef76 c0164x3343ef76 = new C0164x3343ef76(7, $this$safeAmap_u24default$iv, null, this.$subtitleCallback$inlined, this.$callback$inlined);
                                            this.L$0 = $this$withPermit$iv5;
                                            this.L$1 = obj4;
                                            try {
                                                this.L$2 = SpillingKt.nullOutSpilledVariable($completion2);
                                                this.L$3 = SpillingKt.nullOutSpilledVariable(entry2);
                                                this.L$4 = SpillingKt.nullOutSpilledVariable(pageDoc);
                                                this.L$5 = SpillingKt.nullOutSpilledVariable(iterableSelect);
                                                this.L$6 = SpillingKt.nullOutSpilledVariable($this$safeAmap_u24default$iv);
                                                this.L$7 = SpillingKt.nullOutSpilledVariable(this);
                                                this.L$8 = SpillingKt.nullOutSpilledVariable($this$safeAmap_u24default$iv);
                                                this.I$0 = 7;
                                                this.label = 3;
                                                objCoroutineScope2 = CoroutineScopeKt.coroutineScope(c0164x3343ef76, this);
                                                if (objCoroutineScope2 == coroutine_suspended) {
                                                    return coroutine_suspended;
                                                }
                                                obj5 = Result.constructor-impl((List) objCoroutineScope2);
                                                obj2 = obj4;
                                                $this$withPermit$iv2 = $this$withPermit$iv5;
                                                result = Result.box-impl(obj5);
                                                $this$withPermit$iv2.release();
                                                return result;
                                            } catch (Throwable th) {
                                                th = th;
                                                Result.Companion companion2 = Result.Companion;
                                                obj5 = Result.constructor-impl(ResultKt.createFailure(th));
                                            }
                                        } catch (Throwable th2) {
                                            th = th2;
                                        }
                                    } catch (Throwable th3) {
                                        th = th3;
                                    }
                                } else {
                                    try {
                                        Iterable $this$safeAmap_u24default$iv2 = iterableSelect;
                                        try {
                                            Result.Companion companion3 = Result.Companion;
                                            try {
                                                C0165x3343ef77 c0165x3343ef77 = new C0165x3343ef77(7, $this$safeAmap_u24default$iv2, null, this.$season$inlined, this.$episode$inlined, this.$subtitleCallback$inlined, this.$callback$inlined);
                                                this.L$0 = $this$withPermit$iv5;
                                                this.L$1 = obj4;
                                                this.L$2 = SpillingKt.nullOutSpilledVariable($completion2);
                                                this.L$3 = SpillingKt.nullOutSpilledVariable(entry2);
                                                this.L$4 = SpillingKt.nullOutSpilledVariable(pageDoc);
                                                this.L$5 = SpillingKt.nullOutSpilledVariable(iterableSelect);
                                                this.L$6 = SpillingKt.nullOutSpilledVariable($this$safeAmap_u24default$iv2);
                                                this.L$7 = SpillingKt.nullOutSpilledVariable(this);
                                                this.L$8 = SpillingKt.nullOutSpilledVariable($this$safeAmap_u24default$iv2);
                                                this.I$0 = 7;
                                                this.label = 4;
                                                objCoroutineScope = CoroutineScopeKt.coroutineScope(c0165x3343ef77, this);
                                                if (objCoroutineScope == coroutine_suspended) {
                                                    return coroutine_suspended;
                                                }
                                                obj5 = Result.constructor-impl((List) objCoroutineScope);
                                                obj2 = obj4;
                                                $this$withPermit$iv2 = $this$withPermit$iv5;
                                                result = Result.box-impl(obj5);
                                                $this$withPermit$iv2.release();
                                                return result;
                                            } catch (Throwable th4) {
                                                th = th4;
                                                Result.Companion companion4 = Result.Companion;
                                                obj5 = Result.constructor-impl(ResultKt.createFailure(th));
                                            }
                                        } catch (Throwable th5) {
                                            th = th5;
                                        }
                                    } catch (Exception e) {
                                        e = e;
                                        obj2 = obj4;
                                        $this$withPermit$iv2 = $this$withPermit$iv5;
                                        Log.INSTANCE.e("safeMap", "Request failed for " + obj2 + ' ' + e);
                                        result = null;
                                    } catch (Throwable th6) {
                                        th = th6;
                                        $this$withPermit$iv2 = $this$withPermit$iv5;
                                        $this$withPermit$iv2.release();
                                        throw th;
                                    }
                                }
                            } catch (Exception e2) {
                                e = e2;
                                obj2 = obj4;
                                $this$withPermit$iv2 = $this$withPermit$iv5;
                            } catch (Throwable th7) {
                                th = th7;
                                $this$withPermit$iv2 = $this$withPermit$iv5;
                            }
                            Log.INSTANCE.e("safeMap", "Request failed for " + obj2 + ' ' + e);
                            result = null;
                            $this$withPermit$iv2.release();
                            return result;
                        } catch (Exception e3) {
                            e = e3;
                            obj2 = obj3;
                            $this$withPermit$iv2 = $this$withPermit$iv4;
                        } catch (Throwable th8) {
                            th = th8;
                            $this$withPermit$iv2 = $this$withPermit$iv4;
                            $this$withPermit$iv2.release();
                            throw th;
                        }
                        break;
                    case 1:
                        Object obj7 = this.L$1;
                        Semaphore $this$withPermit$iv7 = (Semaphore) this.L$0;
                        ResultKt.throwOnFailure($result);
                        $i$f$withPermit = 0;
                        $this$withPermit$iv4 = $this$withPermit$iv7;
                        obj3 = obj7;
                        $completion = (Continuation) this;
                        entry = (Element) obj3;
                        String strAttr2 = entry.attr("href");
                        Long lBoxLong2 = Boxing.boxLong(5000L);
                        this.L$0 = $this$withPermit$iv4;
                        this.L$1 = obj3;
                        this.L$2 = SpillingKt.nullOutSpilledVariable($completion);
                        this.L$3 = SpillingKt.nullOutSpilledVariable(entry);
                        this.label = 2;
                        objSafeGet$default = StreamPlayUtilsKt.safeGet$default(strAttr2, null, null, lBoxLong2, null, false, 0, this, 118, null);
                        if (objSafeGet$default == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        $i$f$withPermit2 = $i$f$withPermit;
                        obj4 = obj3;
                        entry2 = entry;
                        $this$withPermit$iv5 = $this$withPermit$iv4;
                        $completion2 = $completion;
                        pageDoc = ((NiceResponse) objSafeGet$default).getDocument();
                        iterableSelect = pageDoc.select("a.maxbutton");
                        if (this.$episode$inlined == null) {
                            Iterable $this$safeAmap_u24default$iv3 = iterableSelect;
                            Result.Companion companion5 = Result.Companion;
                            C0164x3343ef76 c0164x3343ef77 = new C0164x3343ef76(7, $this$safeAmap_u24default$iv3, null, this.$subtitleCallback$inlined, this.$callback$inlined);
                            this.L$0 = $this$withPermit$iv5;
                            this.L$1 = obj4;
                            this.L$2 = SpillingKt.nullOutSpilledVariable($completion2);
                            this.L$3 = SpillingKt.nullOutSpilledVariable(entry2);
                            this.L$4 = SpillingKt.nullOutSpilledVariable(pageDoc);
                            this.L$5 = SpillingKt.nullOutSpilledVariable(iterableSelect);
                            this.L$6 = SpillingKt.nullOutSpilledVariable($this$safeAmap_u24default$iv3);
                            this.L$7 = SpillingKt.nullOutSpilledVariable(this);
                            this.L$8 = SpillingKt.nullOutSpilledVariable($this$safeAmap_u24default$iv3);
                            this.I$0 = 7;
                            this.label = 3;
                            objCoroutineScope2 = CoroutineScopeKt.coroutineScope(c0164x3343ef77, this);
                            if (objCoroutineScope2 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            obj5 = Result.constructor-impl((List) objCoroutineScope2);
                            obj2 = obj4;
                            $this$withPermit$iv2 = $this$withPermit$iv5;
                            result = Result.box-impl(obj5);
                            $this$withPermit$iv2.release();
                            return result;
                        }
                        Iterable $this$safeAmap_u24default$iv4 = iterableSelect;
                        Result.Companion companion6 = Result.Companion;
                        C0165x3343ef77 c0165x3343ef78 = new C0165x3343ef77(7, $this$safeAmap_u24default$iv4, null, this.$season$inlined, this.$episode$inlined, this.$subtitleCallback$inlined, this.$callback$inlined);
                        this.L$0 = $this$withPermit$iv5;
                        this.L$1 = obj4;
                        this.L$2 = SpillingKt.nullOutSpilledVariable($completion2);
                        this.L$3 = SpillingKt.nullOutSpilledVariable(entry2);
                        this.L$4 = SpillingKt.nullOutSpilledVariable(pageDoc);
                        this.L$5 = SpillingKt.nullOutSpilledVariable(iterableSelect);
                        this.L$6 = SpillingKt.nullOutSpilledVariable($this$safeAmap_u24default$iv4);
                        this.L$7 = SpillingKt.nullOutSpilledVariable(this);
                        this.L$8 = SpillingKt.nullOutSpilledVariable($this$safeAmap_u24default$iv4);
                        this.I$0 = 7;
                        this.label = 4;
                        objCoroutineScope = CoroutineScopeKt.coroutineScope(c0165x3343ef78, this);
                        if (objCoroutineScope == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        obj5 = Result.constructor-impl((List) objCoroutineScope);
                        obj2 = obj4;
                        $this$withPermit$iv2 = $this$withPermit$iv5;
                        result = Result.box-impl(obj5);
                        $this$withPermit$iv2.release();
                        return result;
                        Log.INSTANCE.e("safeMap", "Request failed for " + obj2 + ' ' + e);
                        result = null;
                        $this$withPermit$iv2.release();
                        return result;
                    case 2:
                        $i$f$withPermit2 = 0;
                        Element entry3 = (Element) this.L$3;
                        Continuation $completion3 = (Continuation) this.L$2;
                        obj2 = this.L$1;
                        $this$withPermit$iv2 = (Semaphore) this.L$0;
                        try {
                            try {
                                ResultKt.throwOnFailure($result);
                                entry2 = entry3;
                                $completion2 = $completion3;
                                obj4 = obj2;
                                $this$withPermit$iv5 = $this$withPermit$iv2;
                                objSafeGet$default = $result;
                                pageDoc = ((NiceResponse) objSafeGet$default).getDocument();
                                iterableSelect = pageDoc.select("a.maxbutton");
                                if (this.$episode$inlined == null) {
                                    Iterable $this$safeAmap_u24default$iv5 = iterableSelect;
                                    Result.Companion companion7 = Result.Companion;
                                    C0164x3343ef76 c0164x3343ef78 = new C0164x3343ef76(7, $this$safeAmap_u24default$iv5, null, this.$subtitleCallback$inlined, this.$callback$inlined);
                                    this.L$0 = $this$withPermit$iv5;
                                    this.L$1 = obj4;
                                    this.L$2 = SpillingKt.nullOutSpilledVariable($completion2);
                                    this.L$3 = SpillingKt.nullOutSpilledVariable(entry2);
                                    this.L$4 = SpillingKt.nullOutSpilledVariable(pageDoc);
                                    this.L$5 = SpillingKt.nullOutSpilledVariable(iterableSelect);
                                    this.L$6 = SpillingKt.nullOutSpilledVariable($this$safeAmap_u24default$iv5);
                                    this.L$7 = SpillingKt.nullOutSpilledVariable(this);
                                    this.L$8 = SpillingKt.nullOutSpilledVariable($this$safeAmap_u24default$iv5);
                                    this.I$0 = 7;
                                    this.label = 3;
                                    objCoroutineScope2 = CoroutineScopeKt.coroutineScope(c0164x3343ef78, this);
                                    if (objCoroutineScope2 == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    obj5 = Result.constructor-impl((List) objCoroutineScope2);
                                    obj2 = obj4;
                                    $this$withPermit$iv2 = $this$withPermit$iv5;
                                    result = Result.box-impl(obj5);
                                    $this$withPermit$iv2.release();
                                    return result;
                                }
                                Iterable $this$safeAmap_u24default$iv6 = iterableSelect;
                                Result.Companion companion8 = Result.Companion;
                                C0165x3343ef77 c0165x3343ef79 = new C0165x3343ef77(7, $this$safeAmap_u24default$iv6, null, this.$season$inlined, this.$episode$inlined, this.$subtitleCallback$inlined, this.$callback$inlined);
                                this.L$0 = $this$withPermit$iv5;
                                this.L$1 = obj4;
                                this.L$2 = SpillingKt.nullOutSpilledVariable($completion2);
                                this.L$3 = SpillingKt.nullOutSpilledVariable(entry2);
                                this.L$4 = SpillingKt.nullOutSpilledVariable(pageDoc);
                                this.L$5 = SpillingKt.nullOutSpilledVariable(iterableSelect);
                                this.L$6 = SpillingKt.nullOutSpilledVariable($this$safeAmap_u24default$iv6);
                                this.L$7 = SpillingKt.nullOutSpilledVariable(this);
                                this.L$8 = SpillingKt.nullOutSpilledVariable($this$safeAmap_u24default$iv6);
                                this.I$0 = 7;
                                this.label = 4;
                                objCoroutineScope = CoroutineScopeKt.coroutineScope(c0165x3343ef79, this);
                                if (objCoroutineScope == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                obj5 = Result.constructor-impl((List) objCoroutineScope);
                                obj2 = obj4;
                                $this$withPermit$iv2 = $this$withPermit$iv5;
                                result = Result.box-impl(obj5);
                                $this$withPermit$iv2.release();
                                return result;
                            } catch (Exception e4) {
                                e = e4;
                            }
                            $this$withPermit$iv2.release();
                            return result;
                        } catch (Throwable th9) {
                            th = th9;
                            $this$withPermit$iv2.release();
                            throw th;
                        }
                        Log.INSTANCE.e("safeMap", "Request failed for " + obj2 + ' ' + e);
                        result = null;
                    case 3:
                        int i = this.I$0;
                        obj4 = this.L$1;
                        $this$withPermit$iv5 = (Semaphore) this.L$0;
                        try {
                            ResultKt.throwOnFailure($result);
                            objCoroutineScope2 = $result;
                            obj5 = Result.constructor-impl((List) objCoroutineScope2);
                            break;
                        } catch (Throwable th10) {
                            th = th10;
                            Result.Companion companion9 = Result.Companion;
                            obj5 = Result.constructor-impl(ResultKt.createFailure(th));
                        }
                        obj2 = obj4;
                        $this$withPermit$iv2 = $this$withPermit$iv5;
                        result = Result.box-impl(obj5);
                        $this$withPermit$iv2.release();
                        return result;
                    case 4:
                        int i2 = this.I$0;
                        obj4 = this.L$1;
                        $this$withPermit$iv5 = (Semaphore) this.L$0;
                        try {
                            ResultKt.throwOnFailure($result);
                            objCoroutineScope = $result;
                            obj5 = Result.constructor-impl((List) objCoroutineScope);
                            break;
                        } catch (Throwable th11) {
                            th = th11;
                            Result.Companion companion10 = Result.Companion;
                            obj5 = Result.constructor-impl(ResultKt.createFailure(th));
                        }
                        obj2 = obj4;
                        $this$withPermit$iv2 = $this$withPermit$iv5;
                        result = Result.box-impl(obj5);
                        $this$withPermit$iv2.release();
                        return result;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } catch (Exception e5) {
                e = e5;
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
                    destination$iv$iv2.add(BuildersKt.async$default($this$coroutineScope, Dispatchers.getIO(), (CoroutineStart) null, new C01621(semaphore, item$iv$iv, null, this.$episode$inlined, this.$subtitleCallback$inlined, this.$callback$inlined, this.$season$inlined), 2, (Object) null));
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
