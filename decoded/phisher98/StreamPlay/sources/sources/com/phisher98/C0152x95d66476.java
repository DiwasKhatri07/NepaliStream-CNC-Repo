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
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/* JADX INFO: renamed from: com.phisher98.StreamPlayExtractor$invokeFilmyfiy$lambda$1$$inlined$safeAmap$default$1 */
/* JADX INFO: compiled from: StreamPlayUtils.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/StreamPlay/classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\b\u00028\u00000\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "com/phisher98/StreamPlayUtilsKt$safeAmap$2$1"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.phisher98.StreamPlayExtractor$invokeFilmyfiy$lambda$1$$inlined$safeAmap$default$1", f = "StreamPlayExtractor.kt", i = {0, 0}, l = {1898}, m = "invokeSuspend", n = {"$this$coroutineScope", "semaphore"}, nl = {-1}, s = {"L$0", "L$1"}, v = 2)
@SourceDebugExtension({"SMAP\nStreamPlayUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,2265:1\n1739#2:2266\n1814#2,3:2267\n*S KotlinDebug\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1\n*L\n1887#1:2266\n1887#1:2267,3\n*E\n"})
public final class C0152x95d66476 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Result<? extends List<? extends Boolean>>>>, Object> {
    final /* synthetic */ String $baseUrl$inlined;
    final /* synthetic */ Function1 $callback$inlined;
    final /* synthetic */ int $concurrency;
    final /* synthetic */ Function1 $subtitleCallback$inlined;
    final /* synthetic */ Iterable $this_runCatching;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0152x95d66476(int i, Iterable iterable, Continuation continuation, String str, Function1 function1, Function1 function2) {
        super(2, continuation);
        this.$concurrency = i;
        this.$this_runCatching = iterable;
        this.$baseUrl$inlined = str;
        this.$subtitleCallback$inlined = function1;
        this.$callback$inlined = function2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> c0152x95d66476 = new C0152x95d66476(this.$concurrency, this.$this_runCatching, continuation, this.$baseUrl$inlined, this.$subtitleCallback$inlined, this.$callback$inlined);
        c0152x95d66476.L$0 = obj;
        return c0152x95d66476;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends Result<? extends List<? extends Boolean>>>> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: renamed from: com.phisher98.StreamPlayExtractor$invokeFilmyfiy$lambda$1$$inlined$safeAmap$default$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: StreamPlayUtils.kt */
    @Metadata(d1 = {"\u0000\n\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", "B", "Lkotlinx/coroutines/CoroutineScope;", "com/phisher98/StreamPlayUtilsKt$safeAmap$2$1$1$1"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StreamPlayExtractor$invokeFilmyfiy$lambda$1$$inlined$safeAmap$default$1$1", f = "StreamPlayExtractor.kt", i = {0, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2}, l = {2266, 2269, 2292}, m = "invokeSuspend", n = {"$this$withPermit$iv", "$this$withPermit$iv", "$completion", "dlBtnUrl", "$this$withPermit$iv", "$completion", "dlBtnUrl", "dlDoc", "$this$safeAmap_u24default$iv", "$completion$iv", "$this$safeAmap_u24lambda_u240$iv", "concurrency$iv"}, nl = {2267, 2272, 2293}, s = {"L$0", "L$0", "L$2", "L$3", "L$0", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "I$0"}, v = 2)
    @SourceDebugExtension({"SMAP\nStreamPlayUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1$1$1\n+ 2 Semaphore.kt\nkotlinx/coroutines/sync/SemaphoreKt\n+ 3 StreamPlayExtractor.kt\ncom/phisher98/StreamPlayExtractor\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 5 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 6 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt\n*L\n1#1,2265:1\n81#2,3:2266\n85#2,2:2296\n4962#3,4:2269\n4967#3:2295\n1795#4,10:2273\n2068#4:2283\n2069#4:2286\n1805#4:2287\n1#5:2284\n1#5:2285\n1880#6,5:2288\n1899#6,2:2293\n*S KotlinDebug\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1$1$1\n+ 2 StreamPlayExtractor.kt\ncom/phisher98/StreamPlayExtractor\n*L\n1889#1:2266,3\n1889#1:2296,2\n4964#2:2273,10\n4964#2:2283\n4964#2:2286\n4964#2:2287\n4964#2:2285\n4965#2:2288,5\n4965#2:2293,2\n*E\n"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends List<? extends Boolean>>>, Object> {
        final /* synthetic */ String $baseUrl$inlined;
        final /* synthetic */ Function1 $callback$inlined;
        final /* synthetic */ Object $item;
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
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Semaphore semaphore, Object obj, Continuation continuation, String str, Function1 function1, Function1 function2) {
            super(2, continuation);
            this.$semaphore = semaphore;
            this.$item = obj;
            this.$baseUrl$inlined = str;
            this.$subtitleCallback$inlined = function1;
            this.$callback$inlined = function2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$semaphore, this.$item, continuation, this.$baseUrl$inlined, this.$subtitleCallback$inlined, this.$callback$inlined);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends List<? extends Boolean>>> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:26:0x00c2 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:27:0x00c3  */
        /* JADX WARN: Code duplicated, block: B:31:0x00f4 A[Catch: all -> 0x01cb, Exception -> 0x01cf, TryCatch #12 {Exception -> 0x01cf, all -> 0x01cb, blocks: (B:28:0x00cb, B:29:0x00ee, B:31:0x00f4, B:36:0x0120, B:38:0x0127), top: B:87:0x00cb }] */
        /* JADX WARN: Code duplicated, block: B:33:0x011c  */
        /* JADX WARN: Code duplicated, block: B:34:0x011d  */
        /* JADX WARN: Code duplicated, block: B:36:0x0120 A[Catch: all -> 0x01cb, Exception -> 0x01cf, TryCatch #12 {Exception -> 0x01cf, all -> 0x01cb, blocks: (B:28:0x00cb, B:29:0x00ee, B:31:0x00f4, B:36:0x0120, B:38:0x0127), top: B:87:0x00cb }] */
        /* JADX WARN: Code duplicated, block: B:44:0x0190 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:45:0x0191  */
        /* JADX WARN: Code duplicated, block: B:95:0x0124 A[SYNTHETIC] */
        public final Object invokeSuspend(Object $result) throws Throwable {
            Semaphore $this$withPermit$iv;
            Semaphore $this$withPermit$iv2;
            int $i$f$withPermit;
            Object obj;
            Object obj2;
            Semaphore $this$withPermit$iv3;
            Continuation $completion;
            String dlBtnUrl;
            Object objSafeGet$default;
            String dlBtnUrl2;
            Semaphore $this$withPermit$iv4;
            Object obj3;
            Continuation $completion2;
            Iterable $this$mapNotNull$iv;
            Collection destination$iv$iv;
            Object objCoroutineScope;
            String p0;
            Object obj4;
            Result result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            try {
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        Semaphore $this$withPermit$iv5 = this.$semaphore;
                        Object obj5 = this.$item;
                        this.L$0 = $this$withPermit$iv5;
                        this.L$1 = obj5;
                        this.label = 1;
                        if ($this$withPermit$iv5.acquire((Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        $this$withPermit$iv2 = $this$withPermit$iv5;
                        $i$f$withPermit = 0;
                        obj = obj5;
                        try {
                            $completion = (Continuation) this;
                            dlBtnUrl = (String) obj;
                            this.L$0 = $this$withPermit$iv2;
                            this.L$1 = obj;
                            this.L$2 = SpillingKt.nullOutSpilledVariable($completion);
                            this.L$3 = SpillingKt.nullOutSpilledVariable(dlBtnUrl);
                            this.label = 2;
                            objSafeGet$default = StreamPlayUtilsKt.safeGet$default(dlBtnUrl, null, null, null, null, false, 0, this, 126, null);
                            if (objSafeGet$default == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            dlBtnUrl2 = dlBtnUrl;
                            $this$withPermit$iv4 = $this$withPermit$iv2;
                            obj3 = obj;
                            $completion2 = $completion;
                            try {
                                Document dlDoc = ((NiceResponse) objSafeGet$default).getDocument();
                                $this$mapNotNull$iv = dlDoc.select("div.dlink a[href]");
                                destination$iv$iv = new ArrayList();
                                for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
                                    Element it = (Element) element$iv$iv$iv;
                                    Iterable $this$mapNotNull$iv2 = $this$mapNotNull$iv;
                                    p0 = it.absUrl("href");
                                    if (StringsKt.isBlank(p0)) {
                                        p0 = null;
                                    }
                                    if (p0 != null) {
                                        destination$iv$iv.add(p0);
                                    }
                                    $this$mapNotNull$iv = $this$mapNotNull$iv2;
                                }
                                Iterable $this$safeAmap_u24default$iv = CollectionsKt.distinct((List) destination$iv$iv);
                                try {
                                    Result.Companion companion = Result.Companion;
                                    try {
                                        C0153x4a43e4c3 c0153x4a43e4c3 = new C0153x4a43e4c3(7, $this$safeAmap_u24default$iv, null, this.$baseUrl$inlined, this.$subtitleCallback$inlined, this.$callback$inlined);
                                        this.L$0 = $this$withPermit$iv4;
                                        this.L$1 = obj3;
                                        this.L$2 = SpillingKt.nullOutSpilledVariable($completion2);
                                        this.L$3 = SpillingKt.nullOutSpilledVariable(dlBtnUrl2);
                                        this.L$4 = SpillingKt.nullOutSpilledVariable(dlDoc);
                                        this.L$5 = SpillingKt.nullOutSpilledVariable($this$safeAmap_u24default$iv);
                                        this.L$6 = SpillingKt.nullOutSpilledVariable(this);
                                        this.L$7 = SpillingKt.nullOutSpilledVariable($this$safeAmap_u24default$iv);
                                        this.I$0 = 7;
                                        this.label = 3;
                                        objCoroutineScope = CoroutineScopeKt.coroutineScope(c0153x4a43e4c3, this);
                                        if (objCoroutineScope == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        obj4 = Result.constructor-impl((List) objCoroutineScope);
                                        $this$withPermit$iv3 = $this$withPermit$iv4;
                                        try {
                                            result = Result.box-impl(obj4);
                                            break;
                                        } catch (Exception e) {
                                            e = e;
                                            obj2 = obj3;
                                            Log.INSTANCE.e("safeMap", "Request failed for " + obj2 + ' ' + e);
                                            result = null;
                                        }
                                        $this$withPermit$iv3.release();
                                        return result;
                                    } catch (Throwable th) {
                                        th = th;
                                        try {
                                            Result.Companion companion2 = Result.Companion;
                                            obj4 = Result.constructor-impl(ResultKt.createFailure(th));
                                        } catch (Exception e2) {
                                            e = e2;
                                            obj2 = obj3;
                                            $this$withPermit$iv3 = $this$withPermit$iv4;
                                            Log.INSTANCE.e("safeMap", "Request failed for " + obj2 + ' ' + e);
                                            result = null;
                                            $this$withPermit$iv3.release();
                                            return result;
                                        } catch (Throwable th2) {
                                            th = th2;
                                            $this$withPermit$iv = $this$withPermit$iv4;
                                            $this$withPermit$iv.release();
                                            throw th;
                                        }
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                }
                            } catch (Exception e3) {
                                e = e3;
                                obj2 = obj3;
                                $this$withPermit$iv3 = $this$withPermit$iv4;
                                Log.INSTANCE.e("safeMap", "Request failed for " + obj2 + ' ' + e);
                                result = null;
                                $this$withPermit$iv3.release();
                                return result;
                            } catch (Throwable th4) {
                                th = th4;
                                $this$withPermit$iv = $this$withPermit$iv4;
                                $this$withPermit$iv.release();
                                throw th;
                            }
                        } catch (Exception e4) {
                            e = e4;
                            obj2 = obj;
                            $this$withPermit$iv3 = $this$withPermit$iv2;
                            Log.INSTANCE.e("safeMap", "Request failed for " + obj2 + ' ' + e);
                            result = null;
                            $this$withPermit$iv3.release();
                            return result;
                        } catch (Throwable th5) {
                            th = th5;
                            $this$withPermit$iv = $this$withPermit$iv2;
                            $this$withPermit$iv.release();
                            throw th;
                        }
                        break;
                        break;
                    case 1:
                        Object obj6 = this.L$1;
                        Semaphore $this$withPermit$iv6 = (Semaphore) this.L$0;
                        ResultKt.throwOnFailure($result);
                        $i$f$withPermit = 0;
                        $this$withPermit$iv2 = $this$withPermit$iv6;
                        obj = obj6;
                        $completion = (Continuation) this;
                        dlBtnUrl = (String) obj;
                        this.L$0 = $this$withPermit$iv2;
                        this.L$1 = obj;
                        this.L$2 = SpillingKt.nullOutSpilledVariable($completion);
                        this.L$3 = SpillingKt.nullOutSpilledVariable(dlBtnUrl);
                        this.label = 2;
                        objSafeGet$default = StreamPlayUtilsKt.safeGet$default(dlBtnUrl, null, null, null, null, false, 0, this, 126, null);
                        if (objSafeGet$default == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        dlBtnUrl2 = dlBtnUrl;
                        $this$withPermit$iv4 = $this$withPermit$iv2;
                        obj3 = obj;
                        $completion2 = $completion;
                        Document dlDoc2 = ((NiceResponse) objSafeGet$default).getDocument();
                        $this$mapNotNull$iv = dlDoc2.select("div.dlink a[href]");
                        destination$iv$iv = new ArrayList();
                        while (r18.hasNext()) {
                            Element it2 = (Element) element$iv$iv$iv;
                            Iterable $this$mapNotNull$iv3 = $this$mapNotNull$iv;
                            p0 = it2.absUrl("href");
                            if (StringsKt.isBlank(p0)) {
                                p0 = null;
                            }
                            if (p0 != null) {
                                destination$iv$iv.add(p0);
                            }
                            $this$mapNotNull$iv = $this$mapNotNull$iv3;
                        }
                        Iterable $this$safeAmap_u24default$iv2 = CollectionsKt.distinct((List) destination$iv$iv);
                        Result.Companion companion3 = Result.Companion;
                        C0153x4a43e4c3 c0153x4a43e4c4 = new C0153x4a43e4c3(7, $this$safeAmap_u24default$iv2, null, this.$baseUrl$inlined, this.$subtitleCallback$inlined, this.$callback$inlined);
                        this.L$0 = $this$withPermit$iv4;
                        this.L$1 = obj3;
                        this.L$2 = SpillingKt.nullOutSpilledVariable($completion2);
                        this.L$3 = SpillingKt.nullOutSpilledVariable(dlBtnUrl2);
                        this.L$4 = SpillingKt.nullOutSpilledVariable(dlDoc2);
                        this.L$5 = SpillingKt.nullOutSpilledVariable($this$safeAmap_u24default$iv2);
                        this.L$6 = SpillingKt.nullOutSpilledVariable(this);
                        this.L$7 = SpillingKt.nullOutSpilledVariable($this$safeAmap_u24default$iv2);
                        this.I$0 = 7;
                        this.label = 3;
                        objCoroutineScope = CoroutineScopeKt.coroutineScope(c0153x4a43e4c4, this);
                        if (objCoroutineScope == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        obj4 = Result.constructor-impl((List) objCoroutineScope);
                        $this$withPermit$iv3 = $this$withPermit$iv4;
                        result = Result.box-impl(obj4);
                        $this$withPermit$iv3.release();
                        return result;
                    case 2:
                        String dlBtnUrl3 = (String) this.L$3;
                        Continuation $completion3 = (Continuation) this.L$2;
                        obj2 = this.L$1;
                        $this$withPermit$iv3 = (Semaphore) this.L$0;
                        try {
                            ResultKt.throwOnFailure($result);
                            $i$f$withPermit = 0;
                            $completion2 = $completion3;
                            obj3 = obj2;
                            $this$withPermit$iv4 = $this$withPermit$iv3;
                            objSafeGet$default = $result;
                            dlBtnUrl2 = dlBtnUrl3;
                            Document dlDoc3 = ((NiceResponse) objSafeGet$default).getDocument();
                            $this$mapNotNull$iv = dlDoc3.select("div.dlink a[href]");
                            destination$iv$iv = new ArrayList();
                            while (r18.hasNext()) {
                                Element it3 = (Element) element$iv$iv$iv;
                                Iterable $this$mapNotNull$iv4 = $this$mapNotNull$iv;
                                p0 = it3.absUrl("href");
                                if (StringsKt.isBlank(p0)) {
                                    p0 = null;
                                }
                                if (p0 != null) {
                                    destination$iv$iv.add(p0);
                                }
                                $this$mapNotNull$iv = $this$mapNotNull$iv4;
                            }
                            Iterable $this$safeAmap_u24default$iv3 = CollectionsKt.distinct((List) destination$iv$iv);
                            Result.Companion companion4 = Result.Companion;
                            C0153x4a43e4c3 c0153x4a43e4c5 = new C0153x4a43e4c3(7, $this$safeAmap_u24default$iv3, null, this.$baseUrl$inlined, this.$subtitleCallback$inlined, this.$callback$inlined);
                            this.L$0 = $this$withPermit$iv4;
                            this.L$1 = obj3;
                            this.L$2 = SpillingKt.nullOutSpilledVariable($completion2);
                            this.L$3 = SpillingKt.nullOutSpilledVariable(dlBtnUrl2);
                            this.L$4 = SpillingKt.nullOutSpilledVariable(dlDoc3);
                            this.L$5 = SpillingKt.nullOutSpilledVariable($this$safeAmap_u24default$iv3);
                            this.L$6 = SpillingKt.nullOutSpilledVariable(this);
                            this.L$7 = SpillingKt.nullOutSpilledVariable($this$safeAmap_u24default$iv3);
                            this.I$0 = 7;
                            this.label = 3;
                            objCoroutineScope = CoroutineScopeKt.coroutineScope(c0153x4a43e4c5, this);
                            if (objCoroutineScope == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            obj4 = Result.constructor-impl((List) objCoroutineScope);
                            $this$withPermit$iv3 = $this$withPermit$iv4;
                            result = Result.box-impl(obj4);
                            $this$withPermit$iv3.release();
                            return result;
                        } catch (Exception e5) {
                            e = e5;
                            Log.INSTANCE.e("safeMap", "Request failed for " + obj2 + ' ' + e);
                            result = null;
                            $this$withPermit$iv3.release();
                            return result;
                        }
                    case 3:
                        int i = this.I$0;
                        obj3 = this.L$1;
                        $this$withPermit$iv4 = (Semaphore) this.L$0;
                        try {
                            ResultKt.throwOnFailure($result);
                            objCoroutineScope = $result;
                            obj4 = Result.constructor-impl((List) objCoroutineScope);
                            break;
                        } catch (Throwable th6) {
                            th = th6;
                            Result.Companion companion5 = Result.Companion;
                            obj4 = Result.constructor-impl(ResultKt.createFailure(th));
                            break;
                        }
                        $this$withPermit$iv3 = $this$withPermit$iv4;
                        result = Result.box-impl(obj4);
                        $this$withPermit$iv3.release();
                        return result;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
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
                    destination$iv$iv2.add(BuildersKt.async$default($this$coroutineScope, Dispatchers.getIO(), (CoroutineStart) null, new AnonymousClass1(semaphore, item$iv$iv, null, this.$baseUrl$inlined, this.$subtitleCallback$inlined, this.$callback$inlined), 2, (Object) null));
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
