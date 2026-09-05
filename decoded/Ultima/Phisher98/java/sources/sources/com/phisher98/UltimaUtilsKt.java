package com.phisher98;

import com.lagradost.api.Log;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: UltimaUtils.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Ultima/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u001a\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u0086@¢\u0006\u0002\u0010\u0007\u001aH\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\n0\t\"\u0004\b\u0000\u0010\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\"\u0010\r\u001a\u001e\u0012\u001a\u0012\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\n0\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000e0\tH\u0086@¢\u0006\u0002\u0010\u0011\u001a\u000e\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"cachedDomains", "Lcom/phisher98/DomainsParser;", "DOMAINS_URL", "", "getDomains", "forceRefresh", "", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "runLimitedParallel", "", "T", "limit", "", "blockList", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(ILjava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cleanTitle", "title", "Ultima"}, k = 2, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nUltimaUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UltimaUtils.kt\ncom/phisher98/UltimaUtilsKt\n+ 2 NiceResponse.kt\ncom/lagradost/nicehttp/NiceResponse\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,229:1\n73#2,5:230\n363#3,3:235\n1960#3,3:238\n366#3,4:241\n391#3,3:245\n1960#3,3:248\n1960#3,3:251\n1960#3,3:254\n394#3,4:257\n*S KotlinDebug\n*F\n+ 1 UltimaUtils.kt\ncom/phisher98/UltimaUtilsKt\n*L\n165#1:230,5\n212#1:235,3\n213#1:238,3\n212#1:241,4\n216#1:245,3\n217#1:248,3\n218#1:251,3\n219#1:254,3\n216#1:257,4\n*E\n"})
public final class UltimaUtilsKt {

    @NotNull
    private static final String DOMAINS_URL = "https://raw.githubusercontent.com/phisher98/TVVVV/main/domains.json";

    @Nullable
    private static DomainsParser cachedDomains;

    /* JADX INFO: renamed from: com.phisher98.UltimaUtilsKt$getDomains$1 */
    /* JADX INFO: compiled from: UltimaUtils.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.UltimaUtilsKt", f = "UltimaUtils.kt", i = {0}, l = {164}, m = "getDomains", n = {"forceRefresh"}, nl = {165}, s = {"Z$0"}, v = 2)
    static final class C00321 extends ContinuationImpl {
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C00321(Continuation<? super C00321> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UltimaUtilsKt.getDomains(false, (Continuation) this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:39:0x00c3 A[Catch: Exception -> 0x00ce, TRY_LEAVE, TryCatch #1 {Exception -> 0x00ce, blocks: (B:31:0x0099, B:37:0x00bb, B:39:0x00c3, B:36:0x00b5, B:33:0x009e), top: B:55:0x0099, inners: #4 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public static final Object getDomains(boolean forceRefresh, @NotNull Continuation<? super DomainsParser> continuation) {
        C00321 c00321;
        String str;
        boolean forceRefresh2;
        Object safe;
        if (continuation instanceof C00321) {
            c00321 = (C00321) continuation;
            if ((c00321.label & Integer.MIN_VALUE) != 0) {
                c00321.label -= Integer.MIN_VALUE;
            } else {
                c00321 = new C00321(continuation);
            }
        } else {
            c00321 = new C00321(continuation);
        }
        C00321 c00322 = c00321;
        Object $result = c00322.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00322.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (cachedDomains == null || forceRefresh) {
                    try {
                        Requests app = MainActivityKt.getApp();
                        try {
                            c00322.Z$0 = forceRefresh;
                            c00322.label = 1;
                            str = "getDomains";
                            try {
                                $result = Requests.get$default(app, DOMAINS_URL, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00322, 4094, (Object) null);
                                if ($result == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                forceRefresh2 = forceRefresh;
                                try {
                                    NiceResponse response = (NiceResponse) $result;
                                    try {
                                        ResponseParser parser = response.getParser();
                                        Intrinsics.checkNotNull(parser);
                                        safe = parser.parseSafe(response.getText(), Reflection.getOrCreateKotlinClass(DomainsParser.class));
                                    } catch (Exception e$iv) {
                                        e$iv.printStackTrace();
                                        safe = null;
                                    }
                                    cachedDomains = (DomainsParser) safe;
                                    if (cachedDomains == null) {
                                        Log.INSTANCE.e(str, "Parsed domains are null. Possibly malformed JSON.");
                                    }
                                } catch (Exception e) {
                                    e = e;
                                    Log.INSTANCE.e(str, "Error fetching/parsing domains: " + e.getMessage());
                                    return null;
                                }
                            } catch (Exception e2) {
                                e = e2;
                                Log.INSTANCE.e(str, "Error fetching/parsing domains: " + e.getMessage());
                                return null;
                            }
                        } catch (Exception e3) {
                            e = e3;
                            str = "getDomains";
                        }
                    } catch (Exception e4) {
                        e = e4;
                        str = "getDomains";
                    }
                    break;
                }
                return cachedDomains;
            case 1:
                boolean forceRefresh3 = c00322.Z$0;
                try {
                    ResultKt.throwOnFailure($result);
                    forceRefresh2 = forceRefresh3;
                    str = "getDomains";
                    NiceResponse response2 = (NiceResponse) $result;
                    ResponseParser parser2 = response2.getParser();
                    Intrinsics.checkNotNull(parser2);
                    safe = parser2.parseSafe(response2.getText(), Reflection.getOrCreateKotlinClass(DomainsParser.class));
                    cachedDomains = (DomainsParser) safe;
                    if (cachedDomains == null) {
                        Log.INSTANCE.e(str, "Parsed domains are null. Possibly malformed JSON.");
                        break;
                    }
                    return cachedDomains;
                } catch (Exception e5) {
                    e = e5;
                    str = "getDomains";
                    Log.INSTANCE.e(str, "Error fetching/parsing domains: " + e.getMessage());
                    return null;
                }
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public static /* synthetic */ Object getDomains$default(boolean z, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return getDomains(z, continuation);
    }

