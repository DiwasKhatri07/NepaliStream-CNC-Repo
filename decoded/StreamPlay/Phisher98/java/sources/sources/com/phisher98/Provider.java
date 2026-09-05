package com.phisher98;

import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ProvidersList.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StreamPlay/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B¸\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u009e\u0001\u0010\u0005\u001a\u0099\u0001\b\u0001\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\u0004\u0012\u0004\b\b(\t\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n¢\u0006\f\b\b\u0012\b\b\u0004\u0012\u0004\b\b(\r\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\f0\n¢\u0006\f\b\b\u0012\b\b\u0004\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\b\u0012\b\b\u0004\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\b\u0012\b\b\u0004\u0012\u0004\b\b(\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006¢\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J¦\u0001\u0010\u001d\u001a\u0099\u0001\b\u0001\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\u0004\u0012\u0004\b\b(\t\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n¢\u0006\f\b\b\u0012\b\b\u0004\u0012\u0004\b\b(\r\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\f0\n¢\u0006\f\b\b\u0012\b\b\u0004\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\b\u0012\b\b\u0004\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\b\u0012\b\b\u0004\u0012\u0004\b\b(\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0019JÅ\u0001\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032 \u0001\b\u0002\u0010\u0005\u001a\u0099\u0001\b\u0001\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\u0004\u0012\u0004\b\b(\t\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n¢\u0006\f\b\b\u0012\b\b\u0004\u0012\u0004\b\b(\r\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\f0\n¢\u0006\f\b\b\u0012\b\b\u0004\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\b\u0012\b\b\u0004\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\b\u0012\b\b\u0004\u0012\u0004\b\b(\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0014\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010#\u001a\u00020$HÖ\u0081\u0004J\n\u0010%\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R«\u0001\u0010\u0005\u001a\u0099\u0001\b\u0001\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\u0004\u0012\u0004\b\b(\t\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n¢\u0006\f\b\b\u0012\b\b\u0004\u0012\u0004\b\b(\r\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\f0\n¢\u0006\f\b\b\u0012\b\b\u0004\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\b\u0012\b\b\u0004\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\b\u0012\b\b\u0004\u0012\u0004\b\b(\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019¨\u0006&"}, d2 = {"Lcom/phisher98/Provider;", "", "id", "", "name", "invoke", "Lkotlin/Function6;", "Lcom/phisher98/StreamPlay$LinkData;", "Lkotlin/ParameterName;", "res", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "subtitleCallback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "callback", "token", "dahmerMoviesAPI", "Lkotlin/coroutines/Continuation;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function6;)V", "getId", "()Ljava/lang/String;", "getName", "getInvoke", "()Lkotlin/jvm/functions/Function6;", "Lkotlin/jvm/functions/Function6;", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function6;)Lcom/phisher98/Provider;", "equals", "", "other", "hashCode", "", "toString", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class Provider {

    @NotNull
    private final String id;

    @NotNull
    private final Function6<StreamPlay.LinkData, Function1<? super SubtitleFile, Unit>, Function1<? super ExtractorLink, Unit>, String, String, Continuation<? super Unit>, Object> invoke;

    @NotNull
    private final String name;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Provider copy$default(Provider provider, String str, String str2, Function6 function6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = provider.id;
        }
        if ((i & 2) != 0) {
            str2 = provider.name;
        }
        if ((i & 4) != 0) {
            function6 = provider.invoke;
        }
        return provider.copy(str, str2, function6);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final Function6<StreamPlay.LinkData, Function1<? super SubtitleFile, Unit>, Function1<? super ExtractorLink, Unit>, String, String, Continuation<? super Unit>, Object> component3() {
        return this.invoke;
    }

    @NotNull
    public final Provider copy(@NotNull String id, @NotNull String name, @NotNull Function6<? super StreamPlay.LinkData, ? super Function1<? super SubtitleFile, Unit>, ? super Function1<? super ExtractorLink, Unit>, ? super String, ? super String, ? super Continuation<? super Unit>, ? extends Object> invoke) {
        return new Provider(id, name, invoke);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Provider)) {
            return false;
        }
        Provider provider = (Provider) other;
        return Intrinsics.areEqual(this.id, provider.id) && Intrinsics.areEqual(this.name, provider.name) && Intrinsics.areEqual(this.invoke, provider.invoke);
    }

    public int hashCode() {
        return (((this.id.hashCode() * 31) + this.name.hashCode()) * 31) + this.invoke.hashCode();
    }

    @NotNull
    public String toString() {
        return "Provider(id=" + this.id + ", name=" + this.name + ", invoke=" + this.invoke + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Provider(@NotNull String id, @NotNull String name, @NotNull Function6<? super StreamPlay.LinkData, ? super Function1<? super SubtitleFile, Unit>, ? super Function1<? super ExtractorLink, Unit>, ? super String, ? super String, ? super Continuation<? super Unit>, ? extends Object> function6) {
        this.id = id;
        this.name = name;
        this.invoke = function6;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final Function6<StreamPlay.LinkData, Function1<? super SubtitleFile, Unit>, Function1<? super ExtractorLink, Unit>, String, String, Continuation<? super Unit>, Object> getInvoke() {
        return this.invoke;
    }
}
