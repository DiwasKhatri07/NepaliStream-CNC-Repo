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

/* JADX INFO: renamed from: com.phisher98.StreamPlayExtractor$invokeMoviesdrive$$inlined$safeAmap$default$2 */
/* JADX INFO: compiled from: StreamPlayUtils.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/StreamPlay/classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\b\u00028\u00000\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "com/phisher98/StreamPlayUtilsKt$safeAmap$2$1"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.phisher98.StreamPlayExtractor$invokeMoviesdrive$$inlined$safeAmap$default$2", f = "StreamPlayExtractor.kt", i = {0, 0}, l = {1898}, m = "invokeSuspend", n = {"$this$coroutineScope", "semaphore"}, nl = {-1}, s = {"L$0", "L$1"}, v = 2)
@SourceDebugExtension({"SMAP\nStreamPlayUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,2265:1\n1739#2:2266\n1814#2,3:2267\n*S KotlinDebug\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1\n*L\n1887#1:2266\n1887#1:2267,3\n*E\n"})
public final class C0188x6223a047 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Unit>>, Object> {
    final /* synthetic */ Function1 $callback$inlined;
    final /* synthetic */ int $concurrency;
    final /* synthetic */ String $sep$inlined;
    final /* synthetic */ Function1 $subtitleCallback$inlined;
    final /* synthetic */ Iterable $this_runCatching;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0188x6223a047(int i, Iterable iterable, Continuation continuation, String str, Function1 function1, Function1 function2) {
        super(2, continuation);
        this.$concurrency = i;
        this.$this_runCatching = iterable;
        this.$sep$inlined = str;
        this.$subtitleCallback$inlined = function1;
        this.$callback$inlined = function2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> c0188x6223a047 = new C0188x6223a047(this.$concurrency, this.$this_runCatching, continuation, this.$sep$inlined, this.$subtitleCallback$inlined, this.$callback$inlined);
        c0188x6223a047.L$0 = obj;
        return c0188x6223a047;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends Unit>> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: renamed from: com.phisher98.StreamPlayExtractor$invokeMoviesdrive$$inlined$safeAmap$default$2$1, reason: invalid class name */
    /* JADX INFO: compiled from: StreamPlayUtils.kt */
    @Metadata(d1 = {"\u0000\n\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", "B", "Lkotlinx/coroutines/CoroutineScope;", "com/phisher98/StreamPlayUtilsKt$safeAmap$2$1$1$1"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StreamPlayExtractor$invokeMoviesdrive$$inlined$safeAmap$default$2$1", f = "StreamPlayExtractor.kt", i = {0, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {2266, 2272, 2285}, m = "invokeSuspend", n = {"$this$withPermit$iv", "$this$withPermit$iv", "$completion", "entry", "href", "$this$withPermit$iv", "$completion", "entry", "doc", "fEp", "linklist", "href", "source2", "$this$safeAmap_u24default$iv", "source1", "$completion$iv", "$this$safeAmap_u24lambda_u240$iv", "concurrency$iv"}, nl = {2267, 2273, 2286}, s = {"L$0", "L$0", "L$2", "L$3", "L$4", "L$0", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "I$0"}, v = 2)
    @SourceDebugExtension({"SMAP\nStreamPlayUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1$1$1\n+ 2 Semaphore.kt\nkotlinx/coroutines/sync/SemaphoreKt\n+ 3 StreamPlayExtractor.kt\ncom/phisher98/StreamPlayExtractor\n+ 4 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt\n*L\n1#1,2265:1\n81#2,3:2266\n85#2,2:2289\n2972#3,12:2269\n2993#3:2288\n1880#4,5:2281\n1899#4,2:2286\n*S KotlinDebug\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1$1$1\n+ 2 StreamPlayExtractor.kt\ncom/phisher98/StreamPlayExtractor\n*L\n1889#1:2266,3\n1889#1:2289,2\n2983#2:2281,5\n2983#2:2286,2\n*E\n"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1 $callback$inlined;
        final /* synthetic */ Object $item;
        final /* synthetic */ Semaphore $semaphore;
        final /* synthetic */ String $sep$inlined;
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
        public AnonymousClass1(Semaphore semaphore, Object obj, Continuation continuation, String str, Function1 function1, Function1 function2) {
            super(2, continuation);
            this.$semaphore = semaphore;
            this.$item = obj;
            this.$sep$inlined = str;
            this.$subtitleCallback$inlined = function1;
            this.$callback$inlined = function2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$semaphore, this.$item, continuation, this.$sep$inlined, this.$subtitleCallback$inlined, this.$callback$inlined);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:109:0x02f7  */
        /* JADX WARN: Code duplicated, block: B:134:0x01aa A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:152:0x00f1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:35:0x010f  */
        /* JADX WARN: Code duplicated, block: B:38:0x011a A[Catch: all -> 0x030a, Exception -> 0x0313, TRY_LEAVE, TryCatch #18 {Exception -> 0x0313, all -> 0x030a, blocks: (B:24:0x00df, B:36:0x0111, B:38:0x011a), top: B:150:0x00df }] */
        /* JADX WARN: Code duplicated, block: B:43:0x016b A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:44:0x016c  */
        /* JADX WARN: Code duplicated, block: B:50:0x01b0 A[Catch: Exception -> 0x01bd, all -> 0x02d5, TryCatch #12 {Exception -> 0x01bd, blocks: (B:48:0x01aa, B:50:0x01b0, B:52:0x01b6, B:58:0x01ca, B:60:0x01d0, B:62:0x01d6, B:64:0x01dc, B:67:0x01e5, B:69:0x01ea), top: B:134:0x01aa }] */
        /* JADX WARN: Code duplicated, block: B:55:0x01c3  */
        /* JADX WARN: Code duplicated, block: B:58:0x01ca A[Catch: Exception -> 0x01bd, all -> 0x02d5, TryCatch #12 {Exception -> 0x01bd, blocks: (B:48:0x01aa, B:50:0x01b0, B:52:0x01b6, B:58:0x01ca, B:60:0x01d0, B:62:0x01d6, B:64:0x01dc, B:67:0x01e5, B:69:0x01ea), top: B:134:0x01aa }] */
        /* JADX WARN: Code duplicated, block: B:65:0x01e1  */
        /* JADX WARN: Code duplicated, block: B:67:0x01e5 A[Catch: Exception -> 0x01bd, all -> 0x02d5, TryCatch #12 {Exception -> 0x01bd, blocks: (B:48:0x01aa, B:50:0x01b0, B:52:0x01b6, B:58:0x01ca, B:60:0x01d0, B:62:0x01d6, B:64:0x01dc, B:67:0x01e5, B:69:0x01ea), top: B:134:0x01aa }] */
        /* JADX WARN: Code duplicated, block: B:69:0x01ea A[Catch: Exception -> 0x01bd, all -> 0x02d5, TRY_LEAVE, TryCatch #12 {Exception -> 0x01bd, blocks: (B:48:0x01aa, B:50:0x01b0, B:52:0x01b6, B:58:0x01ca, B:60:0x01d0, B:62:0x01d6, B:64:0x01dc, B:67:0x01e5, B:69:0x01ea), top: B:134:0x01aa }] */
        /* JADX WARN: Code duplicated, block: B:80:0x0268 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:81:0x0269  */
        public final Object invokeSuspend(Object $result) throws Throwable {
            Semaphore $this$withPermit$iv;
            Semaphore $this$withPermit$iv2;
            Object obj;
            int $i$f$withPermit;
            Object obj2;
            Continuation $completion;
            Element entry;
            Element elementNextElementSibling;
            Element elementSelectFirst;
            String href;
            Semaphore $this$withPermit$iv3;
            String href2;
            Object obj3;
            String str;
            String str2;
            Object obj4;
            AnonymousClass1 anonymousClass1;
            String href3;
            String href4;
            Element entry2;
            Continuation $completion2;
            int concurrency$iv;
            Document doc;
            Element fEp;
            List linklist;
            Element elementNextElementSibling2;
            Element elementSelectFirst2;
            String str3;
            String strAttr;
            String source1;
            String source2;
            int $i$f$withPermit2;
            Semaphore $this$withPermit$iv4;
            String str4;
            Object objCoroutineScope;
            Element elementNextElementSibling3;
            Element elementNextElementSibling4;
            Element elementSelectFirst3;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            Unit unit = null;
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
                        obj = obj5;
                        $i$f$withPermit = 0;
                        try {
                            $completion = (Continuation) this;
                            entry = (Element) obj;
                            elementNextElementSibling = entry.nextElementSibling();
                            if (elementNextElementSibling == null) {
                                try {
                                    elementSelectFirst = elementNextElementSibling.selectFirst("a");
                                    if (elementSelectFirst != null || (href = elementSelectFirst.attr("href")) == null) {
                                        href = "";
                                    }
                                    if (!StringsKt.isBlank(href)) {
                                        obj2 = obj;
                                        $this$withPermit$iv = $this$withPermit$iv2;
                                        unit = Unit.INSTANCE;
                                    } else {
                                        Requests app = MainActivityKt.getApp();
                                        this.L$0 = $this$withPermit$iv2;
                                        this.L$1 = obj;
                                        this.L$2 = SpillingKt.nullOutSpilledVariable($completion);
                                        this.L$3 = SpillingKt.nullOutSpilledVariable(entry);
                                        this.L$4 = SpillingKt.nullOutSpilledVariable(href);
                                        this.label = 2;
                                        $this$withPermit$iv3 = $this$withPermit$iv2;
                                        href2 = href;
                                        obj3 = obj;
                                        str = "href";
                                        str2 = "a";
                                        try {
                                            obj4 = Requests.get$default(app, href2, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, this, 4094, (Object) null);
                                            anonymousClass1 = this;
                                            if (obj4 == coroutine_suspended) {
                                                return coroutine_suspended;
                                            }
                                            href3 = href2;
                                            href4 = null;
                                            entry2 = entry;
                                            $completion2 = $completion;
                                            concurrency$iv = 0;
                                            obj2 = obj3;
                                            $this$withPermit$iv = $this$withPermit$iv3;
                                            try {
                                                try {
                                                    doc = ((NiceResponse) obj4).getDocument();
                                                    fEp = doc.selectFirst("h5:matches((?i)" + anonymousClass1.$sep$inlined + ')');
                                                    linklist = new ArrayList();
                                                    if (fEp != null) {
                                                        try {
                                                            elementNextElementSibling2 = fEp.nextElementSibling();
                                                            if (elementNextElementSibling2 != null || (elementSelectFirst2 = elementNextElementSibling2.selectFirst(str2)) == null) {
                                                                str3 = str;
                                                                strAttr = null;
                                                            } else {
                                                                str3 = str;
                                                                strAttr = elementSelectFirst2.attr(str3);
                                                            }
                                                            source1 = strAttr;
                                                            if (fEp != null || (elementNextElementSibling3 = fEp.nextElementSibling()) == null || (elementNextElementSibling4 = elementNextElementSibling3.nextElementSibling()) == null || (elementSelectFirst3 = elementNextElementSibling4.selectFirst(str2)) == null) {
                                                                source2 = null;
                                                            } else {
                                                                source2 = elementSelectFirst3.attr(str3);
                                                            }
                                                            if (source1 != null) {
                                                                linklist.add(source1);
                                                            }
                                                            if (source2 != null) {
                                                                linklist.add(source2);
                                                            }
                                                            List $this$safeAmap_u24default$iv = linklist;
                                                            try {
                                                                Result.Companion companion = Result.Companion;
                                                                String source3 = source2;
                                                                try {
                                                                    try {
                                                                        C0190x7b2613ed c0190x7b2613ed = new C0190x7b2613ed(7, $this$safeAmap_u24default$iv, null, anonymousClass1.$subtitleCallback$inlined, anonymousClass1.$callback$inlined);
                                                                        anonymousClass1.L$0 = $this$withPermit$iv;
                                                                        anonymousClass1.L$1 = obj2;
                                                                        str4 = href4;
                                                                        try {
                                                                            anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable($completion2);
                                                                            anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(entry2);
                                                                            anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(doc);
                                                                            anonymousClass1.L$5 = SpillingKt.nullOutSpilledVariable(fEp);
                                                                            anonymousClass1.L$6 = SpillingKt.nullOutSpilledVariable(linklist);
                                                                            anonymousClass1.L$7 = SpillingKt.nullOutSpilledVariable(href3);
                                                                            anonymousClass1.L$8 = SpillingKt.nullOutSpilledVariable(source3);
                                                                            anonymousClass1.L$9 = SpillingKt.nullOutSpilledVariable($this$safeAmap_u24default$iv);
                                                                            anonymousClass1.L$10 = SpillingKt.nullOutSpilledVariable(source1);
                                                                            anonymousClass1.L$11 = SpillingKt.nullOutSpilledVariable(this);
                                                                            anonymousClass1.L$12 = SpillingKt.nullOutSpilledVariable($this$safeAmap_u24default$iv);
                                                                            anonymousClass1.I$0 = 7;
                                                                            anonymousClass1.label = 3;
                                                                            objCoroutineScope = CoroutineScopeKt.coroutineScope(c0190x7b2613ed, anonymousClass1);
                                                                            if (objCoroutineScope == coroutine_suspended) {
                                                                                return coroutine_suspended;
                                                                            }
                                                                            href4 = str4;
                                                                            $this$withPermit$iv4 = $this$withPermit$iv;
                                                                            try {
                                                                                Result.constructor-impl((List) objCoroutineScope);
                                                                            } catch (Throwable th) {
                                                                                th = th;
                                                                                $i$f$withPermit2 = $i$f$withPermit;
                                                                                try {
                                                                                    Result.Companion companion2 = Result.Companion;
                                                                                    Result.constructor-impl(ResultKt.createFailure(th));
                                                                                    $i$f$withPermit = $i$f$withPermit2;
                                                                                } catch (Exception e) {
                                                                                    e = e;
                                                                                    $this$withPermit$iv = $this$withPermit$iv4;
                                                                                } catch (Throwable th2) {
                                                                                    th = th2;
                                                                                    $this$withPermit$iv = $this$withPermit$iv4;
                                                                                    $this$withPermit$iv.release();
                                                                                    throw th;
                                                                                }
                                                                            }
                                                                            $this$withPermit$iv = $this$withPermit$iv4;
                                                                            try {
                                                                                unit = Unit.INSTANCE;
                                                                            } catch (Exception e2) {
                                                                                e = e2;
                                                                                Log.INSTANCE.e("safeMap", "Request failed for " + obj2 + ' ' + e);
                                                                            }
                                                                        } catch (Throwable th3) {
                                                                            th = th3;
                                                                            $i$f$withPermit2 = $i$f$withPermit;
                                                                            href4 = str4;
                                                                            $this$withPermit$iv4 = $this$withPermit$iv;
                                                                            Result.Companion companion3 = Result.Companion;
                                                                            Result.constructor-impl(ResultKt.createFailure(th));
                                                                            $i$f$withPermit = $i$f$withPermit2;
                                                                            $this$withPermit$iv = $this$withPermit$iv4;
                                                                            unit = Unit.INSTANCE;
                                                                            $this$withPermit$iv.release();
                                                                            return unit;
                                                                        }
                                                                    } catch (Throwable th4) {
                                                                        th = th4;
                                                                        $i$f$withPermit2 = $i$f$withPermit;
                                                                        $this$withPermit$iv4 = $this$withPermit$iv;
                                                                    }
                                                                } catch (Throwable th5) {
                                                                    th = th5;
                                                                    $i$f$withPermit2 = $i$f$withPermit;
                                                                    $this$withPermit$iv4 = $this$withPermit$iv;
                                                                }
                                                            } catch (Throwable th6) {
                                                                th = th6;
                                                                $i$f$withPermit2 = $i$f$withPermit;
                                                                $this$withPermit$iv4 = $this$withPermit$iv;
                                                            }
                                                        } catch (Exception e3) {
                                                            e = e3;
                                                        }
                                                        break;
                                                    } else {
                                                        str3 = str;
                                                        strAttr = null;
                                                        source1 = strAttr;
                                                        if (fEp != null) {
                                                            source2 = null;
                                                        } else {
                                                            source2 = null;
                                                        }
                                                        if (source1 != null) {
                                                            linklist.add(source1);
                                                        }
                                                        if (source2 != null) {
                                                            linklist.add(source2);
                                                        }
                                                        List $this$safeAmap_u24default$iv2 = linklist;
                                                        Result.Companion companion4 = Result.Companion;
                                                        String source4 = source2;
                                                        C0190x7b2613ed c0190x7b2613ed2 = new C0190x7b2613ed(7, $this$safeAmap_u24default$iv2, null, anonymousClass1.$subtitleCallback$inlined, anonymousClass1.$callback$inlined);
                                                        anonymousClass1.L$0 = $this$withPermit$iv;
                                                        anonymousClass1.L$1 = obj2;
                                                        str4 = href4;
                                                        anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable($completion2);
                                                        anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(entry2);
                                                        anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(doc);
                                                        anonymousClass1.L$5 = SpillingKt.nullOutSpilledVariable(fEp);
                                                        anonymousClass1.L$6 = SpillingKt.nullOutSpilledVariable(linklist);
                                                        anonymousClass1.L$7 = SpillingKt.nullOutSpilledVariable(href3);
                                                        anonymousClass1.L$8 = SpillingKt.nullOutSpilledVariable(source4);
                                                        anonymousClass1.L$9 = SpillingKt.nullOutSpilledVariable($this$safeAmap_u24default$iv2);
                                                        anonymousClass1.L$10 = SpillingKt.nullOutSpilledVariable(source1);
                                                        anonymousClass1.L$11 = SpillingKt.nullOutSpilledVariable(this);
                                                        anonymousClass1.L$12 = SpillingKt.nullOutSpilledVariable($this$safeAmap_u24default$iv2);
                                                        anonymousClass1.I$0 = 7;
                                                        anonymousClass1.label = 3;
                                                        objCoroutineScope = CoroutineScopeKt.coroutineScope(c0190x7b2613ed2, anonymousClass1);
                                                        if (objCoroutineScope == coroutine_suspended) {
                                                            return coroutine_suspended;
                                                        }
                                                        href4 = str4;
                                                        $this$withPermit$iv4 = $this$withPermit$iv;
                                                        Result.constructor-impl((List) objCoroutineScope);
                                                        $this$withPermit$iv = $this$withPermit$iv4;
                                                        unit = Unit.INSTANCE;
                                                    }
                                                } catch (Throwable th7) {
                                                    th = th7;
                                                    $this$withPermit$iv.release();
                                                    throw th;
                                                }
                                            } catch (Exception e4) {
                                                e = e4;
                                            }
                                        } catch (Exception e5) {
                                            e = e5;
                                            obj2 = obj3;
                                            $this$withPermit$iv = $this$withPermit$iv3;
                                        } catch (Throwable th8) {
                                            th = th8;
                                            $this$withPermit$iv = $this$withPermit$iv3;
                                            $this$withPermit$iv.release();
                                            throw th;
                                        }
                                    }
                                } catch (Exception e6) {
                                    e = e6;
                                    obj2 = obj;
                                    $this$withPermit$iv = $this$withPermit$iv2;
                                } catch (Throwable th9) {
                                    th = th9;
                                    $this$withPermit$iv = $this$withPermit$iv2;
                                    $this$withPermit$iv.release();
                                    throw th;
                                }
                                Log.INSTANCE.e("safeMap", "Request failed for " + obj2 + ' ' + e);
                            } else {
                                href = "";
                                if (!StringsKt.isBlank(href)) {
                                    obj2 = obj;
                                    $this$withPermit$iv = $this$withPermit$iv2;
                                    unit = Unit.INSTANCE;
                                } else {
                                    Requests app2 = MainActivityKt.getApp();
                                    this.L$0 = $this$withPermit$iv2;
                                    this.L$1 = obj;
                                    this.L$2 = SpillingKt.nullOutSpilledVariable($completion);
                                    this.L$3 = SpillingKt.nullOutSpilledVariable(entry);
                                    this.L$4 = SpillingKt.nullOutSpilledVariable(href);
                                    this.label = 2;
                                    $this$withPermit$iv3 = $this$withPermit$iv2;
                                    href2 = href;
                                    obj3 = obj;
                                    str = "href";
                                    str2 = "a";
                                    obj4 = Requests.get$default(app2, href2, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, this, 4094, (Object) null);
                                    anonymousClass1 = this;
                                    if (obj4 == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    href3 = href2;
                                    href4 = null;
                                    entry2 = entry;
                                    $completion2 = $completion;
                                    concurrency$iv = 0;
                                    obj2 = obj3;
                                    $this$withPermit$iv = $this$withPermit$iv3;
                                    doc = ((NiceResponse) obj4).getDocument();
                                    fEp = doc.selectFirst("h5:matches((?i)" + anonymousClass1.$sep$inlined + ')');
                                    linklist = new ArrayList();
                                    if (fEp != null) {
                                        str3 = str;
                                        strAttr = null;
                                        source1 = strAttr;
                                        if (fEp != null) {
                                            source2 = null;
                                        } else {
                                            source2 = null;
                                        }
                                        if (source1 != null) {
                                            linklist.add(source1);
                                        }
                                        if (source2 != null) {
                                            linklist.add(source2);
                                        }
                                        List $this$safeAmap_u24default$iv3 = linklist;
                                        Result.Companion companion5 = Result.Companion;
                                        String source5 = source2;
                                        C0190x7b2613ed c0190x7b2613ed3 = new C0190x7b2613ed(7, $this$safeAmap_u24default$iv3, null, anonymousClass1.$subtitleCallback$inlined, anonymousClass1.$callback$inlined);
                                        anonymousClass1.L$0 = $this$withPermit$iv;
                                        anonymousClass1.L$1 = obj2;
                                        str4 = href4;
                                        anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable($completion2);
                                        anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(entry2);
                                        anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(doc);
                                        anonymousClass1.L$5 = SpillingKt.nullOutSpilledVariable(fEp);
                                        anonymousClass1.L$6 = SpillingKt.nullOutSpilledVariable(linklist);
                                        anonymousClass1.L$7 = SpillingKt.nullOutSpilledVariable(href3);
                                        anonymousClass1.L$8 = SpillingKt.nullOutSpilledVariable(source5);
                                        anonymousClass1.L$9 = SpillingKt.nullOutSpilledVariable($this$safeAmap_u24default$iv3);
                                        anonymousClass1.L$10 = SpillingKt.nullOutSpilledVariable(source1);
                                        anonymousClass1.L$11 = SpillingKt.nullOutSpilledVariable(this);
                                        anonymousClass1.L$12 = SpillingKt.nullOutSpilledVariable($this$safeAmap_u24default$iv3);
                                        anonymousClass1.I$0 = 7;
                                        anonymousClass1.label = 3;
                                        objCoroutineScope = CoroutineScopeKt.coroutineScope(c0190x7b2613ed3, anonymousClass1);
                                        if (objCoroutineScope == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        href4 = str4;
                                        $this$withPermit$iv4 = $this$withPermit$iv;
                                        Result.constructor-impl((List) objCoroutineScope);
                                        $this$withPermit$iv = $this$withPermit$iv4;
                                        unit = Unit.INSTANCE;
                                    } else {
                                        elementNextElementSibling2 = fEp.nextElementSibling();
                                        if (elementNextElementSibling2 != null) {
                                            str3 = str;
                                            strAttr = null;
                                        } else {
                                            str3 = str;
                                            strAttr = null;
                                        }
                                        source1 = strAttr;
                                        if (fEp != null) {
                                            source2 = null;
                                        } else {
                                            source2 = null;
                                        }
                                        if (source1 != null) {
                                            linklist.add(source1);
                                        }
                                        if (source2 != null) {
                                            linklist.add(source2);
                                        }
                                        List $this$safeAmap_u24default$iv4 = linklist;
                                        Result.Companion companion6 = Result.Companion;
                                        String source6 = source2;
                                        C0190x7b2613ed c0190x7b2613ed4 = new C0190x7b2613ed(7, $this$safeAmap_u24default$iv4, null, anonymousClass1.$subtitleCallback$inlined, anonymousClass1.$callback$inlined);
                                        anonymousClass1.L$0 = $this$withPermit$iv;
                                        anonymousClass1.L$1 = obj2;
                                        str4 = href4;
                                        anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable($completion2);
                                        anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(entry2);
                                        anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(doc);
                                        anonymousClass1.L$5 = SpillingKt.nullOutSpilledVariable(fEp);
                                        anonymousClass1.L$6 = SpillingKt.nullOutSpilledVariable(linklist);
                                        anonymousClass1.L$7 = SpillingKt.nullOutSpilledVariable(href3);
                                        anonymousClass1.L$8 = SpillingKt.nullOutSpilledVariable(source6);
                                        anonymousClass1.L$9 = SpillingKt.nullOutSpilledVariable($this$safeAmap_u24default$iv4);
                                        anonymousClass1.L$10 = SpillingKt.nullOutSpilledVariable(source1);
                                        anonymousClass1.L$11 = SpillingKt.nullOutSpilledVariable(this);
                                        anonymousClass1.L$12 = SpillingKt.nullOutSpilledVariable($this$safeAmap_u24default$iv4);
                                        anonymousClass1.I$0 = 7;
                                        anonymousClass1.label = 3;
                                        objCoroutineScope = CoroutineScopeKt.coroutineScope(c0190x7b2613ed4, anonymousClass1);
                                        if (objCoroutineScope == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        href4 = str4;
                                        $this$withPermit$iv4 = $this$withPermit$iv;
                                        Result.constructor-impl((List) objCoroutineScope);
                                        $this$withPermit$iv = $this$withPermit$iv4;
                                        unit = Unit.INSTANCE;
                                    }
                                }
                                Log.INSTANCE.e("safeMap", "Request failed for " + obj2 + ' ' + e);
                            }
                            break;
                        } catch (Exception e7) {
                            e = e7;
                            obj2 = obj;
                            $this$withPermit$iv = $this$withPermit$iv2;
                        } catch (Throwable th10) {
                            th = th10;
                            $this$withPermit$iv = $this$withPermit$iv2;
                        }
                        $this$withPermit$iv.release();
                        return unit;
                    case 1:
                        Object obj6 = this.L$1;
                        Semaphore $this$withPermit$iv6 = (Semaphore) this.L$0;
                        ResultKt.throwOnFailure($result);
                        $i$f$withPermit = 0;
                        obj = obj6;
                        $this$withPermit$iv2 = $this$withPermit$iv6;
                        $completion = (Continuation) this;
                        entry = (Element) obj;
                        elementNextElementSibling = entry.nextElementSibling();
                        if (elementNextElementSibling == null) {
                            href = "";
                            if (!StringsKt.isBlank(href)) {
                                obj2 = obj;
                                $this$withPermit$iv = $this$withPermit$iv2;
                                unit = Unit.INSTANCE;
                            } else {
                                Requests app3 = MainActivityKt.getApp();
                                this.L$0 = $this$withPermit$iv2;
                                this.L$1 = obj;
                                this.L$2 = SpillingKt.nullOutSpilledVariable($completion);
                                this.L$3 = SpillingKt.nullOutSpilledVariable(entry);
                                this.L$4 = SpillingKt.nullOutSpilledVariable(href);
                                this.label = 2;
                                $this$withPermit$iv3 = $this$withPermit$iv2;
                                href2 = href;
                                obj3 = obj;
                                str = "href";
                                str2 = "a";
                                obj4 = Requests.get$default(app3, href2, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, this, 4094, (Object) null);
                                anonymousClass1 = this;
                                if (obj4 == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                href3 = href2;
                                href4 = null;
                                entry2 = entry;
                                $completion2 = $completion;
                                concurrency$iv = 0;
                                obj2 = obj3;
                                $this$withPermit$iv = $this$withPermit$iv3;
                                doc = ((NiceResponse) obj4).getDocument();
                                fEp = doc.selectFirst("h5:matches((?i)" + anonymousClass1.$sep$inlined + ')');
                                linklist = new ArrayList();
                                if (fEp != null) {
                                    str3 = str;
                                    strAttr = null;
                                    source1 = strAttr;
                                    if (fEp != null) {
                                        source2 = null;
                                    } else {
                                        source2 = null;
                                    }
                                    if (source1 != null) {
                                        linklist.add(source1);
                                    }
                                    if (source2 != null) {
                                        linklist.add(source2);
                                    }
                                    List $this$safeAmap_u24default$iv5 = linklist;
                                    Result.Companion companion7 = Result.Companion;
                                    String source7 = source2;
                                    C0190x7b2613ed c0190x7b2613ed5 = new C0190x7b2613ed(7, $this$safeAmap_u24default$iv5, null, anonymousClass1.$subtitleCallback$inlined, anonymousClass1.$callback$inlined);
                                    anonymousClass1.L$0 = $this$withPermit$iv;
                                    anonymousClass1.L$1 = obj2;
                                    str4 = href4;
                                    anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable($completion2);
                                    anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(entry2);
                                    anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(doc);
                                    anonymousClass1.L$5 = SpillingKt.nullOutSpilledVariable(fEp);
                                    anonymousClass1.L$6 = SpillingKt.nullOutSpilledVariable(linklist);
                                    anonymousClass1.L$7 = SpillingKt.nullOutSpilledVariable(href3);
                                    anonymousClass1.L$8 = SpillingKt.nullOutSpilledVariable(source7);
                                    anonymousClass1.L$9 = SpillingKt.nullOutSpilledVariable($this$safeAmap_u24default$iv5);
                                    anonymousClass1.L$10 = SpillingKt.nullOutSpilledVariable(source1);
                                    anonymousClass1.L$11 = SpillingKt.nullOutSpilledVariable(this);
                                    anonymousClass1.L$12 = SpillingKt.nullOutSpilledVariable($this$safeAmap_u24default$iv5);
                                    anonymousClass1.I$0 = 7;
                                    anonymousClass1.label = 3;
                                    objCoroutineScope = CoroutineScopeKt.coroutineScope(c0190x7b2613ed5, anonymousClass1);
                                    if (objCoroutineScope == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    href4 = str4;
                                    $this$withPermit$iv4 = $this$withPermit$iv;
                                    Result.constructor-impl((List) objCoroutineScope);
                                    $this$withPermit$iv = $this$withPermit$iv4;
                                    unit = Unit.INSTANCE;
                                } else {
                                    elementNextElementSibling2 = fEp.nextElementSibling();
                                    if (elementNextElementSibling2 != null) {
                                        str3 = str;
                                        strAttr = null;
                                    } else {
                                        str3 = str;
                                        strAttr = null;
                                    }
                                    source1 = strAttr;
                                    if (fEp != null) {
                                        source2 = null;
                                    } else {
                                        source2 = null;
                                    }
                                    if (source1 != null) {
                                        linklist.add(source1);
                                    }
                                    if (source2 != null) {
                                        linklist.add(source2);
                                    }
                                    List $this$safeAmap_u24default$iv6 = linklist;
                                    Result.Companion companion8 = Result.Companion;
                                    String source8 = source2;
                                    C0190x7b2613ed c0190x7b2613ed6 = new C0190x7b2613ed(7, $this$safeAmap_u24default$iv6, null, anonymousClass1.$subtitleCallback$inlined, anonymousClass1.$callback$inlined);
                                    anonymousClass1.L$0 = $this$withPermit$iv;
                                    anonymousClass1.L$1 = obj2;
                                    str4 = href4;
                                    anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable($completion2);
                                    anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(entry2);
                                    anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(doc);
                                    anonymousClass1.L$5 = SpillingKt.nullOutSpilledVariable(fEp);
                                    anonymousClass1.L$6 = SpillingKt.nullOutSpilledVariable(linklist);
                                    anonymousClass1.L$7 = SpillingKt.nullOutSpilledVariable(href3);
                                    anonymousClass1.L$8 = SpillingKt.nullOutSpilledVariable(source8);
                                    anonymousClass1.L$9 = SpillingKt.nullOutSpilledVariable($this$safeAmap_u24default$iv6);
                                    anonymousClass1.L$10 = SpillingKt.nullOutSpilledVariable(source1);
                                    anonymousClass1.L$11 = SpillingKt.nullOutSpilledVariable(this);
                                    anonymousClass1.L$12 = SpillingKt.nullOutSpilledVariable($this$safeAmap_u24default$iv6);
                                    anonymousClass1.I$0 = 7;
                                    anonymousClass1.label = 3;
                                    objCoroutineScope = CoroutineScopeKt.coroutineScope(c0190x7b2613ed6, anonymousClass1);
                                    if (objCoroutineScope == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    href4 = str4;
                                    $this$withPermit$iv4 = $this$withPermit$iv;
                                    Result.constructor-impl((List) objCoroutineScope);
                                    $this$withPermit$iv = $this$withPermit$iv4;
                                    unit = Unit.INSTANCE;
                                }
                            }
                            Log.INSTANCE.e("safeMap", "Request failed for " + obj2 + ' ' + e);
                            break;
                        } else {
                            elementSelectFirst = elementNextElementSibling.selectFirst("a");
                            if (elementSelectFirst != null) {
                                href = "";
                            } else {
                                href = "";
                            }
                            if (!StringsKt.isBlank(href)) {
                                obj2 = obj;
                                $this$withPermit$iv = $this$withPermit$iv2;
                                unit = Unit.INSTANCE;
                            } else {
                                Requests app4 = MainActivityKt.getApp();
                                this.L$0 = $this$withPermit$iv2;
                                this.L$1 = obj;
                                this.L$2 = SpillingKt.nullOutSpilledVariable($completion);
                                this.L$3 = SpillingKt.nullOutSpilledVariable(entry);
                                this.L$4 = SpillingKt.nullOutSpilledVariable(href);
                                this.label = 2;
                                $this$withPermit$iv3 = $this$withPermit$iv2;
                                href2 = href;
                                obj3 = obj;
                                str = "href";
                                str2 = "a";
                                obj4 = Requests.get$default(app4, href2, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, this, 4094, (Object) null);
                                anonymousClass1 = this;
                                if (obj4 == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                href3 = href2;
                                href4 = null;
                                entry2 = entry;
                                $completion2 = $completion;
                                concurrency$iv = 0;
                                obj2 = obj3;
                                $this$withPermit$iv = $this$withPermit$iv3;
                                doc = ((NiceResponse) obj4).getDocument();
                                fEp = doc.selectFirst("h5:matches((?i)" + anonymousClass1.$sep$inlined + ')');
                                linklist = new ArrayList();
                                if (fEp != null) {
                                    str3 = str;
                                    strAttr = null;
                                    source1 = strAttr;
                                    if (fEp != null) {
                                        source2 = null;
                                    } else {
                                        source2 = null;
                                    }
                                    if (source1 != null) {
                                        linklist.add(source1);
                                    }
                                    if (source2 != null) {
                                        linklist.add(source2);
                                    }
                                    List $this$safeAmap_u24default$iv7 = linklist;
                                    Result.Companion companion9 = Result.Companion;
                                    String source9 = source2;
                                    C0190x7b2613ed c0190x7b2613ed7 = new C0190x7b2613ed(7, $this$safeAmap_u24default$iv7, null, anonymousClass1.$subtitleCallback$inlined, anonymousClass1.$callback$inlined);
                                    anonymousClass1.L$0 = $this$withPermit$iv;
                                    anonymousClass1.L$1 = obj2;
                                    str4 = href4;
                                    anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable($completion2);
                                    anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(entry2);
                                    anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(doc);
                                    anonymousClass1.L$5 = SpillingKt.nullOutSpilledVariable(fEp);
                                    anonymousClass1.L$6 = SpillingKt.nullOutSpilledVariable(linklist);
                                    anonymousClass1.L$7 = SpillingKt.nullOutSpilledVariable(href3);
                                    anonymousClass1.L$8 = SpillingKt.nullOutSpilledVariable(source9);
                                    anonymousClass1.L$9 = SpillingKt.nullOutSpilledVariable($this$safeAmap_u24default$iv7);
                                    anonymousClass1.L$10 = SpillingKt.nullOutSpilledVariable(source1);
                                    anonymousClass1.L$11 = SpillingKt.nullOutSpilledVariable(this);
                                    anonymousClass1.L$12 = SpillingKt.nullOutSpilledVariable($this$safeAmap_u24default$iv7);
                                    anonymousClass1.I$0 = 7;
                                    anonymousClass1.label = 3;
                                    objCoroutineScope = CoroutineScopeKt.coroutineScope(c0190x7b2613ed7, anonymousClass1);
                                    if (objCoroutineScope == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    href4 = str4;
                                    $this$withPermit$iv4 = $this$withPermit$iv;
                                    Result.constructor-impl((List) objCoroutineScope);
                                    $this$withPermit$iv = $this$withPermit$iv4;
                                    unit = Unit.INSTANCE;
                                } else {
                                    elementNextElementSibling2 = fEp.nextElementSibling();
                                    if (elementNextElementSibling2 != null) {
                                        str3 = str;
                                        strAttr = null;
                                    } else {
                                        str3 = str;
                                        strAttr = null;
                                    }
                                    source1 = strAttr;
                                    if (fEp != null) {
                                        source2 = null;
                                    } else {
                                        source2 = null;
                                    }
                                    if (source1 != null) {
                                        linklist.add(source1);
                                    }
                                    if (source2 != null) {
                                        linklist.add(source2);
                                    }
                                    List $this$safeAmap_u24default$iv8 = linklist;
                                    Result.Companion companion10 = Result.Companion;
                                    String source10 = source2;
                                    C0190x7b2613ed c0190x7b2613ed8 = new C0190x7b2613ed(7, $this$safeAmap_u24default$iv8, null, anonymousClass1.$subtitleCallback$inlined, anonymousClass1.$callback$inlined);
                                    anonymousClass1.L$0 = $this$withPermit$iv;
                                    anonymousClass1.L$1 = obj2;
                                    str4 = href4;
                                    anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable($completion2);
                                    anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(entry2);
                                    anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(doc);
                                    anonymousClass1.L$5 = SpillingKt.nullOutSpilledVariable(fEp);
                                    anonymousClass1.L$6 = SpillingKt.nullOutSpilledVariable(linklist);
                                    anonymousClass1.L$7 = SpillingKt.nullOutSpilledVariable(href3);
                                    anonymousClass1.L$8 = SpillingKt.nullOutSpilledVariable(source10);
                                    anonymousClass1.L$9 = SpillingKt.nullOutSpilledVariable($this$safeAmap_u24default$iv8);
                                    anonymousClass1.L$10 = SpillingKt.nullOutSpilledVariable(source1);
                                    anonymousClass1.L$11 = SpillingKt.nullOutSpilledVariable(this);
                                    anonymousClass1.L$12 = SpillingKt.nullOutSpilledVariable($this$safeAmap_u24default$iv8);
                                    anonymousClass1.I$0 = 7;
                                    anonymousClass1.label = 3;
                                    objCoroutineScope = CoroutineScopeKt.coroutineScope(c0190x7b2613ed8, anonymousClass1);
                                    if (objCoroutineScope == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    href4 = str4;
                                    $this$withPermit$iv4 = $this$withPermit$iv;
                                    Result.constructor-impl((List) objCoroutineScope);
                                    $this$withPermit$iv = $this$withPermit$iv4;
                                    unit = Unit.INSTANCE;
                                }
                            }
                            Log.INSTANCE.e("safeMap", "Request failed for " + obj2 + ' ' + e);
                            break;
                        }
                        $this$withPermit$iv.release();
                        return unit;
                    case 2:
                        concurrency$iv = 0;
                        String href5 = (String) this.L$4;
                        Element entry3 = (Element) this.L$3;
                        Continuation $completion3 = (Continuation) this.L$2;
                        obj2 = this.L$1;
                        $this$withPermit$iv = (Semaphore) this.L$0;
                        try {
                            ResultKt.throwOnFailure($result);
                            anonymousClass1 = this;
                            str2 = "a";
                            $i$f$withPermit = 0;
                            str = "href";
                            href4 = null;
                            href3 = href5;
                            entry2 = entry3;
                            $completion2 = $completion3;
                            obj4 = $result;
                            doc = ((NiceResponse) obj4).getDocument();
                            fEp = doc.selectFirst("h5:matches((?i)" + anonymousClass1.$sep$inlined + ')');
                            linklist = new ArrayList();
                            if (fEp != null) {
                                str3 = str;
                                strAttr = null;
                                source1 = strAttr;
                                if (fEp != null) {
                                    source2 = null;
                                } else {
                                    source2 = null;
                                }
                                if (source1 != null) {
                                    linklist.add(source1);
                                }
                                if (source2 != null) {
                                    linklist.add(source2);
                                }
                                List $this$safeAmap_u24default$iv9 = linklist;
                                Result.Companion companion11 = Result.Companion;
                                String source11 = source2;
                                C0190x7b2613ed c0190x7b2613ed9 = new C0190x7b2613ed(7, $this$safeAmap_u24default$iv9, null, anonymousClass1.$subtitleCallback$inlined, anonymousClass1.$callback$inlined);
                                anonymousClass1.L$0 = $this$withPermit$iv;
                                anonymousClass1.L$1 = obj2;
                                str4 = href4;
                                anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable($completion2);
                                anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(entry2);
                                anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(doc);
                                anonymousClass1.L$5 = SpillingKt.nullOutSpilledVariable(fEp);
                                anonymousClass1.L$6 = SpillingKt.nullOutSpilledVariable(linklist);
                                anonymousClass1.L$7 = SpillingKt.nullOutSpilledVariable(href3);
                                anonymousClass1.L$8 = SpillingKt.nullOutSpilledVariable(source11);
                                anonymousClass1.L$9 = SpillingKt.nullOutSpilledVariable($this$safeAmap_u24default$iv9);
                                anonymousClass1.L$10 = SpillingKt.nullOutSpilledVariable(source1);
                                anonymousClass1.L$11 = SpillingKt.nullOutSpilledVariable(this);
                                anonymousClass1.L$12 = SpillingKt.nullOutSpilledVariable($this$safeAmap_u24default$iv9);
                                anonymousClass1.I$0 = 7;
                                anonymousClass1.label = 3;
                                objCoroutineScope = CoroutineScopeKt.coroutineScope(c0190x7b2613ed9, anonymousClass1);
                                if (objCoroutineScope == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                href4 = str4;
                                $this$withPermit$iv4 = $this$withPermit$iv;
                                Result.constructor-impl((List) objCoroutineScope);
                                $this$withPermit$iv = $this$withPermit$iv4;
                                unit = Unit.INSTANCE;
                            } else {
                                elementNextElementSibling2 = fEp.nextElementSibling();
                                if (elementNextElementSibling2 != null) {
                                    str3 = str;
                                    strAttr = null;
                                } else {
                                    str3 = str;
                                    strAttr = null;
                                }
                                source1 = strAttr;
                                if (fEp != null) {
                                    source2 = null;
                                } else {
                                    source2 = null;
                                }
                                if (source1 != null) {
                                    linklist.add(source1);
                                }
                                if (source2 != null) {
                                    linklist.add(source2);
                                }
                                List $this$safeAmap_u24default$iv10 = linklist;
                                Result.Companion companion12 = Result.Companion;
                                String source12 = source2;
                                C0190x7b2613ed c0190x7b2613ed10 = new C0190x7b2613ed(7, $this$safeAmap_u24default$iv10, null, anonymousClass1.$subtitleCallback$inlined, anonymousClass1.$callback$inlined);
                                anonymousClass1.L$0 = $this$withPermit$iv;
                                anonymousClass1.L$1 = obj2;
                                str4 = href4;
                                anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable($completion2);
                                anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(entry2);
                                anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(doc);
                                anonymousClass1.L$5 = SpillingKt.nullOutSpilledVariable(fEp);
                                anonymousClass1.L$6 = SpillingKt.nullOutSpilledVariable(linklist);
                                anonymousClass1.L$7 = SpillingKt.nullOutSpilledVariable(href3);
                                anonymousClass1.L$8 = SpillingKt.nullOutSpilledVariable(source12);
                                anonymousClass1.L$9 = SpillingKt.nullOutSpilledVariable($this$safeAmap_u24default$iv10);
                                anonymousClass1.L$10 = SpillingKt.nullOutSpilledVariable(source1);
                                anonymousClass1.L$11 = SpillingKt.nullOutSpilledVariable(this);
                                anonymousClass1.L$12 = SpillingKt.nullOutSpilledVariable($this$safeAmap_u24default$iv10);
                                anonymousClass1.I$0 = 7;
                                anonymousClass1.label = 3;
                                objCoroutineScope = CoroutineScopeKt.coroutineScope(c0190x7b2613ed10, anonymousClass1);
                                if (objCoroutineScope == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                href4 = str4;
                                $this$withPermit$iv4 = $this$withPermit$iv;
                                Result.constructor-impl((List) objCoroutineScope);
                                $this$withPermit$iv = $this$withPermit$iv4;
                                unit = Unit.INSTANCE;
                            }
                            break;
                        } catch (Exception e8) {
                            e = e8;
                            break;
                        } catch (Throwable th11) {
                            th = th11;
                            $this$withPermit$iv.release();
                            throw th;
                        }
                        $this$withPermit$iv.release();
                        return unit;
                    case 3:
                        href4 = null;
                        int i = this.I$0;
                        href3 = (String) this.L$7;
                        entry2 = (Element) this.L$3;
                        $completion2 = (Continuation) this.L$2;
                        $i$f$withPermit = 0;
                        Object obj7 = this.L$1;
                        $this$withPermit$iv4 = (Semaphore) this.L$0;
                        try {
                            ResultKt.throwOnFailure($result);
                            concurrency$iv = 0;
                            obj2 = obj7;
                            objCoroutineScope = $result;
                            Result.constructor-impl((List) objCoroutineScope);
                        } catch (Throwable th12) {
                            th = th12;
                            concurrency$iv = 0;
                            obj2 = obj7;
                            $i$f$withPermit2 = 0;
                            Result.Companion companion13 = Result.Companion;
                            Result.constructor-impl(ResultKt.createFailure(th));
                            $i$f$withPermit = $i$f$withPermit2;
                            $this$withPermit$iv = $this$withPermit$iv4;
                            unit = Unit.INSTANCE;
                            $this$withPermit$iv.release();
                            return unit;
                        }
                        $this$withPermit$iv = $this$withPermit$iv4;
                        unit = Unit.INSTANCE;
                        $this$withPermit$iv.release();
                        return unit;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } catch (Throwable th13) {
                th = th13;
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
                    destination$iv$iv2.add(BuildersKt.async$default($this$coroutineScope, Dispatchers.getIO(), (CoroutineStart) null, new AnonymousClass1(semaphore, item$iv$iv, null, this.$sep$inlined, this.$subtitleCallback$inlined, this.$callback$inlined), 2, (Object) null));
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
