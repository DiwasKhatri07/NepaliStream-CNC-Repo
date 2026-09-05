package com.phisher98;

import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StreamPlayStremioAddon.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/StreamPlay/classes.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.phisher98.StreamPlayStremioAddonSettings$getDynamicStremioMap$1$1", f = "StreamPlayStremioAddon.kt", i = {}, l = {85, 86, 87}, m = "invokeSuspend", n = {}, nl = {86, 87, 84}, s = {}, v = 2)
final class StreamPlayStremioAddonSettings$getDynamicStremioMap$1$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ StreamPlayStremioAddon $addon;
    final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
    final /* synthetic */ Integer $episode;
    final /* synthetic */ String $imdbId;
    final /* synthetic */ Integer $season;
    final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
    int label;

    /* JADX INFO: compiled from: StreamPlayStremioAddon.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[StreamPlayStremioAddonType.values().length];
            try {
                iArr[StreamPlayStremioAddonType.SUBTITLE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[StreamPlayStremioAddonType.TORRENT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[StreamPlayStremioAddonType.HTTPS.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[StreamPlayStremioAddonType.DEBRID.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StreamPlayStremioAddonSettings$getDynamicStremioMap$1$1(StreamPlayStremioAddon streamPlayStremioAddon, String str, Integer num, Integer num2, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, Continuation<? super StreamPlayStremioAddonSettings$getDynamicStremioMap$1$1> continuation) {
        super(1, continuation);
        this.$addon = streamPlayStremioAddon;
        this.$imdbId = str;
        this.$season = num;
        this.$episode = num2;
        this.$subtitleCallback = function1;
        this.$callback = function2;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new StreamPlayStremioAddonSettings$getDynamicStremioMap$1$1(this.$addon, this.$imdbId, this.$season, this.$episode, this.$subtitleCallback, this.$callback, continuation);
    }

    public final Object invoke(Continuation<? super Unit> continuation) {
        return create(continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    public final Object invokeSuspend(Object $result) throws NoWhenBranchMatchedException {
        Object objInvokeStremioSubtitlesGlobal;
        Object objInvokeStremioTorrentsGlobal;
        Object objInvokeStreamioStreamsGlobal;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                switch (WhenMappings.$EnumSwitchMapping$0[this.$addon.getType().ordinal()]) {
                    case 1:
                        this.label = 1;
                        objInvokeStremioSubtitlesGlobal = StreamPlayStremioAddonKt.invokeStremioSubtitlesGlobal(this.$addon.getName(), this.$addon.getUrl(), this.$imdbId, this.$season, this.$episode, this.$subtitleCallback, (Continuation) this);
                        if (objInvokeStremioSubtitlesGlobal == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    case 2:
                        this.label = 2;
                        objInvokeStremioTorrentsGlobal = StreamPlayStremioAddonKt.invokeStremioTorrentsGlobal(this.$addon.getName(), this.$addon.getUrl(), this.$imdbId, this.$season, this.$episode, this.$callback, (Continuation) this);
                        if (objInvokeStremioTorrentsGlobal == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    case 3:
                    case 4:
                        this.label = 3;
                        objInvokeStreamioStreamsGlobal = StreamPlayStremioAddonKt.invokeStreamioStreamsGlobal(this.$addon.getName(), this.$addon.getUrl(), this.$imdbId, this.$season, this.$episode, this.$subtitleCallback, this.$callback, (Continuation) this);
                        if (objInvokeStreamioStreamsGlobal == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    default:
                        throw new NoWhenBranchMatchedException();
                }
            case 1:
                ResultKt.throwOnFailure($result);
                objInvokeStremioSubtitlesGlobal = $result;
                return Unit.INSTANCE;
            case 2:
                ResultKt.throwOnFailure($result);
                objInvokeStremioTorrentsGlobal = $result;
                return Unit.INSTANCE;
            case 3:
                ResultKt.throwOnFailure($result);
                objInvokeStreamioStreamsGlobal = $result;
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
