package com.phisher98;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: StreamPlayParser.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/StreamPlay/classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0018\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0018\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J=\u0010\u000e\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/phisher98/KisskhSubtitle;", "", "src", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "label", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getSrc", "()Ljava/lang/String;", "getLabel", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class KisskhSubtitle {

    @Nullable
    private final String label;

    @Nullable
    private final String src;

    public static /* synthetic */ KisskhSubtitle copy$default(KisskhSubtitle kisskhSubtitle, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = kisskhSubtitle.src;
        }
        if ((i & 2) != 0) {
            str2 = kisskhSubtitle.label;
        }
        return kisskhSubtitle.copy(str, str2);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getSrc() {
        return this.src;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getLabel() {
        return this.label;
    }

    @NotNull
    public final KisskhSubtitle copy(@JsonProperty("src") @Nullable String src, @JsonProperty("label") @Nullable String label) {
        return new KisskhSubtitle(src, label);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof KisskhSubtitle)) {
            return false;
        }
        KisskhSubtitle kisskhSubtitle = (KisskhSubtitle) other;
        return Intrinsics.areEqual(this.src, kisskhSubtitle.src) && Intrinsics.areEqual(this.label, kisskhSubtitle.label);
    }

    public int hashCode() {
        return ((this.src == null ? 0 : this.src.hashCode()) * 31) + (this.label != null ? this.label.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "KisskhSubtitle(src=" + this.src + ", label=" + this.label + ')';
    }

    public KisskhSubtitle(@JsonProperty("src") @Nullable String src, @JsonProperty("label") @Nullable String label) {
        this.src = src;
        this.label = label;
    }

    @Nullable
    public final String getSrc() {
        return this.src;
    }

    @Nullable
    public final String getLabel() {
        return this.label;
    }
}
