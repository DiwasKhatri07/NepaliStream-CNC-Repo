package com.phisher98;

import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.mvvm.ArchComponentExtKt;
import com.lagradost.cloudstream3.mvvm.Resource;
import com.lagradost.cloudstream3.utils.ExtractorApiKt;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.cloudstream3.utils.M3u8Helper;
import com.lagradost.cloudstream3.utils.Qualities;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: KisskhProvider.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/KisskhProvider/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\n"}, d2 = {"<anonymous>", "Lcom/lagradost/cloudstream3/mvvm/Resource;", "", "link", ""}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.phisher98.KisskhProvider$loadLinks$2$1", f = "KisskhProvider.kt", i = {0}, l = {276}, m = "invokeSuspend", n = {"link"}, nl = {305}, s = {"L$0"}, v = 2)
final class KisskhProvider$loadLinks$2$1 extends SuspendLambda implements Function2<String, Continuation<? super Resource<? extends Unit>>, Object> {
    final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
    final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ KisskhProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    KisskhProvider$loadLinks$2$1(KisskhProvider kisskhProvider, Function1<? super ExtractorLink, Unit> function1, Function1<? super SubtitleFile, Unit> function2, Continuation<? super KisskhProvider$loadLinks$2$1> continuation) {
        super(2, continuation);
        this.this$0 = kisskhProvider;
        this.$callback = function1;
        this.$subtitleCallback = function2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> kisskhProvider$loadLinks$2$1 = new KisskhProvider$loadLinks$2$1(this.this$0, this.$callback, this.$subtitleCallback, continuation);
        kisskhProvider$loadLinks$2$1.L$0 = obj;
        return kisskhProvider$loadLinks$2$1;
    }

