package com.phisher98;

import com.lagradost.api.Log;
import com.lagradost.nicehttp.NiceResponse;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
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
import org.jsoup.select.Elements;

/* JADX INFO: renamed from: com.phisher98.StreamPlayExtractor$invokeMovies4u$lambda$0$$inlined$safeAmap$default$2 */
/* JADX INFO: compiled from: StreamPlayUtils.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StreamPlay/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\b\u00028\u00000\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "com/phisher98/StreamPlayUtilsKt$safeAmap$2$1"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.phisher98.StreamPlayExtractor$invokeMovies4u$lambda$0$$inlined$safeAmap$default$2", f = "StreamPlayExtractor.kt", i = {0, 0}, l = {1898}, m = "invokeSuspend", n = {"$this$coroutineScope", "semaphore"}, nl = {-1}, s = {"L$0", "L$1"}, v = 2)
@SourceDebugExtension({"SMAP\nStreamPlayUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,2265:1\n1739#2:2266\n1814#2,3:2267\n*S KotlinDebug\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1\n*L\n1887#1:2266\n1887#1:2267,3\n*E\n"})
public final class C0184x5cf40513 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Unit>>, Object> {
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
    public C0184x5cf40513(int i, Iterable iterable, Continuation continuation, Integer num, Integer num2, Function1 function1, Function1 function2) {
        super(2, continuation);
        this.$concurrency = i;
        this.$this_runCatching = iterable;
        this.$season$inlined = num;
        this.$episode$inlined = num2;
        this.$subtitleCallback$inlined = function1;
        this.$callback$inlined = function2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> c0184x5cf40513 = new C0184x5cf40513(this.$concurrency, this.$this_runCatching, continuation, this.$season$inlined, this.$episode$inlined, this.$subtitleCallback$inlined, this.$callback$inlined);
        c0184x5cf40513.L$0 = obj;
        return c0184x5cf40513;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends Unit>> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: renamed from: com.phisher98.StreamPlayExtractor$invokeMovies4u$lambda$0$$inlined$safeAmap$default$2$1, reason: invalid class name */
    /* JADX INFO: compiled from: StreamPlayUtils.kt */
    @Metadata(d1 = {"\u0000\n\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", "B", "Lkotlinx/coroutines/CoroutineScope;", "com/phisher98/StreamPlayUtilsKt$safeAmap$2$1$1$1"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StreamPlayExtractor$invokeMovies4u$lambda$0$$inlined$safeAmap$default$2$1", f = "StreamPlayExtractor.kt", i = {0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {2266, 2274, 2286}, m = "invokeSuspend", n = {"$this$withPermit$iv", "$this$withPermit$iv", "$completion", "block", "seasonLink", "headerText", "$this$withPermit$iv", "$completion", "block", "seasonLink", "headerText", "episodeBlocks", "episodeBlock", "episodeLinks", "$this$safeAmap_u24default$iv", "$completion$iv", "episodeDoc", "$this$safeAmap_u24lambda_u240$iv", "concurrency$iv"}, nl = {2267, 2275, 2287}, s = {"L$0", "L$0", "L$2", "L$3", "L$4", "L$5", "L$0", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "I$0"}, v = 2)
    @SourceDebugExtension({"SMAP\nStreamPlayUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1$1$1\n+ 2 Semaphore.kt\nkotlinx/coroutines/sync/SemaphoreKt\n+ 3 StreamPlayExtractor.kt\ncom/phisher98/StreamPlayExtractor\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 5 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt\n*L\n1#1,2265:1\n81#2,3:2266\n85#2,2:2290\n4687#3,3:2269\n4691#3,8:2274\n4710#3:2289\n296#4,2:2272\n1880#5,5:2282\n1899#5,2:2287\n*S KotlinDebug\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1$1$1\n+ 2 StreamPlayExtractor.kt\ncom/phisher98/StreamPlayExtractor\n*L\n1889#1:2266,3\n1889#1:2290,2\n4689#2:2272,2\n4698#2:2282,5\n4698#2:2287,2\n*E\n"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1 $callback$inlined;
        final /* synthetic */ Integer $episode$inlined;
        final /* synthetic */ Object $item;
        final /* synthetic */ Integer $season$inlined;
        final /* synthetic */ Semaphore $semaphore;
        final /* synthetic */ Function1 $subtitleCallback$inlined;
        int I$0;
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
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
        public AnonymousClass1(Semaphore semaphore, Object obj, Continuation continuation, Integer num, Integer num2, Function1 function1, Function1 function2) {
            super(2, continuation);
            this.$semaphore = semaphore;
            this.$item = obj;
            this.$season$inlined = num;
            this.$episode$inlined = num2;
            this.$subtitleCallback$inlined = function1;
            this.$callback$inlined = function2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$semaphore, this.$item, continuation, this.$season$inlined, this.$episode$inlined, this.$subtitleCallback$inlined, this.$callback$inlined);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:125:0x0133 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:26:0x00d8 A[Catch: all -> 0x02d6, Exception -> 0x02da, TryCatch #13 {Exception -> 0x02da, all -> 0x02d6, blocks: (B:24:0x00c8, B:26:0x00d8, B:30:0x00e2, B:32:0x0109, B:33:0x0114, B:35:0x011a, B:39:0x0134, B:41:0x0138, B:87:0x02bc, B:44:0x0144), top: B:124:0x00c8 }] */
        /* JADX WARN: Code duplicated, block: B:27:0x00dd  */
        /* JADX WARN: Code duplicated, block: B:29:0x00e0  */
        /* JADX WARN: Code duplicated, block: B:32:0x0109 A[Catch: all -> 0x02d6, Exception -> 0x02da, TryCatch #13 {Exception -> 0x02da, all -> 0x02d6, blocks: (B:24:0x00c8, B:26:0x00d8, B:30:0x00e2, B:32:0x0109, B:33:0x0114, B:35:0x011a, B:39:0x0134, B:41:0x0138, B:87:0x02bc, B:44:0x0144), top: B:124:0x00c8 }] */
        /* JADX WARN: Code duplicated, block: B:35:0x011a A[Catch: all -> 0x02d6, Exception -> 0x02da, TryCatch #13 {Exception -> 0x02da, all -> 0x02d6, blocks: (B:24:0x00c8, B:26:0x00d8, B:30:0x00e2, B:32:0x0109, B:33:0x0114, B:35:0x011a, B:39:0x0134, B:41:0x0138, B:87:0x02bc, B:44:0x0144), top: B:124:0x00c8 }] */
        /* JADX WARN: Code duplicated, block: B:41:0x0138 A[Catch: all -> 0x02d6, Exception -> 0x02da, TryCatch #13 {Exception -> 0x02da, all -> 0x02d6, blocks: (B:24:0x00c8, B:26:0x00d8, B:30:0x00e2, B:32:0x0109, B:33:0x0114, B:35:0x011a, B:39:0x0134, B:41:0x0138, B:87:0x02bc, B:44:0x0144), top: B:124:0x00c8 }] */
        /* JADX WARN: Code duplicated, block: B:50:0x019a A[Catch: all -> 0x02b0, Exception -> 0x02b4, TryCatch #3 {Exception -> 0x02b4, blocks: (B:48:0x0188, B:50:0x019a, B:55:0x01ac), top: B:111:0x0188 }] */
        /* JADX WARN: Code duplicated, block: B:55:0x01ac A[Catch: all -> 0x02b0, Exception -> 0x02b4, TRY_LEAVE, TryCatch #3 {Exception -> 0x02b4, blocks: (B:48:0x0188, B:50:0x019a, B:55:0x01ac), top: B:111:0x0188 }] */
        /* JADX WARN: Code duplicated, block: B:63:0x023b A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:64:0x023c  */
        /* JADX WARN: Code duplicated, block: B:86:0x02ba A[ADDED_TO_REGION, REMOVE] */
        /* JADX WARN: Code duplicated, block: B:89:0x02c4  */
        public final Object invokeSuspend(Object $result) throws Throwable {
            Semaphore $this$withPermit$iv;
            int $i$f$withPermit;
            Object obj;
            Semaphore $this$withPermit$iv2;
            int concurrency$iv;
            Object obj2;
            int i;
            Element block;
            Element elementPreviousElementSibling;
            String strText;
            String headerText;
            Iterator it;
            Object element$iv;
            Element element;
            Unit unit;
            String seasonLink;
            Object objSafeGet$default;
            String seasonLink2;
            int i2;
            String headerText2;
            Continuation $completion;
            Element block2;
            Element it2;
            Document episodeDoc;
            Elements episodeBlocks;
            int iIntValue;
            boolean z;
            Semaphore $this$withPermit$iv3;
            int i3;
            Object objCoroutineScope;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    Semaphore $this$withPermit$iv4 = this.$semaphore;
                    Object obj3 = this.$item;
                    this.L$0 = $this$withPermit$iv4;
                    this.L$1 = obj3;
                    this.label = 1;
                    if ($this$withPermit$iv4.acquire((Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $this$withPermit$iv = $this$withPermit$iv4;
                    $i$f$withPermit = 0;
                    obj = obj3;
                    try {
                        Continuation $completion2 = (Continuation) this;
                        block = (Element) obj;
                        elementPreviousElementSibling = block.previousElementSibling();
                        if (elementPreviousElementSibling != null) {
                            strText = elementPreviousElementSibling.text();
                        } else {
                            strText = null;
                        }
                        if (strText == null) {
                            strText = "";
                        }
                        headerText = strText;
                        if (StringsKt.contains(headerText, "Season " + this.$season$inlined.intValue(), true)) {
                            Iterable $this$firstOrNull$iv = block.select("a.btn");
                            it = $this$firstOrNull$iv.iterator();
                            do {
                                if (it.hasNext()) {
                                    element$iv = it.next();
                                    it2 = (Element) element$iv;
                                } else {
                                    element$iv = null;
                                }
                                element = (Element) element$iv;
                                if (element != null || (seasonLink = element.attr("href")) == null) {
                                    unit = Unit.INSTANCE;
                                } else {
                                    this.L$0 = $this$withPermit$iv;
                                    this.L$1 = obj;
                                    this.L$2 = SpillingKt.nullOutSpilledVariable($completion2);
                                    this.L$3 = SpillingKt.nullOutSpilledVariable(block);
                                    this.L$4 = SpillingKt.nullOutSpilledVariable(seasonLink);
                                    this.L$5 = SpillingKt.nullOutSpilledVariable(headerText);
                                    this.label = 2;
                                    objSafeGet$default = StreamPlayUtilsKt.safeGet$default(seasonLink, null, null, null, null, false, 0, this, 126, null);
                                    if (objSafeGet$default == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    seasonLink2 = seasonLink;
                                    $this$withPermit$iv2 = $this$withPermit$iv;
                                    i = 0;
                                    i2 = 0;
                                    headerText2 = headerText;
                                    $completion = $completion2;
                                    block2 = block;
                                    try {
                                        try {
                                            episodeDoc = ((NiceResponse) objSafeGet$default).getDocument();
                                            episodeBlocks = episodeDoc.select("div.downloads-btns-div");
                                            try {
                                                if (this.$episode$inlined != null) {
                                                    int size = episodeBlocks.size();
                                                    iIntValue = this.$episode$inlined.intValue();
                                                    z = false;
                                                    if (1 <= iIntValue && iIntValue <= size) {
                                                        z = true;
                                                    }
                                                    if (z) {
                                                        Element episodeBlock = (Element) episodeBlocks.get(this.$episode$inlined.intValue() - 1);
                                                        Iterable iterableSelect = episodeBlock.select("a.btn");
                                                        Iterable $this$safeAmap_u24default$iv = iterableSelect;
                                                        try {
                                                            Result.Companion companion = Result.Companion;
                                                            try {
                                                                C0185xc07bce5f c0185xc07bce5f = new C0185xc07bce5f(7, $this$safeAmap_u24default$iv, null, this.$subtitleCallback$inlined, this.$callback$inlined);
                                                                this.L$0 = $this$withPermit$iv2;
                                                                this.L$1 = obj;
                                                                i3 = i;
                                                                try {
                                                                    this.L$2 = SpillingKt.nullOutSpilledVariable($completion);
                                                                    this.L$3 = SpillingKt.nullOutSpilledVariable(block2);
                                                                    this.L$4 = SpillingKt.nullOutSpilledVariable(seasonLink2);
                                                                    this.L$5 = SpillingKt.nullOutSpilledVariable(headerText2);
                                                                    this.L$6 = SpillingKt.nullOutSpilledVariable(episodeBlocks);
                                                                    this.L$7 = SpillingKt.nullOutSpilledVariable(episodeBlock);
                                                                    this.L$8 = SpillingKt.nullOutSpilledVariable(iterableSelect);
                                                                    this.L$9 = SpillingKt.nullOutSpilledVariable($this$safeAmap_u24default$iv);
                                                                    this.L$10 = SpillingKt.nullOutSpilledVariable(this);
                                                                    this.L$11 = SpillingKt.nullOutSpilledVariable(episodeDoc);
                                                                    this.L$12 = SpillingKt.nullOutSpilledVariable($this$safeAmap_u24default$iv);
                                                                    this.I$0 = 7;
                                                                    this.label = 3;
                                                                    objCoroutineScope = CoroutineScopeKt.coroutineScope(c0185xc07bce5f, this);
                                                                    if (objCoroutineScope == coroutine_suspended) {
                                                                        return coroutine_suspended;
                                                                    }
                                                                    $this$withPermit$iv3 = $this$withPermit$iv2;
                                                                    i = i3;
                                                                    concurrency$iv = $i$f$withPermit;
                                                                    try {
                                                                        Result.constructor-impl((List) objCoroutineScope);
                                                                    } catch (Throwable th) {
                                                                        th = th;
                                                                        try {
                                                                            Result.Companion companion2 = Result.Companion;
                                                                            Result.constructor-impl(ResultKt.createFailure(th));
                                                                        } catch (Exception e) {
                                                                            e = e;
                                                                            obj2 = obj;
                                                                            $this$withPermit$iv2 = $this$withPermit$iv3;
                                                                            Log.INSTANCE.e("safeMap", "Request failed for " + obj2 + ' ' + e);
                                                                            $this$withPermit$iv = $this$withPermit$iv2;
                                                                            unit = null;
                                                                            $this$withPermit$iv.release();
                                                                            return unit;
                                                                        } catch (Throwable th2) {
                                                                            th = th2;
                                                                            $this$withPermit$iv2 = $this$withPermit$iv3;
                                                                            $this$withPermit$iv2.release();
                                                                            throw th;
                                                                        }
                                                                    }
                                                                    int $i$f$withPermit2 = concurrency$iv;
                                                                    $i$f$withPermit = $i$f$withPermit2;
                                                                    obj2 = obj;
                                                                    $this$withPermit$iv2 = $this$withPermit$iv3;
                                                                } catch (Throwable th3) {
                                                                    th = th3;
                                                                    $this$withPermit$iv3 = $this$withPermit$iv2;
                                                                    i = i3;
                                                                    concurrency$iv = $i$f$withPermit;
                                                                    Result.Companion companion3 = Result.Companion;
                                                                    Result.constructor-impl(ResultKt.createFailure(th));
                                                                    int $i$f$withPermit3 = concurrency$iv;
                                                                    $i$f$withPermit = $i$f$withPermit3;
                                                                    obj2 = obj;
                                                                    $this$withPermit$iv2 = $this$withPermit$iv3;
                                                                    unit = Unit.INSTANCE;
                                                                    $this$withPermit$iv = $this$withPermit$iv2;
                                                                    $this$withPermit$iv.release();
                                                                    return unit;
                                                                }
                                                            } catch (Throwable th4) {
                                                                th = th4;
                                                                $this$withPermit$iv3 = $this$withPermit$iv2;
                                                                concurrency$iv = $i$f$withPermit;
                                                            }
                                                        } catch (Throwable th5) {
                                                            th = th5;
                                                            $this$withPermit$iv3 = $this$withPermit$iv2;
                                                            concurrency$iv = $i$f$withPermit;
                                                        }
                                                    }
                                                    unit = Unit.INSTANCE;
                                                    $this$withPermit$iv = $this$withPermit$iv2;
                                                }
                                                unit = Unit.INSTANCE;
                                                $this$withPermit$iv = $this$withPermit$iv2;
                                            } catch (Exception e2) {
                                                e = e2;
                                                concurrency$iv = $i$f$withPermit;
                                                Log.INSTANCE.e("safeMap", "Request failed for " + obj2 + ' ' + e);
                                                $this$withPermit$iv = $this$withPermit$iv2;
                                                unit = null;
                                            }
                                            obj2 = obj;
                                            i = i;
                                        } catch (Exception e3) {
                                            e = e3;
                                            concurrency$iv = $i$f$withPermit;
                                            obj2 = obj;
                                            Log.INSTANCE.e("safeMap", "Request failed for " + obj2 + ' ' + e);
                                            $this$withPermit$iv = $this$withPermit$iv2;
                                            unit = null;
                                            $this$withPermit$iv.release();
                                            return unit;
                                        }
                                    } catch (Throwable th6) {
                                        th = th6;
                                        $this$withPermit$iv2.release();
                                        throw th;
                                    }
                                }
                                break;
                            } while (StringsKt.contains(it2.text(), "zip", true));
                            element = (Element) element$iv;
                            if (element != null) {
                            }
                            unit = Unit.INSTANCE;
                        } else {
                            obj2 = obj;
                            $this$withPermit$iv2 = $this$withPermit$iv;
                            i = 0;
                            unit = Unit.INSTANCE;
                            $this$withPermit$iv = $this$withPermit$iv2;
                        }
                    } catch (Exception e4) {
                        e = e4;
                        concurrency$iv = $i$f$withPermit;
                        obj2 = obj;
                        $this$withPermit$iv2 = $this$withPermit$iv;
                        i = 0;
                        Log.INSTANCE.e("safeMap", "Request failed for " + obj2 + ' ' + e);
                        $this$withPermit$iv = $this$withPermit$iv2;
                        unit = null;
                        $this$withPermit$iv.release();
                        return unit;
                    } catch (Throwable th7) {
                        th = th7;
                        $this$withPermit$iv2 = $this$withPermit$iv;
                        $this$withPermit$iv2.release();
                        throw th;
                    }
                    $this$withPermit$iv.release();
                    return unit;
                case 1:
                    Object obj4 = this.L$1;
                    Semaphore $this$withPermit$iv5 = (Semaphore) this.L$0;
                    ResultKt.throwOnFailure($result);
                    $i$f$withPermit = 0;
                    $this$withPermit$iv = $this$withPermit$iv5;
                    obj = obj4;
                    Continuation $completion3 = (Continuation) this;
                    block = (Element) obj;
                    elementPreviousElementSibling = block.previousElementSibling();
                    if (elementPreviousElementSibling != null) {
                        strText = elementPreviousElementSibling.text();
                    } else {
                        strText = null;
                    }
                    if (strText == null) {
                        strText = "";
                    }
                    headerText = strText;
                    if (StringsKt.contains(headerText, "Season " + this.$season$inlined.intValue(), true)) {
                        Iterable $this$firstOrNull$iv2 = block.select("a.btn");
                        it = $this$firstOrNull$iv2.iterator();
                        do {
                            if (it.hasNext()) {
                                element$iv = it.next();
                                it2 = (Element) element$iv;
                            } else {
                                element$iv = null;
                            }
                            element = (Element) element$iv;
                            if (element != null) {
                            }
                            unit = Unit.INSTANCE;
                        } while (StringsKt.contains(it2.text(), "zip", true));
                        element = (Element) element$iv;
                        if (element != null) {
                        }
                        unit = Unit.INSTANCE;
                    } else {
                        obj2 = obj;
                        $this$withPermit$iv2 = $this$withPermit$iv;
                        i = 0;
                        unit = Unit.INSTANCE;
                        $this$withPermit$iv = $this$withPermit$iv2;
                    }
                    $this$withPermit$iv.release();
                    return unit;
                case 2:
                    concurrency$iv = 0;
                    i = 0;
                    String headerText3 = (String) this.L$5;
                    seasonLink2 = (String) this.L$4;
                    Element block3 = (Element) this.L$3;
                    Continuation $completion4 = (Continuation) this.L$2;
                    obj2 = this.L$1;
                    $this$withPermit$iv2 = (Semaphore) this.L$0;
                    try {
                        try {
                            ResultKt.throwOnFailure($result);
                            $i$f$withPermit = 0;
                            headerText2 = headerText3;
                            block2 = block3;
                            $completion = $completion4;
                            obj = obj2;
                            objSafeGet$default = $result;
                            i2 = 0;
                            episodeDoc = ((NiceResponse) objSafeGet$default).getDocument();
                            episodeBlocks = episodeDoc.select("div.downloads-btns-div");
                            if (this.$episode$inlined != null) {
                                int size2 = episodeBlocks.size();
                                iIntValue = this.$episode$inlined.intValue();
                                z = false;
                                if (1 <= iIntValue) {
                                    z = true;
                                }
                                if (z) {
                                    Element episodeBlock2 = (Element) episodeBlocks.get(this.$episode$inlined.intValue() - 1);
                                    Iterable iterableSelect2 = episodeBlock2.select("a.btn");
                                    Iterable $this$safeAmap_u24default$iv2 = iterableSelect2;
                                    Result.Companion companion4 = Result.Companion;
                                    C0185xc07bce5f c0185xc07bce5f2 = new C0185xc07bce5f(7, $this$safeAmap_u24default$iv2, null, this.$subtitleCallback$inlined, this.$callback$inlined);
                                    this.L$0 = $this$withPermit$iv2;
                                    this.L$1 = obj;
                                    i3 = i;
                                    this.L$2 = SpillingKt.nullOutSpilledVariable($completion);
                                    this.L$3 = SpillingKt.nullOutSpilledVariable(block2);
                                    this.L$4 = SpillingKt.nullOutSpilledVariable(seasonLink2);
                                    this.L$5 = SpillingKt.nullOutSpilledVariable(headerText2);
                                    this.L$6 = SpillingKt.nullOutSpilledVariable(episodeBlocks);
                                    this.L$7 = SpillingKt.nullOutSpilledVariable(episodeBlock2);
                                    this.L$8 = SpillingKt.nullOutSpilledVariable(iterableSelect2);
                                    this.L$9 = SpillingKt.nullOutSpilledVariable($this$safeAmap_u24default$iv2);
                                    this.L$10 = SpillingKt.nullOutSpilledVariable(this);
                                    this.L$11 = SpillingKt.nullOutSpilledVariable(episodeDoc);
                                    this.L$12 = SpillingKt.nullOutSpilledVariable($this$safeAmap_u24default$iv2);
                                    this.I$0 = 7;
                                    this.label = 3;
                                    objCoroutineScope = CoroutineScopeKt.coroutineScope(c0185xc07bce5f2, this);
                                    if (objCoroutineScope == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    $this$withPermit$iv3 = $this$withPermit$iv2;
                                    i = i3;
                                    concurrency$iv = $i$f$withPermit;
                                    Result.constructor-impl((List) objCoroutineScope);
                                    int $i$f$withPermit4 = concurrency$iv;
                                    $i$f$withPermit = $i$f$withPermit4;
                                    obj2 = obj;
                                    $this$withPermit$iv2 = $this$withPermit$iv3;
                                }
                                unit = Unit.INSTANCE;
                                $this$withPermit$iv = $this$withPermit$iv2;
                                $this$withPermit$iv.release();
                                return unit;
                            }
                            obj2 = obj;
                            i = i;
                            unit = Unit.INSTANCE;
                            $this$withPermit$iv = $this$withPermit$iv2;
                        } catch (Exception e5) {
                            e = e5;
                            Log.INSTANCE.e("safeMap", "Request failed for " + obj2 + ' ' + e);
                            $this$withPermit$iv = $this$withPermit$iv2;
                            unit = null;
                            $this$withPermit$iv.release();
                            return unit;
                        }
                        $this$withPermit$iv.release();
                        return unit;
                    } catch (Throwable th8) {
                        th = th8;
                        $this$withPermit$iv2.release();
                        throw th;
                    }
                case 3:
                    i = 0;
                    i2 = 0;
                    int i4 = this.I$0;
                    headerText2 = (String) this.L$5;
                    block2 = (Element) this.L$3;
                    $completion = (Continuation) this.L$2;
                    Object obj5 = this.L$1;
                    $this$withPermit$iv3 = (Semaphore) this.L$0;
                    try {
                        ResultKt.throwOnFailure($result);
                        objCoroutineScope = $result;
                        obj = obj5;
                        concurrency$iv = 0;
                        Result.constructor-impl((List) objCoroutineScope);
                        break;
                    } catch (Throwable th9) {
                        th = th9;
                        obj = obj5;
                        concurrency$iv = 0;
                        Result.Companion companion5 = Result.Companion;
                        Result.constructor-impl(ResultKt.createFailure(th));
                        int $i$f$withPermit5 = concurrency$iv;
                        $i$f$withPermit = $i$f$withPermit5;
                        obj2 = obj;
                        $this$withPermit$iv2 = $this$withPermit$iv3;
                        unit = Unit.INSTANCE;
                        $this$withPermit$iv = $this$withPermit$iv2;
                        $this$withPermit$iv.release();
                        return unit;
                    }
                    int $i$f$withPermit6 = concurrency$iv;
                    $i$f$withPermit = $i$f$withPermit6;
                    obj2 = obj;
                    $this$withPermit$iv2 = $this$withPermit$iv3;
                    unit = Unit.INSTANCE;
                    $this$withPermit$iv = $this$withPermit$iv2;
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
                    Collection destination$iv$iv2 = destination$iv$iv;
                    destination$iv$iv2.add(BuildersKt.async$default($this$coroutineScope, Dispatchers.getIO(), (CoroutineStart) null, new AnonymousClass1(semaphore, item$iv$iv, null, this.$season$inlined, this.$episode$inlined, this.$subtitleCallback$inlined, this.$callback$inlined), 2, (Object) null));
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
