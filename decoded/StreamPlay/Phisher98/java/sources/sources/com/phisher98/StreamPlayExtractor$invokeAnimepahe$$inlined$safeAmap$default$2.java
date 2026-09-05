package com.phisher98;

import com.lagradost.api.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
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
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.sync.Semaphore;
import kotlinx.coroutines.sync.SemaphoreKt;
import org.jsoup.nodes.Element;

/* JADX INFO: compiled from: StreamPlayUtils.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StreamPlay/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\b\u00028\u00000\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "com/phisher98/StreamPlayUtilsKt$safeAmap$2$1"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.phisher98.StreamPlayExtractor$invokeAnimepahe$$inlined$safeAmap$default$2", f = "StreamPlayExtractor.kt", i = {0, 0}, l = {1898}, m = "invokeSuspend", n = {"$this$coroutineScope", "semaphore"}, nl = {-1}, s = {"L$0", "L$1"}, v = 2)
@SourceDebugExtension({"SMAP\nStreamPlayUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,2265:1\n1739#2:2266\n1814#2,3:2267\n*S KotlinDebug\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1\n*L\n1887#1:2266\n1887#1:2267,3\n*E\n"})
public final class StreamPlayExtractor$invokeAnimepahe$$inlined$safeAmap$default$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Unit>>, Object> {
    final /* synthetic */ Function1 $callback$inlined;
    final /* synthetic */ int $concurrency;
    final /* synthetic */ String $dubtype$inlined;
    final /* synthetic */ boolean $isMovie$inlined;
    final /* synthetic */ Function1 $subtitleCallback$inlined;
    final /* synthetic */ Iterable $this_runCatching;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StreamPlayExtractor$invokeAnimepahe$$inlined$safeAmap$default$2(int i, Iterable iterable, Continuation continuation, boolean z, String str, Function1 function1, Function1 function2) {
        super(2, continuation);
        this.$concurrency = i;
        this.$this_runCatching = iterable;
        this.$isMovie$inlined = z;
        this.$dubtype$inlined = str;
        this.$subtitleCallback$inlined = function1;
        this.$callback$inlined = function2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> streamPlayExtractor$invokeAnimepahe$$inlined$safeAmap$default$2 = new StreamPlayExtractor$invokeAnimepahe$$inlined$safeAmap$default$2(this.$concurrency, this.$this_runCatching, continuation, this.$isMovie$inlined, this.$dubtype$inlined, this.$subtitleCallback$inlined, this.$callback$inlined);
        streamPlayExtractor$invokeAnimepahe$$inlined$safeAmap$default$2.L$0 = obj;
        return streamPlayExtractor$invokeAnimepahe$$inlined$safeAmap$default$2;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends Unit>> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: renamed from: com.phisher98.StreamPlayExtractor$invokeAnimepahe$$inlined$safeAmap$default$2$1 */
    /* JADX INFO: compiled from: StreamPlayUtils.kt */
    @Metadata(d1 = {"\u0000\n\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", "B", "Lkotlinx/coroutines/CoroutineScope;", "com/phisher98/StreamPlayUtilsKt$safeAmap$2$1$1$1"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StreamPlayExtractor$invokeAnimepahe$$inlined$safeAmap$default$2$1", f = "StreamPlayExtractor.kt", i = {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {2266, 2281}, m = "invokeSuspend", n = {"$this$withPermit$iv", "$this$withPermit$iv", "$completion", "it", "qualityRegex", "href", "type", "text", "match", "quality", "source"}, nl = {2267, 2291}, s = {"L$0", "L$0", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10"}, v = 2)
    @SourceDebugExtension({"SMAP\nStreamPlayUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1$1$1\n+ 2 Semaphore.kt\nkotlinx/coroutines/sync/SemaphoreKt\n+ 3 StreamPlayExtractor.kt\ncom/phisher98/StreamPlayExtractor\n*L\n1#1,2265:1\n81#2,3:2266\n85#2,2:2292\n960#3,23:2269\n*S KotlinDebug\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1$1$1\n*L\n1889#1:2266,3\n1889#1:2292,2\n*E\n"})
    public static final class C01301 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1 $callback$inlined;
        final /* synthetic */ String $dubtype$inlined;
        final /* synthetic */ boolean $isMovie$inlined;
        final /* synthetic */ Object $item;
        final /* synthetic */ Semaphore $semaphore;
        final /* synthetic */ Function1 $subtitleCallback$inlined;
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
        public C01301(Semaphore semaphore, Object obj, Continuation continuation, boolean z, String str, Function1 function1, Function1 function2) {
            super(2, continuation);
            this.$semaphore = semaphore;
            this.$item = obj;
            this.$isMovie$inlined = z;
            this.$dubtype$inlined = str;
            this.$subtitleCallback$inlined = function1;
            this.$callback$inlined = function2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C01301(this.$semaphore, this.$item, continuation, this.$isMovie$inlined, this.$dubtype$inlined, this.$subtitleCallback$inlined, this.$callback$inlined);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:21:0x00ac  */
        /* JADX WARN: Code duplicated, block: B:29:0x00d3  */
        /* JADX WARN: Code duplicated, block: B:39:0x00f2  */
        /* JADX WARN: Code duplicated, block: B:50:0x018c A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:51:0x018d  */
        public final Object invokeSuspend(Object $result) throws Throwable {
            Semaphore $this$withPermit$iv;
            int $i$f$withPermit;
            Object obj;
            int $i$f$withPermit2;
            int i;
            Element it;
            Regex qualityRegex;
            String type;
            MatchResult match;
            String source;
            Regex qualityRegex2;
            Object objLoadDisplaySourceNameExtractor;
            Object obj2;
            Object obj3;
            List groupValues;
            String str;
            List groupValues2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    Semaphore $this$withPermit$iv2 = this.$semaphore;
                    Object obj4 = this.$item;
                    this.L$0 = $this$withPermit$iv2;
                    this.L$1 = obj4;
                    this.label = 1;
                    if ($this$withPermit$iv2.acquire((Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $this$withPermit$iv = $this$withPermit$iv2;
                    $i$f$withPermit = 0;
                    obj = obj4;
                    try {
                        Continuation $completion = (Continuation) this;
                        it = (Element) obj;
                        qualityRegex = new Regex("(.+?)\\s+·\\s+(\\d{3,4}p)");
                        String href = it.attr("href");
                        type = StringsKt.contains(it.select("span").text(), "eng", true) ? "DUB" : "SUB";
                        String text = it.text();
                        match = Regex.find$default(qualityRegex, text, 0, 2, (Object) null);
                        String str2 = "Unknown";
                        if (match != null || (groupValues2 = match.getGroupValues()) == null || (source = (String) CollectionsKt.getOrNull(groupValues2, 1)) == null) {
                            source = "Unknown";
                        }
                        if (match != null || (groupValues = match.getGroupValues()) == null || (str = (String) CollectionsKt.getOrNull(groupValues, 2)) == null) {
                            qualityRegex2 = qualityRegex;
                        } else {
                            qualityRegex2 = qualityRegex;
                            String strSubstringBefore$default = StringsKt.substringBefore$default(str, "p", (String) null, 2, (Object) null);
                            if (strSubstringBefore$default != null) {
                                str2 = strSubstringBefore$default;
                            }
                        }
                        String quality = str2;
                        if (!this.$isMovie$inlined || (this.$dubtype$inlined != null && StringsKt.contains(type, this.$dubtype$inlined, true))) {
                            String str3 = "⌜ Animepahe ⌟ Pahe " + source + " | [" + type + ']';
                            Function1 function1 = this.$subtitleCallback$inlined;
                            String source2 = source;
                            Function1 function2 = this.$callback$inlined;
                            Integer intOrNull = StringsKt.toIntOrNull(quality);
                            this.L$0 = $this$withPermit$iv;
                            this.L$1 = obj;
                            this.L$2 = SpillingKt.nullOutSpilledVariable($completion);
                            this.L$3 = SpillingKt.nullOutSpilledVariable(it);
                            this.L$4 = SpillingKt.nullOutSpilledVariable(qualityRegex2);
                            this.L$5 = SpillingKt.nullOutSpilledVariable(href);
                            this.L$6 = SpillingKt.nullOutSpilledVariable(type);
                            this.L$7 = SpillingKt.nullOutSpilledVariable(text);
                            this.L$8 = SpillingKt.nullOutSpilledVariable(match);
                            this.L$9 = SpillingKt.nullOutSpilledVariable(quality);
                            this.L$10 = SpillingKt.nullOutSpilledVariable(source2);
                            this.label = 2;
                            objLoadDisplaySourceNameExtractor = StreamPlayUtilsKt.loadDisplaySourceNameExtractor("Animepahe Pahe", str3, href, "", function1, function2, intOrNull, this);
                            if (objLoadDisplaySourceNameExtractor == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            obj2 = objLoadDisplaySourceNameExtractor;
                            i = 0;
                            obj3 = obj2;
                        } else {
                            obj3 = Unit.INSTANCE;
                        }
                    } catch (Exception e) {
                        e = e;
                        $i$f$withPermit2 = $i$f$withPermit;
                        i = 0;
                        Log.INSTANCE.e("safeMap", "Request failed for " + obj + ' ' + e);
                        obj3 = null;
                    } catch (Throwable th) {
                        th = th;
                        $this$withPermit$iv.release();
                        throw th;
                    }
                    $this$withPermit$iv.release();
                    return obj3;
                case 1:
                    Object obj5 = this.L$1;
                    Semaphore $this$withPermit$iv3 = (Semaphore) this.L$0;
                    ResultKt.throwOnFailure($result);
                    $i$f$withPermit = 0;
                    $this$withPermit$iv = $this$withPermit$iv3;
                    obj = obj5;
                    Continuation $completion2 = (Continuation) this;
                    it = (Element) obj;
                    qualityRegex = new Regex("(.+?)\\s+·\\s+(\\d{3,4}p)");
                    String href2 = it.attr("href");
                    if (StringsKt.contains(it.select("span").text(), "eng", true)) {
                    }
                    String text2 = it.text();
                    match = Regex.find$default(qualityRegex, text2, 0, 2, (Object) null);
                    String str4 = "Unknown";
                    if (match != null) {
                        source = "Unknown";
                    } else {
                        source = "Unknown";
                    }
                    if (match != null) {
                        qualityRegex2 = qualityRegex;
                    } else {
                        qualityRegex2 = qualityRegex;
                    }
                    String quality2 = str4;
                    if (this.$isMovie$inlined) {
                    }
                    String str5 = "⌜ Animepahe ⌟ Pahe " + source + " | [" + type + ']';
                    Function1 function3 = this.$subtitleCallback$inlined;
                    String source3 = source;
                    Function1 function4 = this.$callback$inlined;
                    Integer intOrNull2 = StringsKt.toIntOrNull(quality2);
                    this.L$0 = $this$withPermit$iv;
                    this.L$1 = obj;
                    this.L$2 = SpillingKt.nullOutSpilledVariable($completion2);
                    this.L$3 = SpillingKt.nullOutSpilledVariable(it);
                    this.L$4 = SpillingKt.nullOutSpilledVariable(qualityRegex2);
                    this.L$5 = SpillingKt.nullOutSpilledVariable(href2);
                    this.L$6 = SpillingKt.nullOutSpilledVariable(type);
                    this.L$7 = SpillingKt.nullOutSpilledVariable(text2);
                    this.L$8 = SpillingKt.nullOutSpilledVariable(match);
                    this.L$9 = SpillingKt.nullOutSpilledVariable(quality2);
                    this.L$10 = SpillingKt.nullOutSpilledVariable(source3);
                    this.label = 2;
                    objLoadDisplaySourceNameExtractor = StreamPlayUtilsKt.loadDisplaySourceNameExtractor("Animepahe Pahe", str5, href2, "", function3, function4, intOrNull2, this);
                    if (objLoadDisplaySourceNameExtractor == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    obj2 = objLoadDisplaySourceNameExtractor;
                    i = 0;
                    obj3 = obj2;
                    $this$withPermit$iv.release();
                    return obj3;
                case 2:
                    $i$f$withPermit2 = 0;
                    i = 0;
                    obj = this.L$1;
                    $this$withPermit$iv = (Semaphore) this.L$0;
                    try {
                        try {
                            ResultKt.throwOnFailure($result);
                            obj2 = $result;
                            obj3 = obj2;
                        } catch (Exception e2) {
                            e = e2;
                            Log.INSTANCE.e("safeMap", "Request failed for " + obj + ' ' + e);
                            obj3 = null;
                        }
                        $this$withPermit$iv.release();
                        return obj3;
                    } catch (Throwable th2) {
                        th = th2;
                        $this$withPermit$iv.release();
                        throw th;
                    }
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
                    destination$iv$iv2.add(BuildersKt.async$default($this$coroutineScope, Dispatchers.getIO(), (CoroutineStart) null, new C01301(semaphore, item$iv$iv, null, this.$isMovie$inlined, this.$dubtype$inlined, this.$subtitleCallback$inlined, this.$callback$inlined), 2, (Object) null));
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
