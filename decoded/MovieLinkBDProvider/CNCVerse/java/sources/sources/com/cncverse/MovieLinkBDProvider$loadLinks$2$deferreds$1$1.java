package com.cncverse;

import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.utils.ExtractorApiKt;
import com.lagradost.cloudstream3.utils.ExtractorLink;
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
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: MovieLinkBDProvider.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/MovieLinkBDProvider/CNCVerse/java/classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "com.cncverse.MovieLinkBDProvider$loadLinks$2$deferreds$1$1", f = "MovieLinkBDProvider.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 7, 7, 7, 7}, l = {648, 652, 656, 661, 666, 672, 675, 683}, m = "invokeSuspend", n = {"parts", "qualityLabel", "linkUrl", "refererUrl", "parts", "qualityLabel", "linkUrl", "refererUrl", "parts", "qualityLabel", "linkUrl", "refererUrl", "parts", "qualityLabel", "linkUrl", "refererUrl", "cdnUrl", "parts", "qualityLabel", "linkUrl", "refererUrl", "watchUrl", "parts", "qualityLabel", "linkUrl", "refererUrl", "extUrl", "parts", "qualityLabel", "linkUrl", "refererUrl", "extUrl", "parts", "qualityLabel", "linkUrl", "refererUrl"}, nl = {651, 655, 659, 664, 669, 674, 678, 687}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3"}, v = 2)
@SourceDebugExtension({"SMAP\nMovieLinkBDProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MovieLinkBDProvider.kt\ncom/cncverse/MovieLinkBDProvider$loadLinks$2$deferreds$1$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1186:1\n1#2:1187\n*E\n"})
final class MovieLinkBDProvider$loadLinks$2$deferreds$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $base;
    final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
    final /* synthetic */ String $item;
    final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    final /* synthetic */ MovieLinkBDProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MovieLinkBDProvider$loadLinks$2$deferreds$1$1(String str, String str2, MovieLinkBDProvider movieLinkBDProvider, Function1<? super ExtractorLink, Unit> function1, Function1<? super SubtitleFile, Unit> function2, Continuation<? super MovieLinkBDProvider$loadLinks$2$deferreds$1$1> continuation) {
        super(2, continuation);
        this.$item = str;
        this.$base = str2;
        this.this$0 = movieLinkBDProvider;
        this.$callback = function1;
        this.$subtitleCallback = function2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MovieLinkBDProvider$loadLinks$2$deferreds$1$1(this.$item, this.$base, this.this$0, this.$callback, this.$subtitleCallback, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        List parts;
        String string;
        String linkUrl;
        String strFixUrlDomain;
        String linkUrl2;
        String qualityLabel;
        String extUrl;
        List parts2;
        String linkUrl3;
        String qualityLabel2;
        String refererUrl;
        String linkUrl4;
        String qualityLabel3;
        String refererUrl2;
        String linkUrl5;
        String qualityLabel4;
        String refererUrl3;
        String it;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    parts = StringsKt.split$default(this.$item, new String[]{"|"}, false, 0, 6, (Object) null);
                    String str = (String) CollectionsKt.getOrNull(parts, 0);
                    if (str == null || (string = StringsKt.trim(str).toString()) == null) {
                        string = "";
                    }
                    String qualityLabel5 = string;
                    String str2 = (String) CollectionsKt.getOrNull(parts, 1);
                    if (str2 == null || (linkUrl = StringsKt.trim(str2).toString()) == null) {
                        linkUrl = StringsKt.trim(this.$item).toString();
                    }
                    if (linkUrl.length() > 0) {
                        String str3 = (String) CollectionsKt.getOrNull(parts, 2);
                        if (str3 == null || (it = StringsKt.trim(str3).toString()) == null || (strFixUrlDomain = this.this$0.fixUrlDomain(it, this.$base)) == null) {
                            strFixUrlDomain = this.$base;
                        }
                        String refererUrl4 = strFixUrlDomain;
                        String linkUrl6 = this.this$0.fixUrlDomain(linkUrl, this.$base);
                        if (StringsKt.contains$default(linkUrl6, "/getLink/", false, 2, (Object) null)) {
                            this.L$0 = SpillingKt.nullOutSpilledVariable(parts);
                            this.L$1 = SpillingKt.nullOutSpilledVariable(qualityLabel5);
                            this.L$2 = SpillingKt.nullOutSpilledVariable(linkUrl6);
                            this.L$3 = SpillingKt.nullOutSpilledVariable(refererUrl4);
                            this.label = 1;
                            if (this.this$0.resolveGetLink(linkUrl6, qualityLabel5, refererUrl4, this.$callback, (Continuation) this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            Unit unit = Unit.INSTANCE;
                        } else if (StringsKt.contains$default(linkUrl6, "/getWatch/", false, 2, (Object) null)) {
                            this.L$0 = SpillingKt.nullOutSpilledVariable(parts);
                            this.L$1 = SpillingKt.nullOutSpilledVariable(qualityLabel5);
                            this.L$2 = SpillingKt.nullOutSpilledVariable(linkUrl6);
                            this.L$3 = SpillingKt.nullOutSpilledVariable(refererUrl4);
                            this.label = 2;
                            if (this.this$0.resolveGetWatch(linkUrl6, qualityLabel5, refererUrl4, this.$callback, (Continuation) this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            Unit unit2 = Unit.INSTANCE;
                        } else if (StringsKt.contains$default(linkUrl6, "/file/", false, 2, (Object) null)) {
                            this.L$0 = SpillingKt.nullOutSpilledVariable(parts);
                            this.L$1 = SpillingKt.nullOutSpilledVariable(qualityLabel5);
                            this.L$2 = SpillingKt.nullOutSpilledVariable(linkUrl6);
                            this.L$3 = SpillingKt.nullOutSpilledVariable(refererUrl4);
                            this.label = 3;
                            if (this.this$0.resolveDirectFile(linkUrl6, qualityLabel5, refererUrl4, this.$callback, (Continuation) this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            Unit unit3 = Unit.INSTANCE;
                        } else if (StringsKt.startsWith$default(linkUrl6, "cdn:", false, 2, (Object) null)) {
                            String cdnUrl = StringsKt.removePrefix(linkUrl6, "cdn:");
                            this.L$0 = SpillingKt.nullOutSpilledVariable(parts);
                            this.L$1 = SpillingKt.nullOutSpilledVariable(qualityLabel5);
                            this.L$2 = SpillingKt.nullOutSpilledVariable(linkUrl6);
                            this.L$3 = SpillingKt.nullOutSpilledVariable(refererUrl4);
                            this.L$4 = SpillingKt.nullOutSpilledVariable(cdnUrl);
                            this.label = 4;
                            if (this.this$0.resolveCdnUrl(cdnUrl, qualityLabel5, refererUrl4, this.$callback, (Continuation) this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            linkUrl5 = linkUrl6;
                            qualityLabel4 = qualityLabel5;
                            refererUrl3 = refererUrl4;
                            Unit unit4 = Unit.INSTANCE;
                        } else if (StringsKt.startsWith$default(linkUrl6, "watch:", false, 2, (Object) null)) {
                            String watchUrl = StringsKt.removePrefix(linkUrl6, "watch:");
                            this.L$0 = SpillingKt.nullOutSpilledVariable(parts);
                            this.L$1 = SpillingKt.nullOutSpilledVariable(qualityLabel5);
                            this.L$2 = SpillingKt.nullOutSpilledVariable(linkUrl6);
                            this.L$3 = SpillingKt.nullOutSpilledVariable(refererUrl4);
                            this.L$4 = SpillingKt.nullOutSpilledVariable(watchUrl);
                            this.label = 5;
                            if (this.this$0.resolveWatchUrl(watchUrl, qualityLabel5, refererUrl4, this.$callback, (Continuation) this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            linkUrl4 = linkUrl6;
                            qualityLabel3 = qualityLabel5;
                            refererUrl2 = refererUrl4;
                            Unit unit5 = Unit.INSTANCE;
                        } else if (StringsKt.startsWith$default(linkUrl6, "ext:", false, 2, (Object) null)) {
                            String extUrl2 = StringsKt.removePrefix(linkUrl6, "ext:");
                            if (StringsKt.contains$default(extUrl2, "xcloud", false, 2, (Object) null) || StringsKt.contains$default(extUrl2, "mcloud", false, 2, (Object) null)) {
                                this.L$0 = SpillingKt.nullOutSpilledVariable(parts);
                                this.L$1 = SpillingKt.nullOutSpilledVariable(qualityLabel5);
                                this.L$2 = SpillingKt.nullOutSpilledVariable(linkUrl6);
                                this.L$3 = SpillingKt.nullOutSpilledVariable(refererUrl4);
                                this.L$4 = SpillingKt.nullOutSpilledVariable(extUrl2);
                                this.label = 6;
                                if (this.this$0.resolveXCloud(extUrl2, qualityLabel5, this.$callback, (Continuation) this) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                linkUrl2 = linkUrl6;
                                qualityLabel = qualityLabel5;
                                extUrl = refererUrl4;
                                Unit unit6 = Unit.INSTANCE;
                            } else {
                                try {
                                    this.L$0 = SpillingKt.nullOutSpilledVariable(parts);
                                    this.L$1 = SpillingKt.nullOutSpilledVariable(qualityLabel5);
                                    this.L$2 = SpillingKt.nullOutSpilledVariable(linkUrl6);
                                    this.L$3 = SpillingKt.nullOutSpilledVariable(refererUrl4);
                                    this.L$4 = SpillingKt.nullOutSpilledVariable(extUrl2);
                                    this.label = 7;
                                    if (ExtractorApiKt.loadExtractor(extUrl2, refererUrl4, this.$subtitleCallback, this.$callback, (Continuation) this) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    parts2 = parts;
                                    linkUrl3 = linkUrl6;
                                    qualityLabel2 = qualityLabel5;
                                    refererUrl = refererUrl4;
                                } catch (Exception e) {
                                    parts2 = parts;
                                    linkUrl3 = linkUrl6;
                                    qualityLabel2 = qualityLabel5;
                                    refererUrl = refererUrl4;
                                    Unit unit7 = Unit.INSTANCE;
                                }
                            }
                        } else {
                            this.L$0 = SpillingKt.nullOutSpilledVariable(parts);
                            this.L$1 = SpillingKt.nullOutSpilledVariable(qualityLabel5);
                            this.L$2 = SpillingKt.nullOutSpilledVariable(linkUrl6);
                            this.L$3 = SpillingKt.nullOutSpilledVariable(refererUrl4);
                            this.label = 8;
                            if (ExtractorApiKt.loadExtractor(linkUrl6, refererUrl4, this.$subtitleCallback, this.$callback, (Continuation) this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                    }
                    return Unit.INSTANCE;
                case 1:
                    ResultKt.throwOnFailure($result);
                    Unit unit8 = Unit.INSTANCE;
                    return Unit.INSTANCE;
                case 2:
                    ResultKt.throwOnFailure($result);
                    Unit unit9 = Unit.INSTANCE;
                    return Unit.INSTANCE;
                case 3:
                    ResultKt.throwOnFailure($result);
                    Unit unit10 = Unit.INSTANCE;
                    return Unit.INSTANCE;
                case 4:
                    refererUrl3 = (String) this.L$3;
                    linkUrl5 = (String) this.L$2;
                    qualityLabel4 = (String) this.L$1;
                    parts = (List) this.L$0;
                    ResultKt.throwOnFailure($result);
                    Unit unit11 = Unit.INSTANCE;
                    return Unit.INSTANCE;
                case 5:
                    refererUrl2 = (String) this.L$3;
                    linkUrl4 = (String) this.L$2;
                    qualityLabel3 = (String) this.L$1;
                    parts = (List) this.L$0;
                    ResultKt.throwOnFailure($result);
                    Unit unit12 = Unit.INSTANCE;
                    return Unit.INSTANCE;
                case 6:
                    extUrl = (String) this.L$3;
                    linkUrl2 = (String) this.L$2;
                    qualityLabel = (String) this.L$1;
                    parts = (List) this.L$0;
                    ResultKt.throwOnFailure($result);
                    Unit unit13 = Unit.INSTANCE;
                    return Unit.INSTANCE;
                case 7:
                    refererUrl = (String) this.L$3;
                    linkUrl3 = (String) this.L$2;
                    qualityLabel2 = (String) this.L$1;
                    parts2 = (List) this.L$0;
                    try {
                        ResultKt.throwOnFailure($result);
                    } catch (Exception e2) {
                        Unit unit14 = Unit.INSTANCE;
                    }
                    return Unit.INSTANCE;
                case 8:
                    ResultKt.throwOnFailure($result);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } catch (Exception e3) {
        }
    }
}
