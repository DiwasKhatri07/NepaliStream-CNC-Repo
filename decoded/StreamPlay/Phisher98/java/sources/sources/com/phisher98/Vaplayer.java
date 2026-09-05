package com.phisher98;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: StreamPlayParser.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StreamPlay/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u001e\b\u0003\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003JC\u0010\u0012\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u001e\b\u0003\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\tHÆ\u0001J\u0014\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004J\n\u0010\u0018\u001a\u00020\u0019HÖ\u0081\u0004R'\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR-\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/phisher98/Vaplayer;", "", "data", "Lcom/phisher98/VaplayerData;", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "defaultSubs", "", "Lcom/phisher98/VaplayerSub;", "default_subs", "<init>", "(Lcom/phisher98/VaplayerData;Ljava/util/List;)V", "getData", "()Lcom/phisher98/VaplayerData;", "getDefaultSubs", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class Vaplayer {

    @JsonProperty("data")
    @Nullable
    private final VaplayerData data;

    @JsonProperty("default_subs")
    @Nullable
    private final List<VaplayerSub> defaultSubs;

    /* JADX WARN: Multi-variable type inference failed */
    public Vaplayer() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Vaplayer copy$default(Vaplayer vaplayer, VaplayerData vaplayerData, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            vaplayerData = vaplayer.data;
        }
        if ((i & 2) != 0) {
            list = vaplayer.defaultSubs;
        }
        return vaplayer.copy(vaplayerData, list);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final VaplayerData getData() {
        return this.data;
    }

    @Nullable
    public final List<VaplayerSub> component2() {
        return this.defaultSubs;
    }

    @NotNull
    public final Vaplayer copy(@JsonProperty("data") @Nullable VaplayerData data, @JsonProperty("default_subs") @Nullable List<VaplayerSub> defaultSubs) {
        return new Vaplayer(data, defaultSubs);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Vaplayer)) {
            return false;
        }
        Vaplayer vaplayer = (Vaplayer) other;
        return Intrinsics.areEqual(this.data, vaplayer.data) && Intrinsics.areEqual(this.defaultSubs, vaplayer.defaultSubs);
    }

    public int hashCode() {
        return ((this.data == null ? 0 : this.data.hashCode()) * 31) + (this.defaultSubs != null ? this.defaultSubs.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "Vaplayer(data=" + this.data + ", defaultSubs=" + this.defaultSubs + ')';
    }

    public Vaplayer(@JsonProperty("data") @Nullable VaplayerData data, @JsonProperty("default_subs") @Nullable List<VaplayerSub> list) {
        this.data = data;
        this.defaultSubs = list;
    }

    public /* synthetic */ Vaplayer(VaplayerData vaplayerData, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : vaplayerData, (i & 2) != 0 ? null : list);
    }

    @Nullable
    public final VaplayerData getData() {
        return this.data;
    }

    @Nullable
    public final List<VaplayerSub> getDefaultSubs() {
        return this.defaultSubs;
    }
}
