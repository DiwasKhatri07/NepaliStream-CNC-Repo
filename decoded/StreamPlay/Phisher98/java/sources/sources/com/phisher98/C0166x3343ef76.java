package com.phisher98;

import com.lagradost.api.Log;
import com.lagradost.nicehttp.NiceResponse;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
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
import kotlin.text.StringsKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.sync.Semaphore;
import kotlinx.coroutines.sync.SemaphoreKt;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/* JADX INFO: renamed from: com.phisher98.StreamPlayExtractor$invokeHindmoviez$lambda$1$$inlined$safeAmap$default$1 */
/* JADX INFO: compiled from: StreamPlayUtils.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StreamPlay/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\b\u00028\u00000\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "com/phisher98/StreamPlayUtilsKt$safeAmap$2$1"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.phisher98.StreamPlayExtractor$invokeHindmoviez$lambda$1$$inlined$safeAmap$default$1", f = "StreamPlayExtractor.kt", i = {0, 0}, l = {1898}, m = "invokeSuspend", n = {"$this$coroutineScope", "semaphore"}, nl = {-1}, s = {"L$0", "L$1"}, v = 2)
@SourceDebugExtension({"SMAP\nStreamPlayUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,2265:1\n1739#2:2266\n1814#2,3:2267\n*S KotlinDebug\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1\n*L\n1887#1:2266\n1887#1:2267,3\n*E\n"})
public final class C0166x3343ef76 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Unit>>, Object> {
    final /* synthetic */ Function1 $callback$inlined;
    final /* synthetic */ int $concurrency;
    final /* synthetic */ Function1 $subtitleCallback$inlined;
    final /* synthetic */ Iterable $this_runCatching;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0166x3343ef76(int i, Iterable iterable, Continuation continuation, Function1 function1, Function1 function2) {
        super(2, continuation);
        this.$concurrency = i;
        this.$this_runCatching = iterable;
        this.$subtitleCallback$inlined = function1;
        this.$callback$inlined = function2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> c0166x3343ef76 = new C0166x3343ef76(this.$concurrency, this.$this_runCatching, continuation, this.$subtitleCallback$inlined, this.$callback$inlined);
        c0166x3343ef76.L$0 = obj;
        return c0166x3343ef76;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends Unit>> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: renamed from: com.phisher98.StreamPlayExtractor$invokeHindmoviez$lambda$1$$inlined$safeAmap$default$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: StreamPlayUtils.kt */
    @Metadata(d1 = {"\u0000\n\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", "B", "Lkotlinx/coroutines/CoroutineScope;", "com/phisher98/StreamPlayUtilsKt$safeAmap$2$1$1$1"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StreamPlayExtractor$invokeHindmoviez$lambda$1$$inlined$safeAmap$default$1$1", f = "StreamPlayExtractor.kt", i = {0, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3}, l = {2266, 2269, 2280, 2284}, m = "invokeSuspend", n = {"$this$withPermit$iv", "$this$withPermit$iv", "$completion", "btn", "$this$withPermit$iv", "$completion", "btn", "intermediateDoc", "href", "baseurl", "rawId", "$this$withPermit$iv", "$completion", "btn", "intermediateDoc", "link"}, nl = {2267, 2270, 2273, 2285}, s = {"L$0", "L$0", "L$2", "L$3", "L$0", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$0", "L$2", "L$3", "L$4", "L$5"}, v = 2)
    @SourceDebugExtension({"SMAP\nStreamPlayUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1$1$1\n+ 2 Semaphore.kt\nkotlinx/coroutines/sync/SemaphoreKt\n+ 3 StreamPlayExtractor.kt\ncom/phisher98/StreamPlayExtractor\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,2265:1\n81#2,3:2266\n85#2,2:2286\n4836#3,5:2269\n4841#3,11:2275\n1#4:2274\n*S KotlinDebug\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1$1$1\n*L\n1889#1:2266,3\n1889#1:2286,2\n*E\n"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
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
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Semaphore semaphore, Object obj, Continuation continuation, Function1 function1, Function1 function2) {
            super(2, continuation);
            this.$semaphore = semaphore;
            this.$item = obj;
            this.$subtitleCallback$inlined = function1;
            this.$callback$inlined = function2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$semaphore, this.$item, continuation, this.$subtitleCallback$inlined, this.$callback$inlined);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:33:0x00f7 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:34:0x00f8  */
        /* JADX WARN: Code duplicated, block: B:37:0x0114 A[Catch: all -> 0x0086, Exception -> 0x0089, TryCatch #4 {all -> 0x0086, blocks: (B:7:0x0030, B:67:0x01f5, B:56:0x01d3, B:17:0x007d, B:35:0x0102, B:37:0x0114, B:39:0x011b, B:44:0x012b), top: B:73:0x000c }] */
        /* JADX WARN: Code duplicated, block: B:41:0x0126  */
        /* JADX WARN: Code duplicated, block: B:42:0x0127  */
        /* JADX WARN: Code duplicated, block: B:44:0x012b A[Catch: all -> 0x0086, Exception -> 0x0089, TRY_LEAVE, TryCatch #4 {all -> 0x0086, blocks: (B:7:0x0030, B:67:0x01f5, B:56:0x01d3, B:17:0x007d, B:35:0x0102, B:37:0x0114, B:39:0x011b, B:44:0x012b), top: B:73:0x000c }] */
        /* JADX WARN: Code duplicated, block: B:46:0x017e A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:47:0x017f  */
        /* JADX WARN: Code duplicated, block: B:50:0x018f A[Catch: all -> 0x0062, Exception -> 0x0066, TRY_LEAVE, TryCatch #8 {Exception -> 0x0066, all -> 0x0062, blocks: (B:10:0x005b, B:48:0x018a, B:50:0x018f), top: B:74:0x005b }] */
        /* JADX WARN: Code duplicated, block: B:52:0x01c6 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:53:0x01c7  */
        /* JADX WARN: Code duplicated, block: B:55:0x01cc  */
        public final Object invokeSuspend(Object $result) throws Throwable {
            Semaphore $this$withPermit$iv;
            Semaphore $this$withPermit$iv2;
            Object obj;
            Semaphore $this$withPermit$iv3;
            Object obj2;
            int $i$f$withPermit;
            Semaphore $this$withPermit$iv4;
            Continuation $completion;
            Element btn;
            int i;
            Semaphore $this$withPermit$iv5;
            Object objSafeGet$default;
            Object obj3;
            Continuation $completion2;
            Element btn2;
            Semaphore $this$withPermit$iv6;
            Document intermediateDoc;
            Element elementSelectFirst;
            String it;
            Object objHindmoviezsignHShare;
            Object obj4;
            Element btn3;
            Continuation $completion3;
            Object obj5;
            Document intermediateDoc2;
            int i2;
            String link;
            Object hindMoviezLinks;
            Object obj6;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            Object obj7 = null;
            try {
                try {
                    switch (this.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            Semaphore $this$withPermit$iv7 = this.$semaphore;
                            Object obj8 = this.$item;
                            this.L$0 = $this$withPermit$iv7;
                            this.L$1 = obj8;
                            this.label = 1;
                            if ($this$withPermit$iv7.acquire((Continuation) this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            obj2 = obj8;
                            $i$f$withPermit = 0;
                            $this$withPermit$iv4 = $this$withPermit$iv7;
                            try {
                                $completion = (Continuation) this;
                                btn = (Element) obj2;
                                i = 0;
                                String strAttr = btn.attr("href");
                                Long lBoxLong = Boxing.boxLong(5000L);
                                this.L$0 = $this$withPermit$iv4;
                                this.L$1 = obj2;
                                this.L$2 = SpillingKt.nullOutSpilledVariable($completion);
                                this.L$3 = SpillingKt.nullOutSpilledVariable(btn);
                                this.label = 2;
                                $this$withPermit$iv5 = $this$withPermit$iv4;
                                try {
                                    objSafeGet$default = StreamPlayUtilsKt.safeGet$default(strAttr, null, null, lBoxLong, null, false, 0, this, 118, null);
                                    if (objSafeGet$default == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    obj3 = obj2;
                                    $completion2 = $completion;
                                    btn2 = btn;
                                    $this$withPermit$iv6 = $this$withPermit$iv5;
                                    intermediateDoc = ((NiceResponse) objSafeGet$default).getDocument();
                                    elementSelectFirst = intermediateDoc.selectFirst("a.get-link-btn");
                                    if (elementSelectFirst != null && (it = elementSelectFirst.attr("href")) != null) {
                                        if (StringsKt.isBlank(it)) {
                                            it = null;
                                        }
                                        if (it != null) {
                                            String href = it;
                                            String baseurl = StringsKt.substringBefore$default(href, "/?id=", (String) null, 2, (Object) null);
                                            String rawId = URLDecoder.decode(StringsKt.replace$default(StringsKt.substringAfter$default(href, "id=", (String) null, 2, (Object) null), "+", "%2B", false, 4, (Object) null), "UTF-8");
                                            this.L$0 = $this$withPermit$iv6;
                                            this.L$1 = obj3;
                                            this.L$2 = SpillingKt.nullOutSpilledVariable($completion2);
                                            this.L$3 = SpillingKt.nullOutSpilledVariable(btn2);
                                            this.L$4 = SpillingKt.nullOutSpilledVariable(intermediateDoc);
                                            this.L$5 = SpillingKt.nullOutSpilledVariable(href);
                                            this.L$6 = SpillingKt.nullOutSpilledVariable(baseurl);
                                            this.L$7 = SpillingKt.nullOutSpilledVariable(rawId);
                                            this.label = 3;
                                            objHindmoviezsignHShare = StreamPlayUtilsKt.hindmoviezsignHShare(rawId, baseurl, intermediateDoc, this);
                                            if (objHindmoviezsignHShare == coroutine_suspended) {
                                                return coroutine_suspended;
                                            }
                                            obj4 = objHindmoviezsignHShare;
                                            $this$withPermit$iv3 = $this$withPermit$iv6;
                                            btn3 = btn2;
                                            $completion3 = $completion2;
                                            obj5 = obj3;
                                            intermediateDoc2 = intermediateDoc;
                                            i2 = i;
                                            link = (String) obj4;
                                            if (link == null) {
                                                Log.INSTANCE.d("Phisher 1", link);
                                                Function1 function1 = this.$subtitleCallback$inlined;
                                                Function1 function2 = this.$callback$inlined;
                                                this.L$0 = $this$withPermit$iv3;
                                                this.L$1 = obj5;
                                                this.L$2 = SpillingKt.nullOutSpilledVariable($completion3);
                                                this.L$3 = SpillingKt.nullOutSpilledVariable(btn3);
                                                this.L$4 = SpillingKt.nullOutSpilledVariable(intermediateDoc2);
                                                this.L$5 = SpillingKt.nullOutSpilledVariable(link);
                                                this.L$6 = null;
                                                this.L$7 = null;
                                                this.label = 4;
                                                hindMoviezLinks = StreamPlayUtilsKt.getHindMoviezLinks("Hindmoviez", link, function1, function2, this);
                                                if (hindMoviezLinks == coroutine_suspended) {
                                                    return coroutine_suspended;
                                                }
                                                obj6 = hindMoviezLinks;
                                                obj7 = obj6;
                                            } else {
                                                $this$withPermit$iv6 = $this$withPermit$iv3;
                                            }
                                        }
                                        $this$withPermit$iv3.release();
                                        return obj7;
                                    }
                                    $this$withPermit$iv3 = $this$withPermit$iv6;
                                    obj7 = Unit.INSTANCE;
                                    $this$withPermit$iv3.release();
                                    return obj7;
                                } catch (Exception e) {
                                    e = e;
                                    obj = obj2;
                                    $this$withPermit$iv2 = $this$withPermit$iv5;
                                    Log.INSTANCE.e("safeMap", "Request failed for " + obj + ' ' + e);
                                    $this$withPermit$iv3 = $this$withPermit$iv2;
                                } catch (Throwable th) {
                                    th = th;
                                    $this$withPermit$iv = $this$withPermit$iv5;
                                    $this$withPermit$iv.release();
                                    throw th;
                                }
                            } catch (Exception e2) {
                                e = e2;
                                obj = obj2;
                                $this$withPermit$iv2 = $this$withPermit$iv4;
                            } catch (Throwable th2) {
                                th = th2;
                                $this$withPermit$iv = $this$withPermit$iv4;
                            }
                            break;
                        case 1:
                            Object obj9 = this.L$1;
                            Semaphore $this$withPermit$iv8 = (Semaphore) this.L$0;
                            ResultKt.throwOnFailure($result);
                            $i$f$withPermit = 0;
                            obj2 = obj9;
                            $this$withPermit$iv4 = $this$withPermit$iv8;
                            $completion = (Continuation) this;
                            btn = (Element) obj2;
                            i = 0;
                            String strAttr2 = btn.attr("href");
                            Long lBoxLong2 = Boxing.boxLong(5000L);
                            this.L$0 = $this$withPermit$iv4;
                            this.L$1 = obj2;
                            this.L$2 = SpillingKt.nullOutSpilledVariable($completion);
                            this.L$3 = SpillingKt.nullOutSpilledVariable(btn);
                            this.label = 2;
                            $this$withPermit$iv5 = $this$withPermit$iv4;
                            objSafeGet$default = StreamPlayUtilsKt.safeGet$default(strAttr2, null, null, lBoxLong2, null, false, 0, this, 118, null);
                            if (objSafeGet$default == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            obj3 = obj2;
                            $completion2 = $completion;
                            btn2 = btn;
                            $this$withPermit$iv6 = $this$withPermit$iv5;
                            intermediateDoc = ((NiceResponse) objSafeGet$default).getDocument();
                            elementSelectFirst = intermediateDoc.selectFirst("a.get-link-btn");
                            if (elementSelectFirst != null) {
                                if (StringsKt.isBlank(it)) {
                                    it = null;
                                }
                                if (it != null) {
                                    String href2 = it;
                                    String baseurl2 = StringsKt.substringBefore$default(href2, "/?id=", (String) null, 2, (Object) null);
                                    String rawId2 = URLDecoder.decode(StringsKt.replace$default(StringsKt.substringAfter$default(href2, "id=", (String) null, 2, (Object) null), "+", "%2B", false, 4, (Object) null), "UTF-8");
                                    this.L$0 = $this$withPermit$iv6;
                                    this.L$1 = obj3;
                                    this.L$2 = SpillingKt.nullOutSpilledVariable($completion2);
                                    this.L$3 = SpillingKt.nullOutSpilledVariable(btn2);
                                    this.L$4 = SpillingKt.nullOutSpilledVariable(intermediateDoc);
                                    this.L$5 = SpillingKt.nullOutSpilledVariable(href2);
                                    this.L$6 = SpillingKt.nullOutSpilledVariable(baseurl2);
                                    this.L$7 = SpillingKt.nullOutSpilledVariable(rawId2);
                                    this.label = 3;
                                    objHindmoviezsignHShare = StreamPlayUtilsKt.hindmoviezsignHShare(rawId2, baseurl2, intermediateDoc, this);
                                    if (objHindmoviezsignHShare == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    obj4 = objHindmoviezsignHShare;
                                    $this$withPermit$iv3 = $this$withPermit$iv6;
                                    btn3 = btn2;
                                    $completion3 = $completion2;
                                    obj5 = obj3;
                                    intermediateDoc2 = intermediateDoc;
                                    i2 = i;
                                    link = (String) obj4;
                                    if (link == null) {
                                        Log.INSTANCE.d("Phisher 1", link);
                                        Function1 function3 = this.$subtitleCallback$inlined;
                                        Function1 function4 = this.$callback$inlined;
                                        this.L$0 = $this$withPermit$iv3;
                                        this.L$1 = obj5;
                                        this.L$2 = SpillingKt.nullOutSpilledVariable($completion3);
                                        this.L$3 = SpillingKt.nullOutSpilledVariable(btn3);
                                        this.L$4 = SpillingKt.nullOutSpilledVariable(intermediateDoc2);
                                        this.L$5 = SpillingKt.nullOutSpilledVariable(link);
                                        this.L$6 = null;
                                        this.L$7 = null;
                                        this.label = 4;
                                        hindMoviezLinks = StreamPlayUtilsKt.getHindMoviezLinks("Hindmoviez", link, function3, function4, this);
                                        if (hindMoviezLinks == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        obj6 = hindMoviezLinks;
                                        obj7 = obj6;
                                    } else {
                                        $this$withPermit$iv6 = $this$withPermit$iv3;
                                    }
                                }
                                $this$withPermit$iv3.release();
                                return obj7;
                            }
                            $this$withPermit$iv3 = $this$withPermit$iv6;
                            obj7 = Unit.INSTANCE;
                            $this$withPermit$iv3.release();
                            return obj7;
                        case 2:
                            btn2 = (Element) this.L$3;
                            $completion2 = (Continuation) this.L$2;
                            obj3 = this.L$1;
                            $this$withPermit$iv6 = (Semaphore) this.L$0;
                            ResultKt.throwOnFailure($result);
                            i = 0;
                            objSafeGet$default = $result;
                            intermediateDoc = ((NiceResponse) objSafeGet$default).getDocument();
                            elementSelectFirst = intermediateDoc.selectFirst("a.get-link-btn");
                            if (elementSelectFirst != null) {
                                if (StringsKt.isBlank(it)) {
                                    it = null;
                                }
                                if (it != null) {
                                    String href3 = it;
                                    String baseurl3 = StringsKt.substringBefore$default(href3, "/?id=", (String) null, 2, (Object) null);
                                    String rawId3 = URLDecoder.decode(StringsKt.replace$default(StringsKt.substringAfter$default(href3, "id=", (String) null, 2, (Object) null), "+", "%2B", false, 4, (Object) null), "UTF-8");
                                    this.L$0 = $this$withPermit$iv6;
                                    this.L$1 = obj3;
                                    this.L$2 = SpillingKt.nullOutSpilledVariable($completion2);
                                    this.L$3 = SpillingKt.nullOutSpilledVariable(btn2);
                                    this.L$4 = SpillingKt.nullOutSpilledVariable(intermediateDoc);
                                    this.L$5 = SpillingKt.nullOutSpilledVariable(href3);
                                    this.L$6 = SpillingKt.nullOutSpilledVariable(baseurl3);
                                    this.L$7 = SpillingKt.nullOutSpilledVariable(rawId3);
                                    this.label = 3;
                                    objHindmoviezsignHShare = StreamPlayUtilsKt.hindmoviezsignHShare(rawId3, baseurl3, intermediateDoc, this);
                                    if (objHindmoviezsignHShare == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    obj4 = objHindmoviezsignHShare;
                                    $this$withPermit$iv3 = $this$withPermit$iv6;
                                    btn3 = btn2;
                                    $completion3 = $completion2;
                                    obj5 = obj3;
                                    intermediateDoc2 = intermediateDoc;
                                    i2 = i;
                                    link = (String) obj4;
                                    if (link == null) {
                                        Log.INSTANCE.d("Phisher 1", link);
                                        Function1 function5 = this.$subtitleCallback$inlined;
                                        Function1 function6 = this.$callback$inlined;
                                        this.L$0 = $this$withPermit$iv3;
                                        this.L$1 = obj5;
                                        this.L$2 = SpillingKt.nullOutSpilledVariable($completion3);
                                        this.L$3 = SpillingKt.nullOutSpilledVariable(btn3);
                                        this.L$4 = SpillingKt.nullOutSpilledVariable(intermediateDoc2);
                                        this.L$5 = SpillingKt.nullOutSpilledVariable(link);
                                        this.L$6 = null;
                                        this.L$7 = null;
                                        this.label = 4;
                                        hindMoviezLinks = StreamPlayUtilsKt.getHindMoviezLinks("Hindmoviez", link, function5, function6, this);
                                        if (hindMoviezLinks == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        obj6 = hindMoviezLinks;
                                        obj7 = obj6;
                                    } else {
                                        $this$withPermit$iv6 = $this$withPermit$iv3;
                                    }
                                }
                                $this$withPermit$iv3.release();
                                return obj7;
                            }
                            $this$withPermit$iv3 = $this$withPermit$iv6;
                            obj7 = Unit.INSTANCE;
                            $this$withPermit$iv3.release();
                            return obj7;
                        case 3:
                            i2 = 0;
                            intermediateDoc2 = (Document) this.L$4;
                            btn3 = (Element) this.L$3;
                            $completion3 = (Continuation) this.L$2;
                            obj5 = this.L$1;
                            $this$withPermit$iv3 = (Semaphore) this.L$0;
                            try {
                                ResultKt.throwOnFailure($result);
                                obj4 = $result;
                                link = (String) obj4;
                                if (link == null) {
                                    $this$withPermit$iv6 = $this$withPermit$iv3;
                                    $this$withPermit$iv3 = $this$withPermit$iv6;
                                    obj7 = Unit.INSTANCE;
                                    $this$withPermit$iv3.release();
                                    return obj7;
                                }
                                Log.INSTANCE.d("Phisher 1", link);
                                Function1 function7 = this.$subtitleCallback$inlined;
                                Function1 function8 = this.$callback$inlined;
                                this.L$0 = $this$withPermit$iv3;
                                this.L$1 = obj5;
                                this.L$2 = SpillingKt.nullOutSpilledVariable($completion3);
                                this.L$3 = SpillingKt.nullOutSpilledVariable(btn3);
                                this.L$4 = SpillingKt.nullOutSpilledVariable(intermediateDoc2);
                                this.L$5 = SpillingKt.nullOutSpilledVariable(link);
                                this.L$6 = null;
                                this.L$7 = null;
                                this.label = 4;
                                hindMoviezLinks = StreamPlayUtilsKt.getHindMoviezLinks("Hindmoviez", link, function7, function8, this);
                                if (hindMoviezLinks == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                obj6 = hindMoviezLinks;
                                obj7 = obj6;
                                $this$withPermit$iv3.release();
                                return obj7;
                            } catch (Exception e3) {
                                e = e3;
                                obj = obj5;
                                $this$withPermit$iv2 = $this$withPermit$iv3;
                                Log.INSTANCE.e("safeMap", "Request failed for " + obj + ' ' + e);
                                $this$withPermit$iv3 = $this$withPermit$iv2;
                            } catch (Throwable th3) {
                                th = th3;
                                $this$withPermit$iv = $this$withPermit$iv3;
                                $this$withPermit$iv.release();
                                throw th;
                            }
                            break;
                        case 4:
                            Object obj10 = this.L$1;
                            Semaphore $this$withPermit$iv9 = (Semaphore) this.L$0;
                            ResultKt.throwOnFailure($result);
                            $this$withPermit$iv3 = $this$withPermit$iv9;
                            obj6 = $result;
                            obj7 = obj6;
                            $this$withPermit$iv3.release();
                            return obj7;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } catch (Throwable th4) {
                    th = th4;
                }
            } catch (Exception e4) {
                e = e4;
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
                    destination$iv$iv.add(BuildersKt.async$default($this$coroutineScope, Dispatchers.getIO(), (CoroutineStart) null, new AnonymousClass1(semaphore, item$iv$iv, null, this.$subtitleCallback$inlined, this.$callback$inlined), 2, (Object) null));
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