    public final Object invoke(String str, Continuation<? super Resource<Unit>> continuation) {
        return create(str, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: renamed from: com.phisher98.KisskhProvider$loadLinks$2$1$1 */
    /* JADX INFO: compiled from: KisskhProvider.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.KisskhProvider$loadLinks$2$1$1", f = "KisskhProvider.kt", i = {}, l = {278, 286, 298}, m = "invokeSuspend", n = {}, nl = {283, 285, 305}, s = {}, v = 2)
    @SourceDebugExtension({"SMAP\nKisskhProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 KisskhProvider.kt\ncom/phisher98/KisskhProvider$loadLinks$2$1$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,441:1\n2068#2,2:442\n*S KotlinDebug\n*F\n+ 1 KisskhProvider.kt\ncom/phisher98/KisskhProvider$loadLinks$2$1$1\n*L\n283#1:442,2\n*E\n"})
    static final class C00051 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        final /* synthetic */ String $link;
        final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
        Object L$0;
        int label;
        final /* synthetic */ KisskhProvider this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00051(String str, KisskhProvider kisskhProvider, Function1<? super ExtractorLink, Unit> function1, Function1<? super SubtitleFile, Unit> function2, Continuation<? super C00051> continuation) {
            super(1, continuation);
            this.$link = str;
            this.this$0 = kisskhProvider;
            this.$callback = function1;
            this.$subtitleCallback = function2;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C00051(this.$link, this.this$0, this.$callback, this.$subtitleCallback, continuation);
        }

        public final Object invoke(Continuation<? super Unit> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:23:0x00a2 A[LOOP:0: B:21:0x009c->B:23:0x00a2, LOOP_END] */
        public final Object invokeSuspend(Object $result) {
            String strSubstringBefore$default;
            Object objNewExtractorLink;
            Function1<ExtractorLink, Unit> function1;
            Object objGenerateM3u8$default;
            Function1<ExtractorLink, Unit> function2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    String str = this.$link;
                    if (str != null && StringsKt.contains$default(str, ".m3u8", false, 2, (Object) null)) {
                        this.label = 1;
                        objGenerateM3u8$default = M3u8Helper.Companion.generateM3u8$default(M3u8Helper.Companion, this.this$0.getName(), MainAPIKt.fixUrl(this.this$0, this.$link), this.this$0.getMainUrl() + '/', (Integer) null, MapsKt.mapOf(TuplesKt.to("Origin", this.this$0.getMainUrl())), (String) null, (Continuation) this, 40, (Object) null);
                        if (objGenerateM3u8$default == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        Iterable $this$forEach$iv = (Iterable) objGenerateM3u8$default;
                        function2 = this.$callback;
                        for (Object element$iv : $this$forEach$iv) {
                            function2.invoke(element$iv);
                        }
                        Unit unit = Unit.INSTANCE;
                    } else {
                        String str2 = this.$link;
                        if (str2 != null && StringsKt.contains$default(str2, "mp4", false, 2, (Object) null)) {
                            Function1<ExtractorLink, Unit> function3 = this.$callback;
                            this.L$0 = function3;
                            this.label = 2;
                            objNewExtractorLink = ExtractorApiKt.newExtractorLink(this.this$0.getName(), this.this$0.getName(), MainAPIKt.fixUrl(this.this$0, this.$link), ExtractorApiKt.getINFER_TYPE(), new AnonymousClass1(this.this$0, null), (Continuation) this);
                            if (objNewExtractorLink == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            function1 = function3;
                            function1.invoke(objNewExtractorLink);
                            Unit unit2 = Unit.INSTANCE;
                        } else {
                            String str3 = this.$link;
                            if (str3 == null || (strSubstringBefore$default = StringsKt.substringBefore$default(str3, "=http", (String) null, 2, (Object) null)) == null) {
                                return Unit.INSTANCE;
                            }
                            this.label = 3;
                            if (ExtractorApiKt.loadExtractor(strSubstringBefore$default, this.this$0.getMainUrl() + '/', this.$subtitleCallback, this.$callback, (Continuation) this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                    }
                    return Unit.INSTANCE;
                case 1:
                    ResultKt.throwOnFailure($result);
                    objGenerateM3u8$default = $result;
                    Iterable $this$forEach$iv2 = (Iterable) objGenerateM3u8$default;
                    function2 = this.$callback;
                    while (r4.hasNext()) {
                        function2.invoke(element$iv);
                    }
                    Unit unit3 = Unit.INSTANCE;
                    return Unit.INSTANCE;
                case 2:
                    function1 = (Function1) this.L$0;
                    ResultKt.throwOnFailure($result);
                    objNewExtractorLink = $result;
                    function1.invoke(objNewExtractorLink);
                    Unit unit4 = Unit.INSTANCE;
                    return Unit.INSTANCE;
                case 3:
                    ResultKt.throwOnFailure($result);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: renamed from: com.phisher98.KisskhProvider$loadLinks$2$1$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: KisskhProvider.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
        @DebugMetadata(c = "com.phisher98.KisskhProvider$loadLinks$2$1$1$1", f = "KisskhProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
        static final class AnonymousClass1 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
            private /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ KisskhProvider this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(KisskhProvider kisskhProvider, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = kisskhProvider;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> anonymousClass1 = new AnonymousClass1(this.this$0, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            public final Object invoke(ExtractorLink extractorLink, Continuation<? super Unit> continuation) {
                return create(extractorLink, continuation).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object $result) {
                ExtractorLink $this$newExtractorLink = (ExtractorLink) this.L$0;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        $this$newExtractorLink.setReferer(this.this$0.getMainUrl());
                        $this$newExtractorLink.setQuality(Qualities.P720.getValue());
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
    }

    public final Object invokeSuspend(Object $result) {
        String link = (String) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.L$0 = SpillingKt.nullOutSpilledVariable(link);
                this.label = 1;
                Object objSafeApiCall = ArchComponentExtKt.safeApiCall(new C00051(link, this.this$0, this.$callback, this.$subtitleCallback, null), (Continuation) this);
                if (objSafeApiCall == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return objSafeApiCall;
            case 1:
                ResultKt.throwOnFailure($result);
                return $result;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