    public static /* synthetic */ Object runLimitedParallel$default(int i, List list, Continuation continuation, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 4;
        }
        return runLimitedParallel(i, list, continuation);
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: com.phisher98.UltimaUtilsKt$runLimitedParallel$2 */
    /* JADX INFO: compiled from: UltimaUtils.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.UltimaUtilsKt$runLimitedParallel$2", f = "UltimaUtils.kt", i = {0}, l = {187}, m = "invokeSuspend", n = {"$this$coroutineScope"}, nl = {-1}, s = {"L$0"}, v = 2)
    @SourceDebugExtension({"SMAP\nUltimaUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UltimaUtils.kt\ncom/phisher98/UltimaUtilsKt$runLimitedParallel$2\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,229:1\n1739#2:230\n1814#2,3:231\n*S KotlinDebug\n*F\n+ 1 UltimaUtils.kt\ncom/phisher98/UltimaUtilsKt$runLimitedParallel$2\n*L\n183#1:230\n183#1:231,3\n*E\n"})
    static final class C00332<T> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends T>>, Object> {
        final /* synthetic */ List<Function1<Continuation<? super T>, Object>> $blockList;
        final /* synthetic */ Semaphore $semaphore;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00332(List<? extends Function1<? super Continuation<? super T>, ? extends Object>> list, Semaphore semaphore, Continuation<? super C00332> continuation) {
            super(2, continuation);
            this.$blockList = list;
            this.$semaphore = semaphore;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00332 = new C00332<>(this.$blockList, this.$semaphore, continuation);
            c00332.L$0 = obj;
            return c00332;
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends T>> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            CoroutineScope $this$coroutineScope = (CoroutineScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    Iterable $this$map$iv = this.$blockList;
                    Semaphore semaphore = this.$semaphore;
                    Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                    for (Object item$iv$iv : $this$map$iv) {
                        Function1 block = (Function1) item$iv$iv;
                        destination$iv$iv.add(BuildersKt.async$default($this$coroutineScope, Dispatchers.getIO(), (CoroutineStart) null, new UltimaUtilsKt$runLimitedParallel$2$1$1(semaphore, block, null), 2, (Object) null));
                    }
                    this.L$0 = SpillingKt.nullOutSpilledVariable($this$coroutineScope);
                    this.label = 1;
                    Object objAwaitAll = AwaitKt.awaitAll((List) destination$iv$iv, (Continuation) this);
                    if (objAwaitAll == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return objAwaitAll;
                case 1:
                    ResultKt.throwOnFailure($result);
                    return $result;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    @Nullable
    public static final <T> Object runLimitedParallel(int limit, @NotNull List<? extends Function1<? super Continuation<? super T>, ? extends Object>> list, @NotNull Continuation<? super List<? extends T>> continuation) {
        Semaphore semaphore = SemaphoreKt.Semaphore$default(limit, 0, 2, (Object) null);
        return CoroutineScopeKt.coroutineScope(new C00332(list, semaphore, null), continuation);
    }

    /* JADX WARN: Code duplicated, block: B:70:0x01de  */
    @NotNull
    public static final String cleanTitle(@NotNull String title) {
        List audioTags;
        int endIndex;
        List $this$indexOfLast$iv;
        int $i$f$indexOfLast;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        List qualityTags;
        boolean z5;
        List parts = StringsKt.split$default(title, new String[]{".", "-", "_"}, false, 0, 6, (Object) null);
        List qualityTags2 = CollectionsKt.listOf(new String[]{"WEBRip", "WEB-DL", "WEB", "BluRay", "HDRip", "DVDRip", "HDTV", "CAM", "TS", "R5", "DVDScr", "BRRip", "BDRip", "DVD", "PDTV", "HD"});
        List audioTags2 = CollectionsKt.listOf(new String[]{"AAC", "AC3", "DTS", "MP3", "FLAC", "DD5", "EAC3", "Atmos"});
        Iterable subTags = CollectionsKt.listOf(new String[]{"ESub", "ESubs", "Subs", "MultiSub", "NoSub", "EnglishSub", "HindiSub"});
        Iterable codecTags = CollectionsKt.listOf(new String[]{"x264", "x265", "H264", "HEVC", "AVC"});
        int index$iv = 0;
        Iterator it = parts.iterator();
        while (true) {
            if (!it.hasNext()) {
                audioTags = audioTags2;
                index$iv = -1;
                break;
            }
            Object item$iv = it.next();
            String part = (String) item$iv;
            List $this$any$iv = qualityTags2;
            if (!($this$any$iv instanceof Collection) || !$this$any$iv.isEmpty()) {
                Iterator it2 = $this$any$iv.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        qualityTags = qualityTags2;
                        audioTags = audioTags2;
                        z5 = false;
                        break;
                    }
                    Object element$iv = it2.next();
                    String tag = (String) element$iv;
                    qualityTags = qualityTags2;
                    audioTags = audioTags2;
                    if (StringsKt.contains(part, tag, true)) {
                        z5 = true;
                        break;
                    }
                    qualityTags2 = qualityTags;
                    audioTags2 = audioTags;
                }
            } else {
                qualityTags = qualityTags2;
                audioTags = audioTags2;
                z5 = false;
            }
            if (z5) {
                break;
            }
            index$iv++;
            qualityTags2 = qualityTags;
            audioTags2 = audioTags;
        }
        List $this$indexOfLast$iv2 = parts;
        int $i$f$indexOfLast2 = 0;
        ListIterator iterator$iv = $this$indexOfLast$iv2.listIterator($this$indexOfLast$iv2.size());
        while (true) {
            if (!iterator$iv.hasPrevious()) {
                endIndex = -1;
                break;
            }
            String part2 = (String) iterator$iv.previous();
            Iterable $this$any$iv2 = subTags;
            if (!($this$any$iv2 instanceof Collection) || !((Collection) $this$any$iv2).isEmpty()) {
                Iterator it3 = $this$any$iv2.iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        $this$indexOfLast$iv = $this$indexOfLast$iv2;
                        $i$f$indexOfLast = $i$f$indexOfLast2;
                        z = false;
                        break;
                    }
                    Object element$iv2 = it3.next();
                    String tag2 = (String) element$iv2;
                    $this$indexOfLast$iv = $this$indexOfLast$iv2;
                    $i$f$indexOfLast = $i$f$indexOfLast2;
                    if (StringsKt.contains(part2, tag2, true)) {
                        z = true;
                        break;
                    }
                    $this$indexOfLast$iv2 = $this$indexOfLast$iv;
                    $i$f$indexOfLast2 = $i$f$indexOfLast;
                }
            } else {
                $this$indexOfLast$iv = $this$indexOfLast$iv2;
                $i$f$indexOfLast = $i$f$indexOfLast2;
                z = false;
            }
            if (z) {
                z2 = true;
            } else {
                List $this$any$iv3 = audioTags;
                if (!($this$any$iv3 instanceof Collection) || !$this$any$iv3.isEmpty()) {
                    Iterator it4 = $this$any$iv3.iterator();
                    while (true) {
                        if (!it4.hasNext()) {
                            z3 = false;
                            break;
                        }
                        Object element$iv3 = it4.next();
                        String tag3 = (String) element$iv3;
                        Iterable $this$any$iv4 = $this$any$iv3;
                        if (StringsKt.contains(part2, tag3, true)) {
                            z3 = true;
                            break;
                        }
                        $this$any$iv3 = $this$any$iv4;
                    }
                } else {
                    z3 = false;
                }
                if (z3) {
                    z2 = true;
                } else {
                    Iterable $this$any$iv5 = codecTags;
                    if (!($this$any$iv5 instanceof Collection) || !((Collection) $this$any$iv5).isEmpty()) {
                        Iterator it5 = $this$any$iv5.iterator();
                        while (true) {
                            if (!it5.hasNext()) {
                                z4 = false;
                                break;
                            }
                            Object element$iv4 = it5.next();
                            String tag4 = (String) element$iv4;
                            Iterable $this$any$iv6 = $this$any$iv5;
                            if (StringsKt.contains(part2, tag4, true)) {
                                z4 = true;
                                break;
                            }
                            $this$any$iv5 = $this$any$iv6;
                        }
                    } else {
                        z4 = false;
                    }
                    if (z4) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                }
            }
            if (z2) {
                endIndex = iterator$iv.nextIndex();
                break;
            }
            $this$indexOfLast$iv2 = $this$indexOfLast$iv;
            $i$f$indexOfLast2 = $i$f$indexOfLast;
        }
        if (index$iv == -1 || endIndex == -1 || endIndex < index$iv) {
            return index$iv != -1 ? CollectionsKt.joinToString$default(parts.subList(index$iv, parts.size()), ".", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null) : CollectionsKt.joinToString$default(CollectionsKt.takeLast(parts, 3), ".", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
        }
        return CollectionsKt.joinToString$default(parts.subList(index$iv, endIndex + 1), ".", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
    }
}
